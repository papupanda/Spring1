package com.nit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nit.service.LocaleService;
import com.nit.service.LocaleServiceImpl;

@Controller
public class LocaleController {
	@Autowired
	private LocaleService service;
	
	@RequestMapping("/count.htm")
	public   ModelAndView   processForCountryList(HttpServletRequest req, HttpServletResponse res) {
		String msg=null;
		//use service
		service=new LocaleServiceImpl();
		msg=service.generateCountry(req, res);

		return  new ModelAndView("country_list","msg",msg);
	} 
	
	@RequestMapping("/lang.htm")
	public   ModelAndView   processForLangaugeList(HttpServletRequest req, HttpServletResponse res) {
		String msg=null;
		//use service
		service=new LocaleServiceImpl();
		msg=service.generateLangauge(req, res);

		return  new ModelAndView("langauge_list","msg",msg);
	} 

}
