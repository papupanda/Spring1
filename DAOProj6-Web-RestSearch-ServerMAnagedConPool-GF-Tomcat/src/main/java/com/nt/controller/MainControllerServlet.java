package com.nt.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.RestaurantMgmtService;

//@WebServlet(value="/controller",loadOnStartup = 1)
public class MainControllerServlet extends HttpServlet {
	private ApplicationContext ctx;
	
	@Override
	public void init() throws ServletException {
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	}
    
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String loc=null;
		RestaurantMgmtService  service=null;
		List<Map<String,Object>> list=null;
		RequestDispatcher rd=null;
	    //read form data
		loc=req.getParameter("location");
		//get Service class object
		service=ctx.getBean("restService",RestaurantMgmtService.class);
		try {
		//invoke method
		list=service.searchRestaurantsByLocation(loc);
		System.out.println(list.size());
		//keep results in requst scope
		req.setAttribute("restList",list);
		//forward to show_detais.jsp
		rd=req.getRequestDispatcher("/show_details.jsp");
		rd.forward(req,res);
		}
		catch(Exception e) {
			e.printStackTrace();
			rd=req.getRequestDispatcher("/error.jsp");
			rd.forward(req,res);
		}
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	@Override
	public void destroy() {
	   //close container
		((AbstractApplicationContext) ctx).close();
	}

}
