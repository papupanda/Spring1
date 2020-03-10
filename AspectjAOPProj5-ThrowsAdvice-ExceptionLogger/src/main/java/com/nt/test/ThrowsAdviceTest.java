package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ArithmeticService;

public class ThrowsAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ArithmeticService proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		proxy=ctx.getBean("arService",ArithmeticService.class);
		//invoke method
		try {
		System.out.println("Result::"+proxy.div(1000,20));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("...............................");
		try {
		System.out.println("Result::"+proxy.div(1000,0));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
