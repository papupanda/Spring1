package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class AspectjAOPTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService  proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get Proxy object
		proxy=ctx.getBean("bankService",BankService.class);
		//invoke target methods
		System.out.println("simple intrest amount1::"+proxy.calcSimpleIntrestAmount(50000, 2, 12));
		System.out.println("simple intrest amount2::"+proxy.calcSimpleIntrestAmount(50000, 2, 12));
		System.out.println(".....................................");
		System.out.println("compound intrest amount::"+proxy.calcCompoundIntrestAmount(100000, 2, 12));
		//close container
		((AbstractApplicationContext) ctx).close();
		

	}//main
}//class
