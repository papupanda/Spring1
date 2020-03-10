package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ATMPinGenerator;

public class AfterAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ATMPinGenerator proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy  obj
		proxy=ctx.getBean("pfb",ATMPinGenerator.class);
		//invoke method
			System.out.println("Pin Number::"+proxy.generatePin());
		//close container
			((AbstractApplicationContext) ctx).close();

	}//main
}//class
