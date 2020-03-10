package com.nt.test;

import java.util.ArrayList;
import java.util.List;

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
public class SpringDataJpaPasRepoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		List<EmployeeDTO> listDTO=null;
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
		
		System.out.println("...............");
		try {
			listDTO=new ArrayList();
			EmployeeDTO dto1=new EmployeeDTO();
			dto1.setEid(56);
			EmployeeDTO dto2=new EmployeeDTO();
			dto2.setEid(678);
			listDTO.add(dto1); listDTO.add(dto2);
			System.out.println(service.removeEmployeeInBatch(listDTO));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
