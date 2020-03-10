package com.nt.service;

public class OnlineStore {
	
	public   float  calculateBillAmt(String[] items,float prices[]) {
		float billAmt=0.0f;
		for(float p:prices) {
			billAmt=billAmt+p;
		}
		return billAmt;
	}

}
