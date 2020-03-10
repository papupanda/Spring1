package com.nt.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.service.WishMessageService;

public class WishMessageGeneratorController extends AbstractController {
	private WishMessageService service;
	

	public WishMessageGeneratorController(WishMessageService service) {
		this.service = service;
	}


	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String msg=null;
		//use service
		msg=service.generateWishMessage();
			return new ModelAndView("result", "wmsg", msg);
	}

}
