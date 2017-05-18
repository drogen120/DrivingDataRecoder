package com.example.drivingdatarecoder;

import java.lang.Math;
import java.util.LinkedList;

public class KalmanFilter {
	private float Q;
	private float R;
	
	private LinkedList<Float> xhat;
	private LinkedList<Float> P;
	private LinkedList<Float> xhatminus;
	private LinkedList<Float> Pminus;
	private LinkedList<Float> K;
	
	public KalmanFilter(){
		//Q = (float) Math.pow(Math.E, -5);
		Q = 0.001f;
		R = 0.1f;
		//R = 0.5f;
		
		xhat = new LinkedList<Float>();
		P = new LinkedList<Float>();
		xhatminus = new LinkedList<Float>();
		Pminus = new LinkedList<Float>();
		K = new LinkedList<Float>();
		
		xhat.offer(0.0f);
		P.offer(1.0f);
	}
	
	public void pushValue(float value){
		// time update
		xhatminus.offer(xhat.poll());
		Pminus.offer(P.poll()+Q);
		
		// measurement update
		K.offer(Pminus.peek()/(Pminus.peek()+R));
		xhat.offer(xhatminus.peek()+K.peek()*(value - xhatminus.peek()));
		P.offer((1-K.poll())*Pminus.poll());
		xhatminus.poll();
	}
	
	public float getValue(){
		return xhat.peek();
	}

}
