package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.bo.BaseBO;
import com.nt.bpp.BaseBOBeanPostProcessor;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.StudentDTO;
import com.nt.service.NitService;

public class MainControllerServlet extends HttpServlet {
	
	 DefaultListableBeanFactory factory=null;
	@Override
	public void init() throws ServletException {
		XmlBeanDefinitionReader reader=null;
		BaseBOBeanPostProcessor bpp=null;
		
	   factory=new DefaultListableBeanFactory();
	   reader=new XmlBeanDefinitionReader(factory);
	   reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
	   //register  BeanPostPostProcessor explicitly with BeanFactory Container
	   bpp=new BaseBOBeanPostProcessor();
	   factory.addBeanPostProcessor(bpp);
	   
	}
	
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     NitService  service=null;
	     String s1Val=null;
	     StudentDTO stDTO=null;
	     EmployeeDTO  empDTO=null;
	     String resultMsg=null;
	     RequestDispatcher rd=null;
	     
	     
		//get Service class object
	     service=factory.getBean("nitService",NitService.class);
	     //read s1 req param value
	     s1Val=req.getParameter("s1");
	     if(s1Val.equalsIgnoreCase("registerStudent")) {
	    	 //read form data and store StudentDTO class object
	    	 stDTO=new StudentDTO();
	    	 stDTO.setId(Integer.parseInt(req.getParameter("sno")));
	    	 stDTO.setName(req.getParameter("sname"));
	    	 stDTO.setAddrs(req.getParameter("sadd"));
	    	 stDTO.setQlfy(req.getParameter("qlfy"));
	    	 stDTO.setCourse(req.getParameter("course"));
	    	 //use service
	    	 resultMsg=service.registerStudent(stDTO);
	    	 //keep result in request scope
	    	 req.setAttribute("result",resultMsg);
	     }
	     else if(s1Val.equalsIgnoreCase("registerEmp")) {
	    	 //read form data and store StudentDTO class object
	    	 empDTO=new EmployeeDTO();
	    	 empDTO.setId(Integer.parseInt(req.getParameter("empNo")));
	    	 empDTO.setName(req.getParameter("ename"));
	    	 empDTO.setAddrs(req.getParameter("eadd"));
	    	 empDTO.setDesg(req.getParameter("desg"));
	    	 empDTO.setExp(Float.parseFloat(req.getParameter("exp")));
	    	 //use service
	    	 resultMsg=service.registerEmployee(empDTO);
	    	 //keep result in request scope
	    	 req.setAttribute("result",resultMsg);
	     }
	     
	     //forward to   reuslt.jsp
	     rd=req.getRequestDispatcher("/result.jsp");
	    		 rd.forward(req,res);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}
	
	
	
	@Override
	public void destroy() {
	  factory=null;
	}
	
	

}
