package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.nt.command.UserCommand;

public class PerformOperationsController extends MultiActionController {
	
	public  ModelAndView  insert(HttpServletRequest req,HttpServletResponse res,UserCommand cmd)throws Exception{
		System.out.println("PerformOperationsController.insert(-,-,-)");
		return new ModelAndView("user_form","result","insert operation");
	}
	
	public  ModelAndView  update(HttpServletRequest req,HttpServletResponse res,UserCommand cmd)throws Exception{
		System.out.println("PerformOperationsController.update(-,-,-)");
		return new ModelAndView("user_form","result","update operation");
	}
	
	public  ModelAndView  delete(HttpServletRequest req,HttpServletResponse res,UserCommand cmd)throws Exception{
		System.out.println("PerformOperationsController.delete(-,-,-)");
		return new ModelAndView("user_form","result","delete operation");
	}
	
	public  ModelAndView  view(HttpServletRequest req,HttpServletResponse res,UserCommand cmd)throws Exception{
		System.out.println("PerformOperationsController.view(-,-,-)");
		return new ModelAndView("user_form","result","view operation");
	}
	
	public  ModelAndView  invalid(HttpServletRequest req,HttpServletResponse res,UserCommand cmd)throws Exception{
		System.out.println("PerformOperationsController.invalid(-,-,-)");
		return new ModelAndView("user_form","result","invalid operation");
	}




	
	
	

}
