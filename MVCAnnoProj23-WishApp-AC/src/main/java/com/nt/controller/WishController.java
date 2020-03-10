package com.nt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import com.nt.service.WishService;

@Controller
public class WishController {
	@Autowired
	 private WishService service;
	
	@RequestMapping("/home.htm")
	public  String  showHomePage() {
		return "welcome";
	}
	
	/*@RequestMapping("/wish.htm")
	public   ModelAndView  process() {
		String resultMsg=null;
		//use service
		resultMsg=service.generateWishMessage();
		//return MAV
		return new ModelAndView("result","resMsg",resultMsg);
		
	}*/
	
	/*@RequestMapping("/wish.htm")
	public   String  process(Model model) {
		String resultMsg=null;
		//use service
		System.out.println("model obj class name::"+model.getClass());
		resultMsg=service.generateWishMessage();
		//return MAV
		model.addAttribute("resMsg",resultMsg);
		return "result";
		
	}*/
	
	/*@RequestMapping("/wish.htm")
	public   String  process(ModelMap map) {
		String resultMsg=null;
		//use service
		System.out.println("model obj class name::"+map.getClass());
		resultMsg=service.generateWishMessage();
		//return MAV
		map.addAttribute("resMsg",resultMsg);
		return "result";
		
	}*/
	
	
	/*	@RequestMapping("/wish.htm")
		public   String  process(Map<String,Object> map) {
			String resultMsg=null;
			//use service
			System.out.println("model obj class name::"+map.getClass());
			resultMsg=service.generateWishMessage();
			//return MAV
			map.put("resMsg",resultMsg);
			return "result";
			
		}*/
	
	/*@RequestMapping("/wish.htm")
	public   String  process(BindingAwareModelMap map) {
		String resultMsg=null;
		//use service
		System.out.println("model obj class name::"+map.getClass());
		resultMsg=service.generateWishMessage();
		//return MAV
		map.put("resMsg",resultMsg);
		return "result";
		
	}
	*/
	
	/*@RequestMapping("/wish.htm")
	public  Model  process() {
		String resultMsg=null;
		Model model=null;
		//use service
		resultMsg=service.generateWishMessage();
		//return MAV
		model=new ExtendedModelMap();
		model.addAttribute("resMsg",resultMsg);
	  return model;
		
		
	}*/
	
	/*@RequestMapping("/wish.htm")
	public  Map<String,Object>  process() {
		String resultMsg=null;
		Map<String,Object> map=null;
		//use service
		resultMsg=service.generateWishMessage();
		//return MAV
		map=new HashMap();
		map.put("resMsg",resultMsg);
	  return map;
	}*/
	
	/*@RequestMapping("/wish.htm")
	public  void  process(Map<String,Object> map) {
		String resultMsg=null;
		//use service
		resultMsg=service.generateWishMessage();
		//return MAV
		map.put("resMsg",resultMsg);
	}*/
	
	@RequestMapping("/wish.htm")
	public  View  process(Map<String,Object> map) {
		String resultMsg=null;
		InternalResourceView view=null;
		//use service
		resultMsg=service.generateWishMessage();
		//return MAV
		map.put("resMsg",resultMsg);
		view=new InternalResourceView();
		view.setUrl("/WEB-INF/pages/result.jsp");
		return view;
		
	}
	


}
