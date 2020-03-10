package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankService;

@SpringBootApplication
@Import(AppConfig.class)
public class DTxManagerTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//get IOC container
		ctx=SpringApplication.run(DTxManagerTest.class, args);
		//get Proxy object
		proxy=ctx.getBean("bankService",BankService.class);
		//invoke method
		try {
			System.out.println(proxy.transferMoney(1001,1008, 2000));
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
		

	}//main
}//class
