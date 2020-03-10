package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.DepositeDAO;
import com.nt.dao.WithdrawDAO;

@Service("bankService")
public class BankServiceImpl implements BankService {
	@Autowired
	private WithdrawDAO wdao;
	@Autowired
	private DepositeDAO ddao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public String transferMoney(int srcAcno, int destAcno, float amt) {
		int count1=0,count2=0;
		count1=wdao.withdraw(srcAcno, amt);
		count2=ddao.deposite(destAcno, amt);
		System.out.println(count1+"  "+count2);
		
		if(count1==0 || count2==0) {
			throw new RuntimeException("Tx Failed -Money not transffered");
		}
		else {
	       return "money transfered--Tx commmited";		
		}
			
	}//method
}//class
