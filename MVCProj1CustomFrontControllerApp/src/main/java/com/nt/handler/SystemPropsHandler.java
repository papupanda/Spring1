package com.nt.handler;

import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SystemPropsHandler implements Handler {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		 Properties props=null;
		//write b.logic
		 props=System.getProperties();
		 //keep in request scope
		 req.setAttribute("result",props);
		 //return lvn(logical view name)
		return "props";
	}

}
