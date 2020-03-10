package com.nt.test;

import java.io.Closeable;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@Import(AppConfig.class)
public class RealtimeDILayeredApplicationTest3 {
	public static void main(String[] args) {
		Scanner sc=null;
		EmployeeVO vo=null;
		String eno=null,ename=null,eadd=null,bsal=null;
		MainController controller=null;
		String result=null;
		ApplicationContext ctx=null;
		SpringApplication app=null;
		//read inputs
		sc=new Scanner(System.in);
		System.out.println("Enter employee name::");
		ename=sc.next();
		System.out.println("Enter Employee Address::");
		eadd=sc.next();
		System.out.println("Enter Employee basic Salary::");
		bsal=sc.next();
		//create EmployeeVO class object
		vo=new EmployeeVO();
		vo.setEmpName(ename);
		vo.setEmpAddress(eadd);
		vo.setBasicSalary(bsal);
		//create IOC container 
		 app=new SpringApplication(RealtimeDILayeredApplicationTest3.class);
		 app.setBannerMode(Banner.Mode.OFF);
		 ctx=app.run(args);
		//get Controller class obj  from IOC container
		controller=ctx.getBean("controller",MainController.class);
		//invoke method
		try {
			result=controller.processEmployee(vo);
			System.out.println(result);
		}//try
		catch(Exception e) {
			e.printStackTrace();
			if(((SQLException)e).getErrorCode()==1)
				System.out.println("Emplyee already registered ");
			else if(((SQLException)e).getErrorCode()==12899)
				System.out.println("Emplyee info is larger than given col size ");
			else if(((SQLException)e).getErrorCode()==947)
				System.out.println("Emplyee info insufficient to insert ");
			else
				System.out.println("Unknown Internal Problem ");
		}
		//close container
		 ((AbstractApplicationContext) ctx).close();
	}//main
}//class
