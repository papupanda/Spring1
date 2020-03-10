package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

@WebServlet(value="/controller",loadOnStartup = 1)
public class MainControllerServlet extends HttpServlet {
	 ApplicationContext ctx;
	@Override
	public void init() throws ServletException {
	  ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	}
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 int srcAcno=0,destAcno=0;
		 float amount=0;
		 BankService proxy=null;
		 String result=null;
		 RequestDispatcher rd=null;
		// get PrintWriter
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //read form data
		 srcAcno=Integer.parseInt(req.getParameter("srcAcno"));
		 destAcno=Integer.parseInt(req.getParameter("destAcno"));
		 amount=Float.parseFloat(req.getParameter("amount"));
		 //get Proxy obect
		 proxy=ctx.getBean("bankService",BankService.class);
		 try {
			 //invoke method
			 result=proxy.transferMoney(srcAcno,destAcno ,amount);
			 //keep result in request scope
			 req.setAttribute("result",result);
			 //forward request result.jsp
			 rd=req.getRequestDispatcher("/result.jsp");
			 rd.forward(req,res);
		 }
		 catch(Exception e){
			 e.printStackTrace();
			 rd=req.getRequestDispatcher("/error.jsp");
			 rd.forward(req,res);
		 }
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req, res);
	}//doPost(-,-)
	
	
	@Override
	public void destroy() {
	   ctx=null;
	}

}
