package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dto.LoanCustomerInfo;
import com.nt.service.BankLoanApprover;

public class BeforeAdviceTest {
  public static void main(String[] args) {
	  ApplicationContext ctx=null;
	  LoanCustomerInfo info=null;
	  int loanId=0;
	  BankLoanApprover proxy=null;
	  
	  
	 //create IOC container
	  ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	  //get Proxy object 
	  proxy=ctx.getBean("pfb",BankLoanApprover.class);
	  //prepare DTO object
	  info=new LoanCustomerInfo();
	  info.setClerkName("raja");
	  info.setManagerName("king");
	  info.setCustName("ramesh");
	  info.setLoanAmount(400000);
	  info.setPurpose("agri");
	  //invoke methods
	  try {
		  loanId=proxy.generateLoanId(info);
		  System.out.println("Result:::"+proxy.approveLoan(loanId, info));
	  }
	  catch(Exception e) {
		  System.out.println("Internal Problem");
	  }
	  //close container
	  ((AbstractApplicationContext) ctx).close();
}//method
}//class
