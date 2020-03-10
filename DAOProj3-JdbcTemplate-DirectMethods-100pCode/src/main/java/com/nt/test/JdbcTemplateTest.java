package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.config.AppConfig;
import com.nt.service.EmployeeMgmtService;

public class JdbcTemplateTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		//create  IOC container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get Bean
		service=ctx.getBean("empService",EmployeeMgmtService.class);
		//invoke b.method
		try {
		System.out.println("Result :::"+service.fetchEmpsCount());
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("internal Problem ");
		}
		try {
		System.out.println("7499 Emp Details ::"+service.fetchEmpByNo(7499));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("internal Problem ");
		}
		try {
		System.out.println("CLERK desg Emp Details ::"+service.fetchEmpsByDesg("CLERK"));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("internal Problem ");
		}
		
		try {
		System.out.println("Emp name ::"+service.fetchEmpNameByNo(7499));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("internal Problem ");
		}
		
		/*//insert record
		try {
			System.out.println(service.register("amitab","Actor",99999));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("internal Problem ");
		}
		*/
		
		try {
			System.out.println("7499 emp salary::"+service.fetchSalaryByEmpNo(7499));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("internal Problem ");
		}
		
		
		try{
			System.out.println("salary hiked?"+service.hikeEmpSalary(7499,5));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
			System.out.println("internal Problem ");
		}
		
		
		
		
		
		
		
		//close container
		((AbstractApplicationContext) ctx).close();
		

	}

}
