package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class BankDAOImpl implements BankDAO {
 private static final String  WITHDRAW_QUERY="UPDATE TX_ACCOUNT SET BALANCE=BALANCE-? WHERE ACNO=?";
 private static final String  DEPOSITE_QUERY="UPDATE TX_ACCOUNT SET BALANCE=BALANCE+? WHERE ACNO=?";
  private JdbcTemplate jt;

public BankDAOImpl(JdbcTemplate jt) {
	System.out.println("BankDAOImpl:: 1-param constructor");
		this.jt = jt;
	}
   
	@Override
	public int deposite(int acno, float amount) {
		int count=0;
		count=jt.update(DEPOSITE_QUERY, amount,acno);
		return count;
	}

	@Override
	public int withdraw(int acno, float amount) {
		int count=0;
		count=jt.update(WITHDRAW_QUERY, amount,acno);
		return count;
	}

}
