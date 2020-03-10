package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

public class CallbackInterfacesTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService  service=null;
		EmployeeDTO dto=null;
		List<EmployeeDTO> listDTO=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		service=ctx.getBean("empService",EmployeeMgmtService.class);
		try {
		//invoke method
		dto=service.fetchEmployeeByNo(7499);
		System.out.println("7499 emp details are :::"+dto);
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("..........................");
		
		try {
			listDTO=service.fetchEmployeesByDesgs("CLERK","MANAGER","SALESMAN");
			System.out.println(listDTO);
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println(".....................................");
		
		try {
			listDTO=service.fetchEmpsByJobs("CLERK", "MANAGER","SALESMAN");
			System.out.println(listDTO);
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}
}
