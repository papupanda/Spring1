package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.India;

public class DependencyCheckTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		India india=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Target Bean
	/*	india=ctx.getBean("india",India.class);
		System.out.println(india); */ 
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
		

	}

}
