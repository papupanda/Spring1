package com.nt.beans;

public class MyServletContainer {
	private RequestHandler handler;

	public MyServletContainer(RequestHandler handler) {
	   System.out.println("MyServletContainer.MyServletContainer()");
		this.handler = handler;
	}
	
	public void  handleRequest(String data) {
		  System.out.println("MyServletContainer.handleRequest() with Data:::"+data);
		  handler.processRequest(data);
	}
	

}
