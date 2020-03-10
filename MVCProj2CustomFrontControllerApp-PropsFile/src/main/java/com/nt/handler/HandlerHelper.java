package com.nt.handler;

import java.util.ResourceBundle;

public class HandlerHelper {
	private static ResourceBundle bundle;
	static {
		try {
		 //locate config.properties file
			bundle=ResourceBundle.getBundle("com/nt/config/AppConfig");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//static 
	
	public  static  Handler  getHandler(String uri)throws Exception {
		String handlerName=null;
		Handler handler=null;
		//get Handler class name
		handlerName=bundle.getString(uri);
		//create Handler class object 
		handler=(Handler)Class.forName(handlerName).newInstance();
		return handler;
		
	}

}
