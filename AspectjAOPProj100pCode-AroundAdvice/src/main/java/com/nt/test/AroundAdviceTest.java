package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankService;

public class AroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//create IOC container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get Proxy object
		proxy=ctx.getBean("bankService",BankService.class);
		//invoke methods
		System.out.println("simple Intr Amount ::"+proxy.calcSimpleIntrestAmount(100000, 2, 12));
		System.out.println(".......................");
		System.out.println("compound Intr Amount ::"+proxy.calcCompoundIntrestAmount(100000, 2, 12));
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
