package com.nt.service;

import com.nt.dao.BankDAO;

public class BankServiceMgmtImpl implements BankServiceMgmt {
	private  BankDAO dao;

	public BankServiceMgmtImpl(BankDAO dao) {
		this.dao = dao;
	}

	@Override
	public String transferMoney(int srcAcno, int destAcno, float amt)throws IllegalAccessException {
		int count1=0,count2=0;
	   //use DAO
		count1=dao.withdraw(srcAcno, amt);
		count2=dao.deposite(destAcno, amt);
		try {
			Thread.sleep(20000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(count1==0 || count2==0) {
			throw new IllegalArgumentException("Incomplete or invalid details(Tx rollbed back)");
		}
		else {
			return "Money Transffered Successfully (Tx committed)";
		}
		
	}

}
