package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataAccessException;

import com.nt.config.AppConfig;
import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

@SpringBootApplication
@Import(AppConfig.class)
public class SpringDataJpaCurdRepoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		EmployeeDTO dto=null;
		//get IOC container
		ctx=SpringApplication.run(SpringDataJpaCurdRepoApplication.class, args);
		//get Service class object
		service=ctx.getBean("empService",EmployeeMgmtService.class);
		//invoke method
			try {
			//create DTO 
				dto=new EmployeeDTO();
				//dto.setEid(1001);
				dto.setEname("raja");
				dto.setEadd("hyd");
				dto.setSalary(90000);
				
			 System.out.println(service.registerEmployee(dto));
			}
			catch(DataAccessException dae) {
				dae.printStackTrace();
			}
		System.out.println("...............");
		try {
			System.out.println("1 emp detals"+service.fetchEmployeeById(1));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(".........");
		
		try {
			System.out.println("all emp details::"+service.fetchAllEmployees());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
System.out.println(".........");
		
		try {
			System.out.println("all emp details whose ids are 1,21::"+service.fetchEmpsByIds(1, 21));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
     System.out.println(".........");
		
		try {
			System.out.println(" emp details whose salary range is 3000 to 10000::"+service.fetchEmpsBySalaryRange(2000, 10000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
System.out.println(".........");
		
		try {
			System.out.println(" avg emp salary::"+service.getEmpAvgSalary());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
System.out.println(".........");
		
		try {
			System.out.println(" Emps By Addrs::"+service.fetchEmpsByAddrs("hyd"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
System.out.println(".........");
		
		try {
			System.out.println(" Emps count who bonus of 10000::"+service.addBonusToEmployeesByAddresses("hyd","delhi",10000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	
		
		
		
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
