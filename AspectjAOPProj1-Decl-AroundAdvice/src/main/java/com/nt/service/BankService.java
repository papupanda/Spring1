package com.nt.service;

public class BankService {
	
	public  float calcSimpleIntrestAmount(float pAmt,float rate,float time) {
		System.out.println("BankService.calcSimpleIntrestAmount()");
		return  (pAmt*rate*time)/100.0f;
	}
	
	public float calcCompoundIntrestAmount(float pAmt,float rate,float time) {
		System.out.println("BankService.calcCompoundIntrestAmount()");
		return  (float) ((pAmt*Math.pow((1+rate/100),time))-pAmt);
	}

}
