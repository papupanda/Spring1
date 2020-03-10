package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.handler.Handler;
import com.nt.handler.SystemDateHandler;
import com.nt.handler.SystemPropsHandler;

public class NitControllerServlet extends HttpServlet {
	
	 @Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         Handler handler=null;
         String lvn=null;
         String target=null;
         RequestDispatcher rd=null;
         //Action Management
         if(req.getServletPath().equalsIgnoreCase("/date.do"))
        	 handler=new SystemDateHandler();
         else if(req.getServletPath().equalsIgnoreCase("/props.do"))
        	 handler=new SystemPropsHandler();
         else
        	 throw new IllegalArgumentException("invalid incoming request");
           lvn=handler.execute(req, res);
 
         //view management
         if(lvn.equalsIgnoreCase("date"))
        	 target="/show_date.jsp";
         else if(lvn.equalsIgnoreCase("props"))
        	 target="/show_props.jsp";
         else
        	 throw new IllegalArgumentException("invalid logical view name");
		 //forward to view comp (result jsp)
         rd=req.getRequestDispatcher(target);
         rd.forward(req,res);
	}
	 
	 @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}

}
