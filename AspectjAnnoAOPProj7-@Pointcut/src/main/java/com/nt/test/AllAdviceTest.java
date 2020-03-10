package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.service.ArithmeticService;

public class AllAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ArithmeticService proxy=null;
		//create IOC container
		ctx=new FileSystemXmlApplicationContext("src/main/java/com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		proxy=ctx.getBean("arService",ArithmeticService.class);
		//invoke methods
		System.out.println("add===>"+proxy.add(100,200));
		System.out.println("..................");
		System.out.println("sub==>"+proxy.sub(10,20));
		System.out.println("..................");
		System.out.println("mul==>"+proxy.mul(100,200));
		System.out.println("......................");
		System.out.println("div==>"+proxy.div(10,20));
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
	}

}
