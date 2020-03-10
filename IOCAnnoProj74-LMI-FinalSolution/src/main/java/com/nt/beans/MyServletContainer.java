package com.nt.beans;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("container")

public abstract class MyServletContainer {
	
	public MyServletContainer() {
		System.out.println("MyServletContainer:0-param constructor");
	}
	
	//special method to be implemented by Container generated sub class 
	@Lookup
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
