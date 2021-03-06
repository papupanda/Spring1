package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("dDAO")
public class DepositeDAOImpl implements DepositeDAO {
	private static final  String  DEPOSITE_QUERY="UPDATE DTX_ACCOUNT SET BALANCE=BALANCE+? WHERE ACNO=?";
	@Autowired
	@Qualifier(value="pgTemplate")
	private JdbcTemplate pgJt;

	@Override
	public int deposite(int acno, float amount) {
		int count=0;
		count=pgJt.update(DEPOSITE_QUERY,amount,acno);
		return count;
	}

}
