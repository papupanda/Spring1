package com.nt.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ArithmeticService;

public class SpringAOPTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ArithmeticService  proxy=null;
		
		//create IOC container
		//ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext1.xml");
		//ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext2.xml");
		//ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext3.xml");
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext4.xml");
		//get  Proxy object
		proxy=ctx.getBean("pfb",ArithmeticService.class);
		System.out.println("mehtods of Proxy class"+Arrays.toString(proxy.getClass().getDeclaredMethods()));
		//invoke methods
		System.out.println("Add ==="+proxy.add(100,200));
		System.out.println("........................");
		System.out.println("Sub ==="+proxy.sub(100,200));
		System.out.println("........................");
		System.out.println("Mul ==="+proxy.mul(100,200));
		System.out.println("........................");
		System.out.println("Div ==="+proxy.div(100,200));
		System.out.println("........................");
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
