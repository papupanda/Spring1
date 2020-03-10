package com.nt.service;

import java.sql.SQLException;

public class OnlineStore {
	
	public  float  shopping(String items[],float prices[])throws IllegalAccessException{
		float bamt=0.0f;
		if(items==null || prices==null)
			  throw  new IllegalArgumentException("Invalid inputs");
			//throw new SQLException("invalid inputs");
			//throw new IllegalAccessException("invalid inputs11");
		for(float p:prices) {
			bamt=bamt+p;
		}
		return bamt;
		
	}

}
