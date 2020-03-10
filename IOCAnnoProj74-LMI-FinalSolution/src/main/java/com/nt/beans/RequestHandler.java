package com.nt.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("handler")
@Scope("prototype")
public class RequestHandler {
	private static int count,reqCount;
	
	
	public RequestHandler() {
		count++;
		System.out.println("RequestHandler::0-param cosnstructor:::"+count);
	}
	
	public   void  processRequest(String data) {
		reqCount++;
		System.out.println("processing request no"+reqCount+" with data"+data+"by handler ::"+count);
	}

}
