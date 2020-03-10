package com.nt.service;

public class OnlineStore {
	
	public float   shopping(String items[],float prices[]) {
		float billAmt=0.0f;
		for(float price:prices) {
			billAmt=billAmt+price;
		}
		return   billAmt;
	}

}
