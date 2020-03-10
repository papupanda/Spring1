package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.PersonAadharDetails;

public class PropertyEditorsTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		PersonAadharDetails details=null;
		 //create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get AadharDetails object
		details=ctx.getBean("pad",PersonAadharDetails.class);
		System.out.println(details);
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
