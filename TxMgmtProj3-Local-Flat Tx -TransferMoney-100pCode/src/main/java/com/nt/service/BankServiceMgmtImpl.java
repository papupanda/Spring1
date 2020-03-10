package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.BankDAO;

@Service("bankService")
public class BankServiceMgmtImpl implements BankServiceMgmt {
	@Autowired
	private  BankDAO dao;


	@Override
	public String transferMoney(int srcAcno, int destAcno, float amt)throws IllegalAccessException {
		int count1=0,count2=0;
	   //use DAO
		count1=dao.withdraw(srcAcno, amt);
		count2=dao.deposite(destAcno, amt);
		/*	try {
				Thread.sleep(20000);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		if(count1==0 || count2==0) {
			throw new IllegalArgumentException("Incomplete or invalid details(Tx rollbed back)");
		}
		else {
			return "Money Transffered Successfully (Tx committed)";
		}
		
	}

}
