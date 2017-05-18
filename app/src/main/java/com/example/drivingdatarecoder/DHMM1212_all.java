package com.example.drivingdatarecoder;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import be.ac.ulg.montefiore.run.jahmm.Hmm;
import be.ac.ulg.montefiore.run.jahmm.OpdfInteger;
import be.ac.ulg.montefiore.run.jahmm.ObservationInteger;
import be.ac.ulg.montefiore.run.jahmm.ViterbiCalculator;

public class DHMM1212_all {

	//HMMの各状態の初期生起確率
	private final double[] pi  = {0.2, 0.2, 0.2, 0.2, 0.2};

	//HMMの遷移行列。(i,j)=状態iからjへの遷移確率
	private static final double TP_A = 0.99;
	private static final double TP_B = (1-TP_A)/4;
	private static final double TP_C = (1-TP_A)/3;
	private final double[][] a = {	 {TP_A, TP_B, TP_B, TP_B, TP_B},
									 {TP_B, TP_A, TP_B, TP_B, TP_B},
									 {TP_B, TP_B, TP_A, TP_B, TP_B},
									 {TP_C, TP_C, TP_C, TP_A,    0},
									 {TP_C, TP_C, TP_C,    0, TP_A} };

	//各状態における出力の確率分布
	/*ここを決定木学習結果のconfusionMatrixから計算して書き写す*/
	private static final double[] prob0 = {(double)1279/1332, (double)   0/1332, (double)   0/1332, (double)   2/1332, (double)  51/1332}; //正解交通モードStillに対する決定木の推定結果分布
	private static final double[] prob1 = {(double)  20/1428, (double)1381/1428, (double)  13/1428, (double)  11/1428, (double)   3/1428}; //正解交通モードWalkに対する決定木の推定結果分布
	private static final double[] prob2 = {(double)   0/1373, (double)  37/1373, (double)1324/1373, (double)  11/1373, (double)   1/1373}; //正解交通モードRunに対する決定木の推定結果分布
	private static final double[] prob3 = {(double)   9/1325, (double)  25/1325, (double)  14/1325, (double)1259/1325, (double)  18/1325}; //正解交通モードBikeに対する決定木の推定結果分布
	private static final double[] prob4 = {(double)  86/1329, (double)   1/1329, (double)   1/1329, (double)  99/1329, (double)1142/1329}; //正解交通モードMotorに対する決定木の推定結果分布
	private final List<OpdfInteger> opdfs = Arrays.asList(  new OpdfInteger(prob0),
															new OpdfInteger(prob1),
															new OpdfInteger(prob2),
															new OpdfInteger(prob3),
															new OpdfInteger(prob4) );

	//離散的な出力をするHMMのインスタンス
	private Hmm<ObservationInteger> hmm;

	//識別メソッドを切り替える引数
	public static final int MODE_ALL = 0;
	public static final int MODE_WINDOWED = 1;

	//識別メソッド2における窓（=DHMMへの入力）の長さ
	private final int INPUT_SEQ_LENGTH = 20;

	//コンストラクタにてHMMに各パラメータをセット
	public DHMM1212_all() {
		hmm = new Hmm<ObservationInteger>(pi, a, opdfs);
	}


	/** 識別メソッド **/
	public int[] classify(int[] input, int mode){
		if(mode==MODE_ALL){
			return this.classify01(input, null);
		}else if(mode==MODE_WINDOWED){
			return this.classify02(input, INPUT_SEQ_LENGTH);
		}else{
			return null;
		}
	}


	/** 識別メソッド1(Integer/int[], double[])
	 ** 決定木の識別結果の列inputをそのままDHMMへの入力として、
	 ** 交通モードを推定する。
	 **/

	//(Integer配列用)
	public int[] classify01(Integer[] input, double[] probReturn){

		//識別器への入力（決定木の推定結果のシーケンス）をVector<>に格納
		Vector<ObservationInteger> l = new Vector<ObservationInteger>();
		int n = input.length;
		for(int i=0; i<n; i++){
			l.add(new ObservationInteger(input[i].intValue()));
		}

		//Viterbiアルゴリズムを計算するためのインスタンスを生成隠れ状態の遷移を推定
		ViterbiCalculator vc = new ViterbiCalculator(l, this.hmm);
		//隠れ状態の遷移を推定し、その遷移における観測系列の観測確率をprobReturnに格納する
		if(probReturn!=null && probReturn.length>0){ probReturn[0] = vc.lnProbability(); }
		return vc.stateSequence();
	}

	//(int配列用)
	public int[] classify01(int[] input, double[] probReturn){
		//StringBuilder sb = new StringBuilder(); //debug

		//識別器への入力（決定木の推定結果のシーケンス）をVector<>に収納
		Vector<ObservationInteger> l = new Vector<ObservationInteger>();
		int n = input.length;
		for(int i=0; i<n; i++){
			l.add(new ObservationInteger(input[i]));
			//sb.append(l.elementAt(i).value); //debug
		}
		//sb.append("--"); //debug

		//Viterbiアルゴリズムを計算するためのインスタンスを生成隠れ状態の遷移を推定
		ViterbiCalculator vc = new ViterbiCalculator(l, this.hmm);
		//隠れ状態の遷移を推定し、その遷移における観測系列の観測確率をprobReturnに格納する
		if(probReturn!=null && probReturn.length>0){ probReturn[0] = vc.lnProbability();  /* sb.append(probReturn[0]); debug*/}

		//sb.append("--"); //debug
		//int[] res = vc.stateSequence(); //debug
		//for(int j=0; j<res.length; j++){ sb.append(res[j]); } //debug
		//System.out.println(sb.toString()); //debug

		return vc.stateSequence();
	}


	/** 識別メソッド2(Integer/int[], double[], int)
	 ** 決定木の識別結果n個の列をDHMM識別器への入力とする。
	 ** 0個目～n-1個目、1個目～n個目というように1個ずつずらしながら
	 ** それぞれのサンプルに対する推定モードをその尤度とともに出力する。
	 ** そして、それぞれのサンプルにおいて最も尤度の高いモードを最終的な推定モードとして選択する。
	 **/
	public int[] classify02(int[] dtResult, int inputLength){
		if(dtResult.length > inputLength){
			int i,j;

			//StringBuilder sb = new StringBuilder(); //debug
			//for(i=0; i<dtResult.length; i++){ sb.append(dtResult[i]); } //debug
			//System.out.println(sb.toString()); //debug

			int[] dhmmResult = new int[dtResult.length];
			double[] dhmmResultProbability = new double[dtResult.length];
			for(i=0; i<dhmmResultProbability.length; i++){ dhmmResultProbability[i] = Double.NEGATIVE_INFINITY ; }

			int[] dhmmInput = new int[inputLength];
			int[] dhmmOutput = null;
			double[] outputProbability = {0};

			for(i=0; i<dtResult.length-inputLength+1; i++){
				for(j=0; j<inputLength ; j++){
					dhmmInput[j] = dtResult[i+j];
				}
				dhmmOutput = this.classify01(dhmmInput, outputProbability);
				for(j=0; j<inputLength ; j++){
					if(dhmmResultProbability[i+j] < outputProbability[0]){
						dhmmResult[i+j] = dhmmOutput[j];
						dhmmResultProbability[i+j] = outputProbability[0];
					}
				}
			}

			//sb = new StringBuilder(); //debug
			//sb.append("--"); //debug
			//for(i=0; i<dhmmResult.length; i++){ sb.append(dhmmResult[i]); } //debug
			//System.out.println(sb.toString()); //debug

			//sb = new StringBuilder(); //debug
			//sb.append("--"); //debug
			//for(i=0; i<dhmmResult.length; i++){ sb.append(dhmmResultProbability[i] + ","); } //debug
			//System.out.println(sb.toString()); //debug

			return dhmmResult;
		}else{
			return this.classify01(dtResult, null);
		}
	}


	//チェック用
	public void showDHMM(){
		int numOfStates = this.hmm.nbStates();
		NumberFormat nf = NumberFormat.getNumberInstance();
		System.out.println(this.hmm.toString(nf));
		for(int i=0; i<numOfStates; i++){
			System.out.println(this.hmm.getOpdf(i).toString(nf));
			//System.out.println(this.hmm.getOpdf(i).probability(new ObservationInteger(0)));
		}
	}

}