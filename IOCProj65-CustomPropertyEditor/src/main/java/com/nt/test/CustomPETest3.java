package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.BankLoanMgmt;

public class CustomPETest3 {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx=null;
		BankLoanMgmt mgmt=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		//get Bean
		mgmt=ctx.getBean("blm",BankLoanMgmt.class);
		//invoke method
		System.out.println("Result :::"+mgmt.calcSimpleIntrestAmount());

	}
	
	

}
