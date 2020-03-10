package com.nt.interceptor;

import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class TimeoutCheckInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		System.out.println("TimeoutCheckInterceptor.preHandle(-,-,-)");
		Calendar calendar=null;
		int hour=0;
		RequestDispatcher rd=null;
		//get System date and time
		calendar=Calendar.getInstance();
		//get current hour of the day
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		//write pre-request processing logic
		if(hour<9 || hour>=17) {
			rd=req.getRequestDispatcher("/timeout.jsp");
			rd.forward(req,res);
			return false;
		}
		return true;
	}

}
