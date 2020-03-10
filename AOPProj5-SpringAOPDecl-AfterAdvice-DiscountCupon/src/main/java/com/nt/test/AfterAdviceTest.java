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
		//get Bean
		proxy=ctx.getBean("pfb",OnlineStore.class);
		//invoke methods
		System.out.println("bill Amount:::"+proxy.shopping(new String[] {"Christmas Tree","Star Light","Cake","Santa Cap","white dress"},
				                                                                                     new float[] {50000,500,1000,100,20000}));
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
	}//main
}//class
