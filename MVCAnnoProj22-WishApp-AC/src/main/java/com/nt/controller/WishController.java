package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.service.WishService;

@Controller
public class WishController {
	@Autowired
	 private WishService service;
	
	@RequestMapping("/wish.htm")
	public   ModelAndView  process() {
		String resultMsg=null;
		//use service
		resultMsg=service.generateWishMessage();
		//return MAV
		return new ModelAndView("result","resMsg",resultMsg);
		
	}

}
