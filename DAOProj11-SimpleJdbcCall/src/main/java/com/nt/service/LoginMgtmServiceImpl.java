package com.nt.service;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.UserBO;
import com.nt.dao.LoginDAO;
import com.nt.dto.UserDTO;

@Service("loginService")
public class LoginMgtmServiceImpl implements LoginMgmtService {
	@Autowired
	private LoginDAO dao;

	public String login(UserDTO dto) {
		UserBO bo=null;
		Map<String,Object> outParams=null;
		String result=null;
		//convert dto to bo
		bo=new UserBO();
		BeanUtils.copyProperties(dto, bo);
		//use  dAO
		outParams=dao.authenticate(bo);
		//gather result
		result=(String) outParams.get("RESULT");
		return result;
	}

}
