package com.nt.handler;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SystemDateHandler implements Handler {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		Date sysDate=null;
		//write b.logic
		 sysDate=new Date();
		 //keep in request scope
		 req.setAttribute("result",sysDate);
		 //return lvn(logical view name)
		return "date";
	}

}
