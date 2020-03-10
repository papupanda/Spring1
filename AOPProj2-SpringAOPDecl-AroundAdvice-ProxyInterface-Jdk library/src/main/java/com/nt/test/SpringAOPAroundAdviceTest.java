package com.nt.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class SpringAOPAroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		proxy=ctx.getBean("pfb",BankService.class);
		System.out.println("proxy obj class ::"+proxy.getClass()+"  "+proxy.getClass().getSuperclass()+"  "+Arrays.toString(proxy.getClass().getInterfaces())+"   "+Arrays.toString(proxy.getClass().getDeclaredMethods()));
		//invoke the methods
		System.out.println("Simple Intr Amount::"+proxy.calcSimpleIntrestAmount(50000, 2, 12));
		System.out.println(".....................");
		System.out.println("Compound Intr Amount::"+proxy.calcCompoundIntrestAmount(50000, 2, 12));
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
