package com.nt.test;

import org.springframework.aop.framework.ProxyFactory;

import com.nt.advice.PerformenceMonitoringAdvice;
import com.nt.service.ArithmeticService;

public class SpringAOPTest {
	public static void main(String[] args) {
		ArithmeticService target=null,proxy=null;
		PerformenceMonitoringAdvice advice=null;
		ProxyFactory factory=null;
		//create Target class object
		target=new ArithmeticService();
		//create Advice class object
		advice=new PerformenceMonitoringAdvice();
		//create ProxyFactory object
		factory=new ProxyFactory();
		factory.setTarget(target);
		//factory.addAdvice(advice);
		//get Proxy obj
		proxy=(ArithmeticService) factory.getProxy();
		//invoke target method
		System.out.println("add=="+proxy.add(100,200));
		System.out.println("...........................");
		System.out.println("sub=="+proxy.sub(100,200));
		System.out.println("...........................");
		System.out.println("mul=="+proxy.mul(100,200));
		System.out.println("...........................");
		System.out.println("div=="+proxy.div(100,200));
		
		
		

	}

}
