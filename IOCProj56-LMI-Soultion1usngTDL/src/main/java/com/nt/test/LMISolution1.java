package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.MyServletContainer;

public class LMISolution1 {
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		MyServletContainer container=null;
		//create  IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		container=ctx.getBean("container",MyServletContainer.class);
		//invoke methods
		container.handleRequest("hello");
		System.out.println("-------------------------------");
		container.handleRequest("hai");
		System.out.println("========================");
		container=ctx.getBean("container",MyServletContainer.class);
		//invoke methods
		container.handleRequest("hello1");
		System.out.println("-------------------------------");
		container.handleRequest("hai1");
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
		
	}

}
