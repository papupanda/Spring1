package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

public class ORMTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService  service=null;
		EmployeeDTO dto=null;
		int idVal=0;
		List<EmployeeDTO> listDTO=null;
		int count=0;
		//create IOC container
		ctx=new FileSystemXmlApplicationContext("src/main/java/com/nt/cfgs/applicationContext.xml");
		//get Bean class object
		service=ctx.getBean("empService",EmployeeMgmtService.class);
		//prepare DTO
		dto=new EmployeeDTO();
		dto.setEid(1001); dto.setEname("raja");
		dto.setSalary(9000); dto.setEadd("hyd");
		//invoke method
		/*try {
		  idVal=service.registerEmployee(dto);
		  System.out.println("Employee registerd::Generated idVal::"+idVal);
		}
		catch(Exception e) {
			System.out.println("Employee registation failed");
			e.printStackTrace();
		}*/
		System.out.println("................");
		try {
			System.out.println("1001 emp details::"+service.fetchEmpById(1001));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("................");
		try {
			listDTO=service.fetchEmpsByAddresses("hyd", "delhi");
			System.out.println("Emps belogning hyd,delhi"+listDTO);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("................");
		
		try {
			listDTO=service.fetchEmpsByAddresses1("hyd", "delhi");
			System.out.println("Emps belogning hyd,delhi"+listDTO);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("...................");
		try {
			listDTO=service.fetchEmpsBySalaryRange(2000,10000);
			System.out.println("Emps having salary range::"+listDTO);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(".....................");
		try {
			System.out.println("no.of emps fired::"+service.removeEmpsBySalaryMark(10000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(".................");
		try {
			count=service.hikeEmpsSalaryByAddrs("delhi",5);
			System.out.println("Emps count who got 5% salary hike::"+count);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
