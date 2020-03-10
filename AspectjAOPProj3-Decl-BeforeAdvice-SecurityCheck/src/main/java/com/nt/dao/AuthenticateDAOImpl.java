package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.model.UserDetails;

public class AuthenticateDAOImpl implements AuthenticateDAO {
	private  static final String  AUTH_QUERY="SELECT COUNT(*) FROM USERLIST WHERE UNAME=? AND PWD=?";
	private  JdbcTemplate jt;
	

	public AuthenticateDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}


	public int authenticate(UserDetails details) {
		int count=0;
		count=jt.queryForObject(AUTH_QUERY, Integer.class,details.getUsername(),details.getPassword());
		return count;
	}

}
