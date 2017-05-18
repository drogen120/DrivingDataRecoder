package com.example.drivingdatarecoder;

import java.util.LinkedList;

public class AverageFilter{
    	private LinkedList<Float> average_filter_list;
    	private int average_num;
    	
    	public AverageFilter(int num){
    		average_filter_list = new LinkedList<Float>();
    		average_num = num;
    	}
    	public void pushData(Float data){
    		if(average_filter_list.size() > average_num){
    			average_filter_list.poll();
    		}
    		average_filter_list.offer(data);
    	}
    	public Float getAverageData(){
    		Float sum = 0f;
    		LinkedList<Float> templist = (LinkedList<Float>)average_filter_list.clone();
    		for (int i=0;i < average_filter_list.size(); i++){
    			sum = sum + templist.poll();
    		}
    		return sum/average_filter_list.size();
    	}
    }