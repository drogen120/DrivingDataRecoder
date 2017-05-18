package com.example.drivingdatarecoder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.lang.Math;
import java.math.BigDecimal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.Criteria;
import android.location.GpsStatus.NmeaListener;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.media.MediaScannerConnection;
import android.location.Location;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements LocationListener, SensorEventListener, OnClickListener, NmeaListener{

	private TextView gpsStateText, sensorStateText, accRateText,magRateText,gyroRateText, linearRateText, recodeStateText;
	private Button startstopButton;
	private CompoundButton videotoggle;
	private SurfaceView sView;
	private SurfaceHolder surfaceHolder;
	private LocationManager locManager;
	private boolean isFixed; //GPSの位置情報が安定しているかどうか
	//NS2S converts nanoseconds to seconds
	private static final float NS2S = 1.0f / 100000.0f;
	private float timestamp;
	
	private final Timer timer = new Timer(); 

	private SensorManager sensorManager;
	private Sensor accelerometer, linearaccelerometer, magnetometer, gyroscope, pressure;

	private PrintWriter gpsWriter, accelWriter, magneWriter, situWriter, gyroWriter, preWriter, modeWriter, linearaccWriter;
	private File gpsFile, accelFile, magneFile, situFile, gyroFile, audioFile, preFile, modeFile, linearaccFile;

	private MediaRecorder mediarecorder;


	private static final String COMMA = ",";
	private static final String NMEA_GPGSA = "$GPGSA";
    private static final String NMEA_GPGGA = "$GPGGA";
    private static final int GGA_UTC_COLUMN = 1;
	private static final int GSA_PDOP_COLUMN = 15;
	private static final int GSA_HDOP_COLUMN = 16;
	private static final int GSA_VDOP_COLUMN = 17;
	private static final int STEPTIME = 33569336;
	private ActivityModeClassifier modeClassifier;
	private Handler modehandler;
	private TimerTask task;



	private String nmeaPdop, nmeaHdop, nmeaVdop,nmeaUTC;

	private static final float START_ACCURACY_THRESH = 150f; //この精度でGPSの位置情報が取れたら測定開始できる[m]
	private static final long GPS_INTERVAL = 1000; //GPS測定の最短間隔[ミリ秒]
	private static final int SENSOR_RATE = 32;
	private static final int SENSOR_INTERVAL = 1000000/SENSOR_RATE; //加速度／磁気測定の（最短）間隔[マイクロ秒]
	private long accelRefTime; //加速度サンプリングレート検査用
	private long accelRecordTime;
    private long magRefTime; // used for check the magnitude sensor
    private long magRecordTime;
    private long gyroRefTime;
    private long gyroRecordTime;
	private long linearRefTime;
	private long linearaccRecordTime;
	//private long preRecordTime;
	private int accelCount, magCount, gyroCount, linearCount;    //同上
	private int accrateCount, magrateCount, gyrorateCount;
	private int ignore_count;
	private boolean videoRecode = true;
	private KalmanFilter average_filter_gred_x;
	private KalmanFilter average_filter_gred_y;
	private KalmanFilter average_filter_gred_z;
	private KalmanFilter average_filter_gred;
//	private MovingAverage average_filter_acc_x;
//	private MovingAverage average_filter_acc_y;
//	private MovingAverage average_filter_acc_z;
//	private MovingAverage average_filter_vgx;
//	private MovingAverage average_filter_vgy;
//	private MovingAverage average_filter_vgz;
//	private MovingAverage average_filter_vv;
	private KalmanFilter average_filter_acc_x;
	private KalmanFilter average_filter_acc_y;
	private KalmanFilter average_filter_acc_z;
	private KalmanFilter average_filter_vgx;
	private KalmanFilter average_filter_vgy;
	private KalmanFilter average_filter_vgz;
	private KalmanFilter average_filter_vv;
	private float mHighPassx,mLastx;
	private float mHighPassy,mLasty;
	private float mHighPassz,mLastz;
	private float mHighPassgx,mLastgx;
	private float mHighPassgy,mLastgy;
	private float mHighPassgz,mLastgz;
	//private float[] accelVals, magVals;
	private float[] rotationMatrix;
	private boolean roflag;
	private boolean ignore_flag;
	private float acc_v;
	private float vgx;
	private float vgy;
	private float vgz;
	private float gredx;
	private float gredy;
	private float gredz;
	private float sum_speed;
	private float average_speed;
	private static float average_gred;
	float[] magVals;

	private   Camera camera;

	private static final float MAGNETIC_MIN = 15f; //磁気センサが狂っているor外乱があることを検出
	private static final float MAGNETIC_MAX = 75f; //するための下限値と上限値[μT]

	private String SDCardPath; //一時ファイルや結果ファイルの保存ディレクトリのパス
	private String recordfilePath;
	private String startTime;  //測定開始時刻（文字列）
	private long startUnixTime; //測定開始時刻（記録時間計測用）

	private long uptime_nano; //スマホの電源が入ってからの時間。センサ類のtimestampの値が保存される変数。
	private long starttimestamp;
	private long recordseconds;

	private boolean logStarted; //測定中かどうか
	private boolean recordStarted;
	private boolean logCancelled; //キャンセルボタンでアプリが終了したかどうか
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		accRateText = (TextView)this.findViewById(R.id.accel_rate);
        //magRateText = (TextView)this.findViewById(R.id.magn_rate);
        gyroRateText = (TextView)this.findViewById(R.id.gyro_rate);
        gpsStateText = (TextView)this.findViewById(R.id.gps_state);
        linearRateText = (TextView)this.findViewById(R.id.pressure_state);
        recodeStateText = (TextView)this.findViewById(R.id.recodestate);
        sensorStateText = (TextView)this.findViewById(R.id.sensorstate);
        startstopButton = (Button)this.findViewById(R.id.buttonStart);
        startstopButton.setOnClickListener(this);
        videotoggle = (CompoundButton)this.findViewById(R.id.videotoggle);
        videotoggle.setChecked(true);
        videotoggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 状態が変更された
            	videoRecode = isChecked;
            	//Toast.makeText(MainActivity.this, "isChecked : " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });
        
		sView = (SurfaceView) findViewById(R.id.surfaceview);
		sView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		sView.getHolder().setFixedSize(1920, 1080);
		sView.getHolder().setKeepScreenOn(true);
		
//		average_filter_acc_x = new MovingAverage(5);
//		average_filter_acc_y = new MovingAverage(5);
//		average_filter_acc_z = new MovingAverage(5);
//		average_filter_vgx = new MovingAverage(10);
//		average_filter_vgy = new MovingAverage(10);
//		average_filter_vgz = new MovingAverage(10);
//		average_filter_vv = new MovingAverage(5);
		average_filter_gred_x = new KalmanFilter();
		average_filter_gred_y = new KalmanFilter();
		average_filter_gred_z = new KalmanFilter();
		average_filter_gred = new KalmanFilter();
		average_filter_acc_x = new KalmanFilter();
		average_filter_acc_y = new KalmanFilter();
		average_filter_acc_z = new KalmanFilter();
		average_filter_vgx = new KalmanFilter();
		average_filter_vgy = new KalmanFilter();
		average_filter_vgz = new KalmanFilter();
		average_filter_vv = new KalmanFilter();
		rotationMatrix = new float[16];
		vgx = 0;
		vgy = 0;
		vgz = 0;
		gredx = 0;
		gredy = 0;
		gredz = 0;
		sum_speed = 0;
		average_speed = 0;
		
        isFixed = false;

        accelRefTime = 0;
        accelRecordTime = 0;
        accelCount = 0;
        magCount = 0;
        magRefTime = 0;
        magRecordTime = 0;
        gyroRefTime = 0;
        gyroRecordTime = 0;
    	linearRefTime = 0;
		linearCount = 0;
		linearaccRecordTime = 0;
		
		accrateCount = 0;
		magrateCount = 0;
		gyrorateCount = 0;
		recordseconds = 0;
		ignore_count = 0;
		
		mHighPassx = 0;
		mHighPassy = 0;
		mHighPassz = 0;
		mLastx = 0;
		mLasty = 0;
		mLastz = 0;
		ignore_flag = true;
		mHighPassgx = 0;
		mHighPassgy = 0;
		mHighPassgz = 0;
		mLastgx = 0;
		mLastgy = 0;
		mLastgz = 0;

        logStarted = false;
        uptime_nano=0;
        recordStarted = false;

        nmeaPdop = "";
        nmeaHdop = "";
        nmeaVdop = "";

        gpsWriter = null;
        accelWriter = null;
        linearaccWriter = null;
        magneWriter = null;
        situWriter = null;
		preWriter = null;
		modeWriter = null;
        logCancelled = false;
        
        //GPSの起動
    	locManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setSpeedRequired(true);
    	if(locManager != null){
    		locManager.addNmeaListener(this); //NMEAも取得
	        //locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, GPS_INTERVAL , 0, this);
    		locManager.requestLocationUpdates(GPS_INTERVAL, 0, criteria, this, null);

	        //GPSがオンになっているか確認、表示
    		if(locManager.isProviderEnabled(LocationManager.GPS_PROVIDER) == false){
    			gpsStateText.setText(R.string.unavailable);
    		}else{
    			gpsStateText.setText(R.string.gps_unfix);
    		}
    	}
    	
        //enabledProviders = locManager.getProviders(criteria, true);
    	
		//加速度／磁気センサの起動 + gryo
        sensorManager = (SensorManager)this.getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> list = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if(list.size()>0){
        	accelerometer = list.get(0);
        	sensorManager.registerListener(this, accelerometer, SENSOR_INTERVAL);
        }
        list = sensorManager.getSensorList(Sensor.TYPE_LINEAR_ACCELERATION);
        if(list.size()>0){
        	linearaccelerometer = list.get(0);
        	sensorManager.registerListener(this, linearaccelerometer, SENSOR_INTERVAL);
        }
//        list = sensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
//        if(list.size()>0){
//        	magnetometer = list.get(0);
//        	sensorManager.registerListener(this, magnetometer, SENSOR_INTERVAL);
//        }
        list = sensorManager.getSensorList(Sensor.TYPE_GYROSCOPE_UNCALIBRATED);
        if (list.size() > 0){
            gyroscope = list.get(0);
            sensorManager.registerListener(this,gyroscope,SENSOR_INTERVAL);
        }
//		list = sensorManager.getSensorList(Sensor.TYPE_PRESSURE);
//		if (list.size() > 0){
//			pressure = list.get(0);
//			sensorManager.registerListener(this,pressure,SENSOR_INTERVAL);
//		}

        //ストレージのパスを取得
		SDCardPath = Environment.getExternalStorageDirectory().getPath() + "/" + this.getPackageName();
		File dir = new File(SDCardPath);
		if(!dir.exists()){ dir.mkdir(); }
		SDCardPath += "/";

        startstopButton.setVisibility(View.VISIBLE);

		//センサキャリブレーションの指示
		Toast.makeText(this, R.string.please_calibrate, Toast.LENGTH_LONG ).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
    private void createLocalDirectory(){
        this.recordfilePath = this.SDCardPath + getCurrentYYYYMMDDhhmmss();
        File dir = new File(recordfilePath);
        if(!dir.exists()){ dir.mkdir(); }
        recordfilePath += "/";
    }

	@Override
	public void onNmeaReceived(long timestamp, String nmea) {
		String[] data = nmea.split(COMMA , -1);
		if(data[0].equals(NMEA_GPGSA) ){
			nmeaPdop = data[GSA_PDOP_COLUMN ];
			nmeaHdop = data[GSA_HDOP_COLUMN ];
			nmeaVdop = data[GSA_VDOP_COLUMN ].split("\\*")[0];
		}else if(data[0].equals(this.NMEA_GPGGA)){
            this.nmeaUTC = data[this.GGA_UTC_COLUMN];
        }
	}

	@Override
	public void onClick(View v) {
		if(v==startstopButton){

            //測定開始時
			if(!logStarted){

				recodeStateText.setText(R.string.recoding);
				recodeStateText.setTextColor(Color.RED);

				startstopButton.setText(R.string.finish_logging);
				startstopButton.setTextColor(Color.BLUE);
				
				videotoggle.setVisibility(View.INVISIBLE);
				
				

				//測定開始時刻を取得
				startUnixTime = System.currentTimeMillis();

				
				modeClassifier = new ActivityModeClassifier();
				
				//記録開始
				logStarted = true;
				


			//測定終了時
			}else{
				logStarted = false;
				if(recordStarted){
				    stopSavedata();
				}

		    	//「記録しました」Toast
				Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show();

				//アプリの終了
				this.finish();
			}
		}
		
	}

	/*アプリ終了時*/
	@Override
	public void onDestroy(){
		//GPSとセンサを停止
    	if(locManager != null){
    		locManager.removeUpdates(this);
    		locManager.removeNmeaListener(this);
    	}
    	if(sensorManager != null){
    		sensorManager.unregisterListener(this);
    	}
    	
    	if(recordStarted)
    	{
    		//Writerのクローズ
    		if(gpsWriter!=null){ 
    			gpsWriter.close();
    			MediaScannerConnection.scanFile(this, new String[] { gpsFile.getAbsolutePath() }, null, null);
    		}
    		if(accelWriter!=null){ 
    			accelWriter.close(); 
    			MediaScannerConnection.scanFile(this, new String[] { accelFile.getAbsolutePath() }, null, null);
    		}
    		if(linearaccWriter!=null){ 
    			linearaccWriter.close(); 
    			MediaScannerConnection.scanFile(this, new String[] { linearaccFile.getAbsolutePath() }, null, null);
    		}
    		if(magneWriter!=null){ 
    			magneWriter.close(); 
    			MediaScannerConnection.scanFile(this, new String[] { magneFile.getAbsolutePath() }, null, null);
    		}
    		if(situWriter!=null){
    			situWriter.println();
    			situWriter.close(); 
    			MediaScannerConnection.scanFile(this, new String[] { situFile.getAbsolutePath() }, null, null);
    		}
    		if(gyroWriter!=null){ 
    			gyroWriter.close();
    			MediaScannerConnection.scanFile(this, new String[] { gyroFile.getAbsolutePath() }, null, null);
    		}
    		if(preWriter!=null){ 
    			preWriter.close();
    			MediaScannerConnection.scanFile(this, new String[] { preFile.getAbsolutePath() }, null, null);
    		}
    		if(modeWriter!=null){ 
    			modeWriter.close();
    			MediaScannerConnection.scanFile(this, new String[] { modeFile.getAbsolutePath() }, null, null);
    		}
    	}
		

    	//キャンセルボタンでor測定中にBACKボタンが押されてアプリが終了したなら記録用ファイルの破棄
    	if(logCancelled || logStarted){
    		if(gpsWriter!=null){
	    	    gpsFile.delete();
    		}
    		if(accelFile!=null){
	    	    accelFile.delete();
    		}
    		if(magneFile!=null){
	    	    magneFile.delete();
    		}
    		if(gyroFile!=null){
                gyroFile.delete();
    		}
    		if(situFile!=null){
	    	    situFile.delete();
    		}
    		if(videoRecode!= false && audioFile!=null){
			    audioFile.delete();
    		}
    		if(preFile!=null){
			    preFile.delete();
    		}
    		if(modeFile!=null){
    			modeFile.delete();
    		}
    		if(linearaccFile!=null){
    			linearaccFile.delete();
    		}
    	}

		super.onDestroy();
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		//条件入力時
		if(!logStarted){
			starttimestamp = event.timestamp;
			//磁気（or磁気センサ）の異常を検出
			if(event.sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD){
//				float norm = (float) Math.sqrt(event.values[0]*event.values[0] + event.values[1]*event.values[1] + event.values[2]*event.values[2]);
//				if(MAGNETIC_MIN < norm && norm < MAGNETIC_MAX){
//					sensorStateText.setText(R.string.sensorstate_label);
//				}else{
//					sensorStateText.setText(R.string.unavailable);
//				}
//
//                if (magRefTime == 0){
//                    magRefTime = event.timestamp;
//                }else{
//                    long elasp_e = event.timestamp - magRefTime;
//                    magCount++;
//                    if(elasp_e > 999999999) {
//                        magRateText.setText(magCount + "HZ");
//                        magCount = 0;
//                        magRefTime = event.timestamp;
//                    }
//                }

			//加速度センサのサンプリングレートの異常を検出
			}else if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER ){
				if(accelRefTime == 0){
                        accelRefTime = event.timestamp;
                    }else{
                        long elapse = event.timestamp - accelRefTime;
                        accelCount++;
                        if(elapse > 999999999/*[nsec]*/){

                        accRateText.setText(accelCount + "HZ");
						if(accelCount < 20 || 60 < accelCount){ //22Hz以下もしくは42Hz以上の時
							sensorStateText.setText(R.string.unavailable );
						}else{
							sensorStateText.setText(R.string.sensorstate_label);
						}
						accelCount = 0;
						accelRefTime = event.timestamp;
					}
				}
			// gyro scope data
            } else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE_UNCALIBRATED){
                if(gyroRefTime == 0){
                    gyroRefTime = event.timestamp;
                }else{
                    long elapse = event.timestamp - gyroRefTime;
                    gyroCount++;
                    if(elapse > 999999999/*[nsec]*/){

                        gyroRateText.setText(gyroCount + "HZ");
                        if(gyroCount < 20 || 60 < gyroCount){ //22Hz以下もしくは42Hz以上の時
                            sensorStateText.setText(R.string.unavailable );
                        }else{
                            sensorStateText.setText(R.string.sensorstate_label);
                        }
                        gyroCount = 0;
                        gyroRefTime = event.timestamp;
                    }
                }

            } else if(event.sensor.getType()==Sensor.TYPE_LINEAR_ACCELERATION ) {
				if (linearRefTime == 0) {
					linearRefTime = event.timestamp;
				} else {
					long elapse = event.timestamp - linearRefTime;
					linearCount++;
					if (elapse > 999999999/*[nsec]*/) {

						linearRateText.setText(linearCount + "HZ");
						if (linearCount < 20 || 60 < linearCount) { //22Hz以下もしくは42Hz以上の時
							sensorStateText.setText(R.string.unavailable);
						} else {
							sensorStateText.setText(R.string.sensorstate_label);
						}
						linearCount = 0;
						linearRefTime = event.timestamp;
					}
				}
			}

		//記録時（uptime_nanoにもtimestampを格納）
		}else{
			if (average_speed > -1 && !recordStarted){
				startSavedata();
			}
			if (average_speed <= -1 && recordStarted){
				stopSavedata();
			}
			//加速度
			if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
				uptime_nano = event.timestamp;

				if(recordStarted){
				accelWriter.println(
							//(event.timestamp - starttimestamp) / STEPTIME + COMMA   //UPTIMENANO .. long[nsec]
							event.timestamp + COMMA   //UPTIMENANO .. long[nsec]
							+ event.values[0] + COMMA //X軸加速度 .. float[m/s^2]
							+ event.values[1] + COMMA //Y軸加速度 .. float[m/s^2]
							+ event.values[2]);//Z軸加速度 .. float[m/s^2]
				}

				//LINEAR_ACCELERATION
			}else if(event.sensor.getType()==Sensor.TYPE_LINEAR_ACCELERATION){

				if(ignore_flag == true){
					ignore_count++;
					if(ignore_count > 2*SENSOR_RATE){
						ignore_flag = false;
					}
				}
				float vv = 0;
				float[] accelVals;
				if(ignore_flag == false){
					accelVals = event.values.clone();
				}
				else{
					accelVals = new float[]{0 ,0, 0};
				}
//				mHighPassx = highPass(accelVals[0], mLastx, mHighPassx);
//				mHighPassy = highPass(accelVals[1], mLasty, mHighPassy);
//				mHighPassz = highPass(accelVals[2], mLastz, mHighPassz);
//				mLastx = accelVals[0];
//				mLasty = accelVals[1];
//				mLastz = accelVals[2];
//				final float dT = 1.0f/(SENSOR_RATE-30);
//				average_filter_vgx.pushValue(mHighPassx);
//				average_filter_vgy.pushValue(mHighPassy);
//				average_filter_vgz.pushValue(mHighPassz);
//				accelVals[0] = average_filter_vgx.getValue();
//				accelVals[1] = average_filter_vgy.getValue();
//				accelVals[2] = average_filter_vgz.getValue();
//				vgx += accelVals[0]*dT;
//				vgy += accelVals[1]*dT;
//				vgz += accelVals[2]*dT;
//
//				vv = (float)Math.sqrt(vgx*vgx + vgy*vgy + vgz*vgz);
//				average_filter_vv.pushValue(vv);
//				average_speed = average_filter_vv.getValue();
//				linearRateText.setText(String.format("%.02f", average_speed)+"m/s");
				if(recordStarted){
					linearaccWriter.println(
							//(event.timestamp - starttimestamp) / STEPTIME + COMMA   //UPTIMENANO .. long[nsec]
							event.timestamp + COMMA   //UPTIMENANO .. long[nsec]
							+ event.values[0] + COMMA //X軸加速度 .. float[m/s^2]
							+ event.values[1] + COMMA //Y軸加速度 .. float[m/s^2]
							+ event.values[2] + COMMA //Z軸加速度 .. float[m/s^2]
					);
					Log.i("ACCELERATION", event.values[0] + COMMA //X軸加速度 .. float[m/s^2]
                                    + event.values[1] + COMMA //Y軸加速度 .. float[m/s^2]
                                    + event.values[2] + COMMA //Z軸加速度 .. float[m/s^2]);
                    );
//			    	BigDecimal x = new BigDecimal(average_speed);
//			    	BigDecimal y = new BigDecimal(average_gred);
//			    	x = x.setScale(1, BigDecimal.ROUND_HALF_UP);
//			    	y = y.setScale(2, BigDecimal.ROUND_HALF_UP);
//			    	situWriter.print(String.format("%02d%02d", (int)(x.floatValue()*10), (int)(y.floatValue()*10)) + ",");
//					situWriter.println(event.timestamp + COMMA
//							+ String.format("%.02f", average_speed));
				}

				//磁気
			}else if(event.sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD){

				
//				magVals = event.values.clone();
//				if(recordStarted){
//				magneWriter.println(
//							//(event.timestamp - starttimestamp) / STEPTIME + COMMA   //UPTIMENANO .. long[nsec]
//							event.timestamp + COMMA   //UPTIMENANO .. long[nsec]
//							+ event.values[0] + COMMA //X軸磁場 .. float[μT]
//							+ event.values[1] + COMMA //Y軸磁場 .. float[μT]
//							+ event.values[2] );    //Z軸磁場 .. float[μT]
//				}

			}else if(event.sensor.getType() == Sensor.TYPE_GYROSCOPE_UNCALIBRATED){
//				float[] gredVals;
//				if(ignore_flag == false){
//					gredVals = new float[]{event.values[0] ,event.values[1], event.values[2]};
//				}
//				else{
//					gredVals = new float[]{0 ,0, 0};
//				}
//				float vv = 0;
//				mHighPassgx = highPass(gredVals[0], mLastgx, mHighPassgx);
//				mHighPassgy = highPass(gredVals[1], mLastgy, mHighPassgy);
//				mHighPassgz = highPass(gredVals[2], mLastgz, mHighPassgz);
//				mLastgx = gredVals[0];
//				mLastgy = gredVals[1];
//				mLastgz = gredVals[2];
//
//				final float merge = 2.0f;
//				average_filter_gred_x.pushValue(mHighPassgx);
//				average_filter_gred_y.pushValue(mHighPassgy);
//				average_filter_gred_z.pushValue(mHighPassgz);
//				gredVals[0] = average_filter_gred_x.getValue();
//				gredVals[1] = average_filter_gred_y.getValue();
//				gredVals[2] = average_filter_gred_z.getValue();
//				gredx += gredVals[0]*merge;
//				gredy += gredVals[1]*merge;
//				gredz += gredVals[2]*merge;
//
//				vv = (float)Math.sqrt(gredx*gredx + gredy*gredy + gredz*gredz);
//				average_filter_gred.pushValue(vv);
//				vv = average_filter_gred.getValue();
//				average_gred = vv;
				if(recordStarted){
				gyroWriter.println(
							//(event.timestamp - starttimestamp) / STEPTIME + COMMA
							event.timestamp + COMMA   //UPTIMENANO .. long[nsec]
							+ event.values[0] + COMMA
							+ event.values[1] + COMMA
							+ event.values[2] + COMMA
							+ event.values[3] + COMMA
							+ event.values[4] + COMMA
							+ event.values[5]
							);
                Log.i("GYROSCOPE", (event.values[0] - event.values[3]) + COMMA
                        + (event.values[1] - event.values[4]) + COMMA
                        + (event.values[2] - event.values[5]) + COMMA);
				}
            }else if(event.sensor.getType() == Sensor.TYPE_PRESSURE){
//            	if(preCount < SENSOR_RATE){
//            		preWriter.println(
//            				//(event.timestamp - starttimestamp) / STEPTIME + COMMA   //UPTIMENANO .. long[nsec]
//            				event.timestamp + COMMA   //UPTIMENANO .. long[nsec]
//            				+ event.values[0] );
//            	}
			}
		}
		
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLocationChanged(Location loc) {
		//条件入力時
		if(!logStarted){
			//一定の精度が得られている場合のみ測定開始可能になる
			if(loc.hasAccuracy() && loc.getAccuracy() < START_ACCURACY_THRESH){
				gpsStateText.setText(R.string.gps_ok);
				if(isFixed == false){
					startstopButton.setVisibility(View.VISIBLE);
					isFixed = true;
				}
			}else{
				gpsStateText.setText(R.string.gps_unfix);
				if(isFixed == true){
					startstopButton.setVisibility(View.INVISIBLE);
					isFixed = false;
				}
			}
			if(loc.hasAccuracy()){
				gpsStateText.append(Integer.toString((int)loc.getAccuracy()));
			}


		//記録時（uptime_nanoが0の時は無効）DOPも並べて記録する
		}else{
			if(uptime_nano!=0){
				gpsWriter.println(
				  (uptime_nano - starttimestamp) + COMMA  //UPTIMENANO .. long[nsec]
				  + loc.getTime() + COMMA  //GPSTIME .. long[msec] ※UNIX時間
				  + (loc.hasSpeed() ? loc.getSpeed() : -1)+ COMMA //SPEED .. float[m/s] ※データ無しの場合は-1
				  + (float)loc.getLatitude() + COMMA //LAT .. double->float
				  + (float)loc.getLongitude() + COMMA //LON .. double->float
				  + (float)loc.getAltitude() + COMMA //ALT .. double->float
				  + loc.getBearing() + COMMA //BEARING .. float[deg]
				  + loc.getAccuracy() + COMMA //ACCURACY .. float[m]
				  + nmeaPdop + COMMA //PDOP[]
				  + nmeaHdop + COMMA //HDOP[]
				  + nmeaVdop + COMMA //VDOP[]
                  + this.nmeaUTC
				  );
				//modeClassifier.onGPSUpdate((loc.hasSpeed() ? loc.getSpeed() : -1));
			}
		}
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		gpsStateText.setText(R.string.gps_unfix);
		isFixed = false;
		locManager.addNmeaListener(this);
		locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, GPS_INTERVAL , 0, this);
	}

	@Override
	public void onProviderDisabled(String provider) {
		gpsStateText.setText(R.string.unavailable);
		isFixed = false;
	}
	
	/** 測定開始時の日付時刻をStringにして取得 **/
	public String getCurrentYYYYMMDDhhmm(){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; //MONTHは0-11で返されるため
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		return String.format("%04d%02d%02d%02d%02d",year,month,day,hour,minute);
	}
	
	public String getCurrentYYYYMMDDhhmmss(){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; //MONTHは0-11で返されるため
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		return String.format("%04d%02d%02d%02d%02d%02d",year,month,day,hour,minute,second);
	}
	
	// simple high-pass filter
	public float highPass(float current, float last, float filtered)
	{
		float a = 0.85f;
	    return a * (filtered + current - last);
	}
	
	public boolean startSavedata(){
		createLocalDirectory();
		//現在時刻と選択された運動モードを取得
		startTime = getCurrentYYYYMMDDhhmm();

		if(videoRecode == true){

			mediarecorder = new MediaRecorder();
			CamcorderProfile camProf = CamcorderProfile.get(CamcorderProfile.QUALITY_480P);
			mediarecorder.reset();
			mediarecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
			mediarecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
			mediarecorder.setOutputFormat(camProf.fileFormat);
			mediarecorder.setVideoFrameRate(camProf.videoFrameRate);
			mediarecorder.setVideoSize(camProf.videoFrameWidth, camProf.videoFrameHeight);
			mediarecorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);
			mediarecorder.setAudioEncoder(camProf.audioCodec);
			mediarecorder.setOrientationHint(90);
			mediarecorder.setVideoFrameRate(camProf.videoFrameRate);
			mediarecorder.setVideoEncodingBitRate(camProf.videoBitRate);
		}


		//記録用のファイルを用意し、1行目を記入
		try{
			gpsFile = new File(recordfilePath  + "GPS" + startTime + ".csv");
			accelFile = new File(recordfilePath + "Accel" + startTime + ".csv");
			magneFile = new File(recordfilePath + "Magne" + startTime + ".csv");
			gyroFile = new File(recordfilePath  + "Gryo" + startTime +".csv");
			preFile = new File(recordfilePath  + "Pre" + startTime +".csv");
			linearaccFile = new File(recordfilePath  + "linear" + startTime +".csv");
			modeFile = new File(recordfilePath  + "Mode" + startTime + ".csv");

			gpsWriter = new PrintWriter(new BufferedWriter(new FileWriter(gpsFile)));
			accelWriter = new PrintWriter(new BufferedWriter(new FileWriter(accelFile)));
			magneWriter = new PrintWriter(new BufferedWriter(new FileWriter(magneFile)));
			gyroWriter = new PrintWriter(new BufferedWriter(new FileWriter(gyroFile)));
			preWriter = new PrintWriter(new BufferedWriter(new FileWriter(preFile)));
			linearaccWriter = new PrintWriter(new BufferedWriter(new FileWriter(linearaccFile)));
			modeWriter = new PrintWriter(new BufferedWriter(new FileWriter(modeFile)));

			if(videoRecode == true){
				audioFile = new File(recordfilePath  + "Audio" + startTime +".mp4");
				audioFile.createNewFile();
				mediarecorder.setOutputFile(audioFile.getAbsolutePath());
				mediarecorder.setPreviewDisplay(sView.getHolder().getSurface());
				mediarecorder.prepare();
				mediarecorder.start();
			}

			gpsWriter.println("UPTIMENANO,GPSTIME,SPEED,LAT,LON,ALT,BEARING,ACCURACY,PDOP,HDOP,VDOP,GPSUTC");
			accelWriter.println("UPTIMENANO,Ax,Ay,Az");
			magneWriter.println("UPTIMENANO,Mx,My,Mz");
			gyroWriter.println("UPTIMENANO,Gx,Gy,Gz,drift_x,drift_y,drift_z");
			preWriter.println("UPTIMENANO,pressure");
			linearaccWriter.println("UPTIMENANO,acx,acy,acz");
			modeWriter.println("UPTIMENANO,MODE");


			//測定状況メモを記入
			situFile = new File(recordfilePath + "Situ" + startTime + ".txt");
			situWriter = new PrintWriter(new BufferedWriter(new FileWriter(situFile)));
			recordStarted = true;
		} catch (IOException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean stopSavedata(){
		recordStarted = false;
		if(videoRecode == true){
			mediarecorder.stop();
			mediarecorder.release();
			mediarecorder = null;
		    MediaScannerConnection.scanFile(this, new String[] { audioFile.getAbsolutePath() }, null, null);
		}
		//Writerのクローズ
    	if(gpsWriter!=null){ 
    		gpsWriter.close();
    		MediaScannerConnection.scanFile(this, new String[] { gpsFile.getAbsolutePath() }, null, null);
    	}
    	if(accelWriter!=null){ 
    		accelWriter.close(); 
    		MediaScannerConnection.scanFile(this, new String[] { accelFile.getAbsolutePath() }, null, null);
    	}
    	if(linearaccWriter!=null){ 
    		linearaccWriter.close(); 
    		MediaScannerConnection.scanFile(this, new String[] { linearaccFile.getAbsolutePath() }, null, null);
    	}
    	if(magneWriter!=null){ 
    		magneWriter.close(); 
    		MediaScannerConnection.scanFile(this, new String[] { magneFile.getAbsolutePath() }, null, null);
    	}
    	if(situWriter!=null){
    		situWriter.println();
    		situWriter.close(); 
    		MediaScannerConnection.scanFile(this, new String[] { situFile.getAbsolutePath() }, null, null);
    	}
        if(gyroWriter!=null){ 
        	gyroWriter.close();
        	MediaScannerConnection.scanFile(this, new String[] { gyroFile.getAbsolutePath() }, null, null);
        }
		if(preWriter!=null){ 
			preWriter.close();
			MediaScannerConnection.scanFile(this, new String[] { preFile.getAbsolutePath() }, null, null);
		}
		if(modeWriter!=null){ 
			modeWriter.close();
			MediaScannerConnection.scanFile(this, new String[] { modeFile.getAbsolutePath() }, null, null);
		}
		return true;
	}
}
