package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;
import com.nt.service.IBankService;

public class AspectjAOPTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IBankService  proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get Proxy object
		proxy=ctx.getBean("bankService",IBankService.class);
		System.out.println("proxy obj class name::"+proxy.getClass());
		//invoke target methods
		System.out.println("simple intrest amount::"+proxy.calcSimpleIntrestAmount(100000, 2, 12));
		System.out.println(".....................................");
		System.out.println("compound intrest amount::"+proxy.calcCompoundIntrestAmount(100000, 2, 12));
		//close container
		((AbstractApplicationContext) ctx).close();
		

	}//main
}//class
