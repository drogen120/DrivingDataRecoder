package com.example.drivingdatarecoder;

public class Modeobject {
	private String mTime;
	private int mMode;
	public Modeobject(String timestr, int mode){
		mTime = timestr;
		mMode = mode;
	}
	public void setMode(int mode){
		mMode = mode;
	}
	
	public int getMode(){
		return mMode;
	}
	
	@Override
	public String toString(){
		return mTime+","+mMode;
	}
	

}
