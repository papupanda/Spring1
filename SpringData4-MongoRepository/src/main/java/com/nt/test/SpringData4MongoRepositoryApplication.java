package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.config.AppConfig;
import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

@SpringBootApplication
@Import(AppConfig.class)
public class SpringData4MongoRepositoryApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		EmployeeDTO dto=null;
		//get IOC container
		ctx=SpringApplication.run(SpringData4MongoRepositoryApplication.class, args);
		//get Service class object
		service=ctx.getBean("empService",EmployeeMgmtService.class);
		/*try {
			dto=new EmployeeDTO();
			dto.setEid(1002); dto.setEname("rajesh");
			dto.setSalary(9000); dto.setAddrs(new String[] {"hyd","secbad"});
			
			//invoke method
			System.out.println(service.registerEmployee(dto));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		System.out.println("....................");
		try {
			System.out.println("All Emp Details ::"+service.getAllEmployees());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("....................");
		try {
			System.out.println(service.updateEmployeeById(1001, new String[] {"vizag","delhi"}));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
