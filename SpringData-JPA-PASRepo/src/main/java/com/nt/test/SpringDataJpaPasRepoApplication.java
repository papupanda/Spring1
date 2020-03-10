package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.config.AppConfig;
import com.nt.service.EmployeeMgmtService;

@SpringBootApplication
@Import(AppConfig.class)
public class SpringDataJpaPasRepoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		//get IOC container
		ctx=SpringApplication.run(SpringDataJpaPasRepoApplication.class, args);
		//get Service class object
		service=ctx.getBean("empService",EmployeeMgmtService.class);
		//invoke method
		try {
		 service.showAllEmployeesPageWise(3);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
