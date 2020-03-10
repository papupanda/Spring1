package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.nt.command.JobSeekerInfoCommand;

public class JobSeekerRegistrationController extends AbstractWizardFormController {

	@Override
	public ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
      JobSeekerInfoCommand cmd;		
		//type casting
      cmd=(JobSeekerInfoCommand)command;
		//return MAV
		return new ModelAndView("result","cmdData",cmd);
	}
	
   @Override
public ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command,
		BindException errors) throws Exception {
     return new ModelAndView("welcome");
   }//method
}//class
