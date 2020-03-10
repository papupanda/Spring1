package com.nt.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyServletContainer {
	private String beanId;
	public MyServletContainer(String beanId) {
	   System.out.println("MyServletContainer.1-param consturctor");
	   this.beanId=beanId;
	}
	
	public void  handleRequest(String data) {
		ApplicationContext ctx=null;
		RequestHandler handler=null;
		  System.out.println("MyServletContainer.handleRequest() with Data:::"+data);
		  //create additional IOC container
		  ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		  //get Dependent Bean 
		  handler=ctx.getBean(beanId,RequestHandler.class);
		  handler.processRequest(data);
	}
	

}
