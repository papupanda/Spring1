package com.nt.service;

import org.springframework.stereotype.Service;

@Service("arService")
public class ArithmeticService {
	
	public  float add(float x,float y) {
		return x+y;
	}
	
	public  float sub(float x,float y) {
		return x-y;
	}
	
	public  float mul(float x,float y) {
		return x*y;
	}
	
	public  float div(float x,float y) {
		 if(y==0)
			 throw new ArithmeticException("Invalid operand");
		return x/y;
	}


}
