package com.nt.dao;

import java.util.Map;

import com.nt.bo.UserBO;

public interface LoginDAO {
	
	public  Map<String,Object>  authenticate(UserBO bo);

}
