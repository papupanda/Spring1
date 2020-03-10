package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import com.nt.dispatcher.Dispatcher;
import com.nt.handler.Handler;
import com.nt.handler.HandlerHelper;
import com.nt.handler.SystemDateHandler;
import com.nt.handler.SystemPropsHandler;

public class NitControllerServlet extends HttpServlet {
	
	 @Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         Handler handler=null;
         String lvn=null;
         try {
         //Action Management
         handler=HandlerHelper.getHandler(req.getServletPath());
         lvn=handler.execute(req, res);
         }
         catch(Exception e) {
        	 e.printStackTrace();
         }
 
         try {
         //view management
        	Dispatcher.render(lvn, req, res);
       	}
         catch(Exception e) {
        	 e.printStackTrace();
         }
	 }//doGet(-,-)
	 
	 @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}

}
