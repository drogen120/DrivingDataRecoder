package com.example.drivingdatarecoder;

import java.util.List;

public class CommonTool {
	/**List<Float>の平均と分散を計算する関数**/
	public static boolean aveAndVar(List<Float> window, float[] result){
		if(result==null || result.length<2){ return false;}

		float ex = 0f;
		float ex2 = 0f;
		for(float s: window){
			ex += s;
			ex2 += s*s;
		}
		ex = ex/window.size();
		ex2 = ex2/window.size();

		result[0] = ex; //平均
		result[1] =  ex2 - ex*ex; //分散
		return true;
	}
	/**List<Double>の平均と分散を計算する関数**/
	public static boolean aveAndVar(List<Double> window, double[] result){
		if(result==null || result.length<2){ return false;}

		double ex = 0.0;
		double ex2 = 0.0;
		for(double s: window){
			ex += s;
			ex2 += s*s;
		}
		ex = ex/window.size();
		ex2 = ex2/window.size();

		result[0] = ex; //平均
		result[1] =  ex2 - ex*ex; //分散
		return true;
	}
	/**2つのList<Double>の平均・分散・共分散を計算する関数**/
	public static boolean calcAveVarAveVarCov(List<Double> list1, List<Double> list2, double[] result){
		if(list1 == null || list2 == null || list1.size() != list2.size()
		   || result==null || result.length<5 ){ return false ;}

		/* Cov[X,Y] = E[XY} - E[X]E[Y] */
		int listSize = list1.size();

		double ex1 = 0.0, exsq1 = 0.0, ex2 = 0.0, exsq2 = 0.0, ex12 = 0.0;
		double[] array12 = new double[listSize];
		int i=0;
		for(double s1: list1){
			ex1 += s1;
			exsq1 += s1*s1;
			array12[i] = s1;
			i++;
		}
		ex1 = ex1/listSize;
		exsq1 = exsq1/listSize;
		double var1 = exsq1 - ex1*ex1;	//この時点で ex1 = E[X], var1 = V[X]

		i=0;
		for(double s2: list2){
			ex2 += s2;
			exsq2 += s2*s2;
			array12[i] *= s2;
			i++;
		}
		ex2 = ex2/listSize;
		exsq2 = exsq2/listSize;
		double var2 = exsq2 - ex2*ex2;	//この時点で ex2 = E[Y], var2 = V[Y]

		for(double s12: array12){
			ex12 += s12;
		}
		ex12 = ex12/listSize;
		double cov12 = ex12 - ex1*ex2; //この時点で ex12 = E[XY], cov12 = Cov[X,Y]

		result[0] = ex1;
		result[1] = var1;
		result[2] = ex2;
		result[3] = var2;
		result[4] = cov12;
		return true;
	}
}