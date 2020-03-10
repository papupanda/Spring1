package com.nt.dispatcher;

import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dispatcher {
	private static ResourceBundle bundle;
	static {
		try {
			 //locate config.properties file
				bundle=ResourceBundle.getBundle("com/nt/config/AppConfig");
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void render(String lvn,HttpServletRequest req,HttpServletResponse res)throws Exception{
		String physicalView=null;
		RequestDispatcher rd=null;
	
		//get physical view name based on given logic view name(lvn)
		physicalView=bundle.getString(lvn);
		//forward to physical view
		rd=req.getRequestDispatcher(physicalView);
		rd.forward(req, res);
	}
}
