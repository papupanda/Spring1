package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.BankDAO;

@Service("bankService")
public class BankServiceMgmtImpl implements BankServiceMgmt {
	@Autowired
	private  BankDAO dao;



	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public String transferMoney(int srcAcno, int destAcno, float amt)throws IllegalArgumentException {
		int count1=0,count2=0;
		/*try {
			Thread.sleep(30000);
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}*/
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
