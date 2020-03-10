package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyServletContainer implements ApplicationContextAware {
	private String beanId;
	private ApplicationContext ctx;
	
	public MyServletContainer(String beanId) {
	   System.out.println("MyServletContainer.1-param consturctor");
	   this.beanId=beanId;
	}
	
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("MyServletContainer.setApplicationContext(-)");
		this.ctx=ctx;
	}
	
	public void  handleRequest(String data) {
		RequestHandler handler=null;
		  System.out.println("MyServletContainer.handleRequest() with Data:::"+data);
		  //get Dependent Bean using Dependency lookup 
		  handler=ctx.getBean(beanId,RequestHandler.class);
		  handler.processRequest(data);
	}

	
	

}
