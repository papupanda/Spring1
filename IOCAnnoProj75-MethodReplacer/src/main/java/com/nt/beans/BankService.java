package com.nt.beans;

public  class BankService {
	
	public  float calcIntrAmount(float pAmt,float rate,float time) {
		System.out.println("BankService.calcIntrAmount(-,-,-) (Simple IntrAmt)");
		if(pAmt<=0.0f || rate<=0.0f || time<=0.0f)
			throw new IllegalArgumentException("Invalid Inputs");
		return pAmt*rate*time/100.0f;
	}

}
