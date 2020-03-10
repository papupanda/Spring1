package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.SeniorPatient;

public class SPELTestApp {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		SeniorPatient patient=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get Bean
		patient=ctx.getBean("patient",SeniorPatient.class);
		System.out.println(patient);
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
