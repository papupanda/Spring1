package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class MyServletContainer {
	
	public MyServletContainer() {
		System.out.println("MyServletContainer:0-param constructor");
	}
	
	//special method to be implemented by Container generated sub class 
	public abstract  RequestHandler createRequestHandler();
	
	public void  handleRequest(String data) {
		RequestHandler handler=null;
		  System.out.println("MyServletContainer.handleRequest() with Data:::"+data);
		  //get Dependent Bean using Dependency lookup 
		  handler=createRequestHandler();
		  //invoke method
		  handler.processRequest(data);
	}

	
	

}
