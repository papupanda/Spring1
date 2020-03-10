package com.nit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LocaleService {
	
	public  String  generateCountry(HttpServletRequest req,HttpServletResponse res);
	public  String  generateLangauge(HttpServletRequest req,HttpServletResponse res);
		
	
}
