package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.UserBO;
import com.nt.dao.LoginDAO;
import com.nt.dto.UserDTO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private  LoginDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String validate(UserDTO dto) {
		UserBO bo=null;
		int count=0;
		//convert dto to bo
		bo=new UserBO();
		BeanUtils.copyProperties(dto, bo);
         //use DAO
		count=dao.authenticate(bo);
		return (count==0)?"InValid Credentials" : "ValidCRedentials";
	}

}
