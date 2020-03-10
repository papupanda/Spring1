package com.nt.beans;

public class BankLoanMgmt {
	private  IntrestAmountDetails  details;

	public void setDetails(IntrestAmountDetails details) {
		this.details = details;
	}
	
    public  float calcSimpleIntrestAmount() {
    	return  (details.getpAmt()*details.getRate()*details.getTime())/100.0f;
    	
    }
	

}
