package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nt.bo.UserBO;

@Repository("userDAO")
public class LoginDAOImpl implements LoginDAO {
	@Autowired
	private SimpleJdbcCall sjc;

	/*public Map<String, Object> authenticate(UserBO bo) {
		Map<String,Object> inParams=null,outParams=null;
		
		//set Procedure name
		sjc.setProcedureName("P_AUTH");
		//create InParams Map
		inParams=new HashMap();
		inParams.put("USER",bo.getUname());
		inParams.put("PASS",bo.getPwd());
		//generate  Query to call PL/SQL procedure
		outParams=sjc.execute(inParams);
		return outParams;
	}*/
	
	/*public Map<String, Object> authenticate(UserBO bo) {
		Map<String,Object> outParams=null;
		//set Procedure name
		sjc.setProcedureName("P_AUTH");
		//generate  Query to call PL/SQL procedure
		outParams=sjc.execute(bo.getUname(),bo.getPwd());
		return outParams;
	}*/
	
	public Map<String, Object> authenticate(UserBO bo) {
		MapSqlParameterSource msps=null;
		Map<String,Object> outParams=null;
		//set Procedure name
		sjc.setProcedureName("P_AUTH");
		// prepare Inparams names and values
		msps=new MapSqlParameterSource();
		msps.addValue("USER",bo.getUname());
		msps.addValue("PASS",bo.getPwd());
		//generate  Query to call PL/SQL procedure
		outParams=sjc.execute(msps);
		return outParams;
	}

}
