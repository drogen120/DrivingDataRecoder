package com.example.drivingdatarecoder;

import java.util.Calendar;
import java.util.LinkedList;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;


/**
	 * 移動モード推定
	 * 速度（GPSで得る）、加速度の大きさの{分散、DFTした1,2,3Hz成分}から決定木により判別
	 **/
	public class ActivityModeClassifier {
		//private final boolean WALK_FIXED_MODE;

		private final int CLASSIFY_INTERVAL = 32; //何サンプルごとにモード判定するか
		private final int accelFreq = 32;
		private int count; //↑を管理するためのカウンタ

		private LinkedList<Float> accelMagnitude; //加速度の大きさ（3軸の2乗和平方根）
		private LinkedList<Modeobject> dtResult;
		private DHMM1212_all dhmm = new DHMM1212_all();

		private FastFourierTransformer fft; //DFTを実現するクラス
		private Complex[] fftResult; //その結果格納場所
		private int[] m_dhmmResult;

		private float currentSpeed; //現在の速度
		private float acc_speed;

		//現在の移動モード
		public int activityMode;
		public Modeobject[] dhmmResult;
		

		/*コンストラクタ*/
		public ActivityModeClassifier(){
			//WALK_FIXED_MODE = isFixedMode;

			accelMagnitude = new LinkedList<Float>();
			dtResult = new LinkedList<Modeobject>();
			count = CLASSIFY_INTERVAL;

			fft = new FastFourierTransformer(DftNormalization.STANDARD);

			//currentSpeed = -1f;
			currentSpeed = 0f;

			activityMode = DT1212_all.MODE_OTHER ;
		}

		/*加速度の観測値を毎回受け取って大きさをバッファに保存（1秒分まで）＋周期的にモード判定*/
		public void onAccelUpdate(float valueX, float valueY, float valueZ){
			count++;
			accelMagnitude.offer( (float)Math.sqrt(valueX*valueX + valueY*valueY + valueZ*valueZ) );

			//System.out.print( Math.sqrt(valueX*valueX + valueY*valueY + valueZ*valueZ) ); //debug

			if(accelMagnitude.size() > accelFreq*2){
				accelMagnitude.poll();
				if(count >= CLASSIFY_INTERVAL){
					count=0;
					
					//分散
					float[] var = new float[2];
					CommonTool.aveAndVar(accelMagnitude, var);
					//DFT
					double[] d = new double[accelFreq];
					int i=0;
					for(float f: accelMagnitude.subList(accelMagnitude.size()-accelFreq, accelMagnitude.size())){ d[i]=f; i++; }
					fftResult = fft.transform(d, TransformType.FORWARD);
					//FFTの結果（複素数の列）f_0, f_1, f_2, ... f_(N-1)のうち、
					//f_kの絶対値の2乗（=実部の2乗+虚部の2乗）がk[Hz]成分のエネルギーを表す。
					double energy1Hz = Math.pow(fftResult[1].getReal(), 2) + Math.pow(fftResult[1].getImaginary(), 2);
					double energy2Hz = Math.pow(fftResult[2].getReal(), 2) + Math.pow(fftResult[2].getImaginary(), 2);
					double energy3Hz = Math.pow(fftResult[3].getReal(), 2) + Math.pow(fftResult[3].getImaginary(), 2);
					//特徴量を格納
					float[] features = {currentSpeed + acc_speed, var[1], (float)energy1Hz, (float)energy2Hz, (float)energy3Hz};
					//currentSpeed = -1f;
					//移動モードを判定
					//activityMode = DTped0827.classify(features);
					activityMode = DT1212_all.classify(features);
					Modeobject temp = new Modeobject(getCurrentYYYYMMDDhhmmss(), activityMode);
					dtResult.offer(temp);
					
					//if(WALK_FIXED_MODE && activityMode==DTped0827.MODE_RUN ){ activityMode = DTped0827.MODE_WALK ; } //モード固定モードの場合、「走る」になっても強制的に「歩く」に戻す

					//System.out.println(" : " + activityMode + "\t" + currentSpeed + "\t"+ features[1] + "\t"+ features[2] + "\t"+ features[3] + "\t"+ features[4]); //debug
					//System.out.println("," + currentSpeed + ((activityMode==DTped0827.MODE_OTHER ) ? ",0" : ",,0") ); //debug
				}
				//else{System.out.println();}//debug
			}
		}
		public void updateHMMResult(){
			Modeobject[] dttemp = dtResult.toArray(new Modeobject[0]);
		    int[] dtr = new int[dttemp.length];
		    for(int i = 0; i < dttemp.length; i++){
		    	dtr[i] = dttemp[i].getMode();
		    }
		    m_dhmmResult = dhmm.classify(dtr, DHMM1212_all.MODE_ALL );
		    //dhmmResult = new Modeobject[dttemp.length];
		    for(int i = 0; i < dttemp.length; i++){
		    	dttemp[i].setMode(m_dhmmResult[i]);
		    }
		    dhmmResult = dttemp.clone();
		}

		/*GPSの観測値を受け取ったら速度データを更新*/
		public void onGPSUpdate(float speed){
			currentSpeed = speed;
		}
		
		public void onSpeedUpdate(float v){
			if(v > 0.2){
			    acc_speed = v;
			}
			else{
				acc_speed = 0;
			}
		}
		
		private String getCurrentYYYYMMDDhhmmss(){
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1; //MONTHは0-11で返されるため
			int day = cal.get(Calendar.DAY_OF_MONTH);
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			int minute = cal.get(Calendar.MINUTE);
			int second = cal.get(Calendar.SECOND);
			return String.format("%04d%02d%02d%02d%02d%02d",year,month,day,hour,minute,second);
		}

	}