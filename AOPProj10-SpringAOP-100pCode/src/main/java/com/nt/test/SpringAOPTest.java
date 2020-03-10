package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.ArithmeticService;

public class SpringAOPTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ArithmeticService  proxy=null;
		//create IOC container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get  Proxy object
		proxy=ctx.getBean("pfb",ArithmeticService.class);
		//invoke method
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

	}

}
