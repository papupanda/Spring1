package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.service.BankService;

public class AnnoAroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService  proxy=null;
		//create IOC container
		ctx=new FileSystemXmlApplicationContext("src/main/java/com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		proxy=ctx.getBean("bankService",BankService.class);
		System.out.println("Simple IntrAmount::"+proxy.calcSimpleIntrestAmount(100000,2, 12));
		System.out.println("............................");
		System.out.println("Compound IntrAmount::"+proxy.calcCompoundIntrestAmount(100000,2, 12));
		System.out.println("_____________________");
		System.out.println("Compound IntrAmount::"+proxy.calcCompoundIntrestAmount(100000,2, 12));
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
		

	}

}
