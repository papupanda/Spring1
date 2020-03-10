package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.PersonCommand;

public class PersonRegistrationController extends SimpleFormController {

	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		PersonCommand cmd=null;
		System.out.println("PersonRegistrationController.onSubmit()");
		//type casting
		cmd=(PersonCommand)command;
		//return MAV object
		return new ModelAndView("result","perCmd",cmd);
	}
	
	@Override
	public void initBinder(HttpServletRequest req, ServletRequestDataBinder binder) throws Exception {
		System.out.println("PersonRegistrationController.initBinder()");
		binder.registerCustomEditor(Date.class, 
				     new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"),true));
	}
	
}
