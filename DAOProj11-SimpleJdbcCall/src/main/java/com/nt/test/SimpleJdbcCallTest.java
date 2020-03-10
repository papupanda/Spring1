package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.UserDTO;
import com.nt.service.LoginMgmtService;

public class SimpleJdbcCallTest {
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		LoginMgmtService service=null;
		String result=null;
		UserDTO dto=null;
		//create  IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class object
		service=ctx.getBean("loginService",LoginMgmtService.class);
		//prepare DTO
		dto=new UserDTO();
		dto.setUname("raja"); dto.setPwd("rani1");
		//invoke method
		try {
			result=service.login(dto);
			System.out.println("Result is:::"+result);
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
	}//main
}//class
