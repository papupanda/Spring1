package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.OnlineStore;

public class AfterAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		OnlineStore proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		proxy=ctx.getBean("os",OnlineStore.class);
		//invoke methods
		System.out.println("bill Amount::"+proxy.calculateBillAmt(new String[] {"trouser","shirt"},new float[] {9000,8000} ));
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
	}//main
}//class
