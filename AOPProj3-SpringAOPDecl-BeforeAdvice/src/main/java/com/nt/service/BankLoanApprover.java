package com.nt.service;

import java.util.Calendar;
import java.util.Random;

import com.nt.dto.LoanCustomerInfo;

public class BankLoanApprover {
	
	public  int   generateLoanId(LoanCustomerInfo info) {
		int loanId=0;
		if(info.getLoanAmount()<200000 && (info.getPurpose().equalsIgnoreCase("agri") || info.getPurpose().equalsIgnoreCase("vehicle")))
				loanId=new Random().nextInt(10000);
		else
			throw new IllegalArgumentException("invalid info");
		return loanId;
	}
	
	public   String  approveLoan(int loanId,LoanCustomerInfo info) {
		Calendar cal=null;
		int month=0;
		//get System date and current month
		cal=Calendar.getInstance();
		month=cal.get(Calendar.MONTH);
		if(info.getPurpose().equalsIgnoreCase("agri") && (month>=5  && month<=11))
			return  loanId +" loan is approved for the amount ::"+info.getLoanAmount() +"as agriculture loan";
		else if(info.getPurpose().equalsIgnoreCase("vehicle") && (month>=2 && month<=5))
			return  loanId +" loan is approved for the amount ::"+info.getLoanAmount() +" as  vehicle loan";
		else
			return  loanId +" loan is not approved for the amount ::"+info.getLoanAmount();
		
	}

}
