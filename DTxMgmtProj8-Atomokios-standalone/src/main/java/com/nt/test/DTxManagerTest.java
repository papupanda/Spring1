package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.service.BankService;

public class DTxManagerTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//create IOC container
		ctx=new FileSystemXmlApplicationContext("src/main/java/com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		proxy=ctx.getBean("bankService",BankService.class);
		//invoke method
		try {
			System.out.println(proxy.transferMoney(1004,1007, 20000));
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
		

	}

}
