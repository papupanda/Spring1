package com.nt.service;

import com.nt.dao.BankDAO;

public class BankServiceImpl implements BankService {
	private BankDAO dao;
	
	public BankServiceImpl(BankDAO dao) {
		this.dao = dao;
	}

	public String withdraw(int acno, float amt) {
		int  count=0;
		//use DAO
		count=dao.withdraw(acno, amt);
		if(count==0)
			return "Money not withdrawn (Invalid Account number)";
		else
			return "Money  withdrawn from  account   "+acno;
	}

	public String deposite(int acno, float amt) {
		int  count=0;
		//use DAO
		count=dao.deposite(acno, amt);
		if(count==0)
			return "Money not deposited (Invalid Account number)";
		else
			return "Money  deposited into account   "+acno;
	}

}
