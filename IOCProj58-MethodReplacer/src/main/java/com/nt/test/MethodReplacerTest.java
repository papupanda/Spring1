package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.BankService;

public class MethodReplacerTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService service=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		service=ctx.getBean("bankService",BankService.class);
		System.out.println("Main obj class name::"+service.getClass()+" super class name::"+service.getClass().getSuperclass());
		//invoke method
		System.out.println("Intr Amount::"+service.calcIntrAmount(100000,2, 12));
		
		//close container
		((AbstractApplicationContext) ctx).close();
		

	}

}
