package com.nt.test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.CustomerMgmtService;

public class MappingSQLOperationTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerMgmtService service=null;
		//create  IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class object
		service=ctx.getBean("custService",CustomerMgmtService.class);
		//invoke methods
		try {
			System.out.println(" customer Details :::"+service.fetchCustomerById(1));
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
	  System.out.println("..................................");	
		try {
			System.out.println("List of customer Details :::"+service.fetchCustomersByLoanAmtRange(10000, 200000));
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
	
	
		
		//close container
		((AbstractApplicationContext) ctx).close();
		

	}//main
}//class
