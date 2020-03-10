package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

public class NamedParameterJdbcTemplateTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService  service=null;
		EmployeeDTO dto=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class object
		service=ctx.getBean("empService",EmployeeMgmtService.class);
		//invoke method
		try {
			System.out.println("7499 Emp details:::"+service.fetchEmpById(7499));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("..............................");
		try {
			System.out.println("7499 emp nmae::"+service.fetchEmpNameById(7499));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println(".................................");
		try {
			System.out.println("CLERK,MANAGER,SALESMAN Emp Details"+service.fetchEmpsByDesgs("CLERK","MANAGER","SALESMAN"));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("............................");
		try {
			dto=new EmployeeDTO();
			dto.setEmpNo(1122);
			dto.setEname("rajesh");
			dto.setJob("CLERK");
			dto.setSal(9000);
			System.out.println(service.registerEmployee(dto));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
