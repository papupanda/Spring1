package com.nt.service;

import com.nt.dao.BankDAO;

public class BankServiceMgmtImpl implements BankServiceMgmt {
	private  BankDAO dao;

	public BankServiceMgmtImpl(BankDAO dao) {
		this.dao = dao;
	}

	@Override
	public String transferMoney(int srcAcno, int destAcno, float amt)throws IllegalArgumentException {
		int count1=0,count2=0;
		try {
			Thread.sleep(30000);
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	   //use DAO
		count1=dao.withdraw(srcAcno, amt);
		count2=dao.deposite(destAcno, amt);
	
		
		if(count1==0 || count2==0) {
			throw new IllegalArgumentException("Incomplete or invalid details(Tx rollbed back)");
		}
		else {
			return "Money Transffered Successfully (Tx committed)";
		}
		
	}

}
