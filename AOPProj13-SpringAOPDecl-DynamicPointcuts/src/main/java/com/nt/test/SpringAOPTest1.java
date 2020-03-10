package com.nt.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ArithmeticService;

public class SpringAOPTest1 {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ArithmeticService  proxy=null;
		
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get  Proxy object
		proxy=ctx.getBean("pfb",ArithmeticService.class);
		System.out.println("mehtods of Proxy class"+Arrays.toString(proxy.getClass().getDeclaredMethods()));
		//invoke methods
		System.out.println("Add1 ==="+proxy.add(200,200));
		System.out.println("_________________");
		System.out.println("Add2 ==="+proxy.add(10,20));
		System.out.println("........................");
		System.out.println("Sub1 ==="+proxy.sub(200,200));
		System.out.println("______________________");
		System.out.println("Sub2 ==="+proxy.sub(10,20));
		System.out.println("........................");
		System.out.println("Mul1 ==="+proxy.mul(100,200));
		System.out.println("........................");
		System.out.println("Div1 ==="+proxy.div(100,200));
		System.out.println("........................");
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
