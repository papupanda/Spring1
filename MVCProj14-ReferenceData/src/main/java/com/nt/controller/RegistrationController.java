package com.nt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.RegisterCommand;

public class RegistrationController extends SimpleFormController {

	@Override
	public Map referenceData(HttpServletRequest request) throws Exception {
		Map<String,List<?>> dataMap=new HashMap();
		List<String> genderList=null;
		List<String> hobiesList=null;
		List<String> countriesList=null;
		List<String> colorsList=null;
		System.out.println("RegistrationController.referenceData(-)");
		genderList=new ArrayList();
		genderList.add("male"); genderList.add("female");
		dataMap.put("genderInfo",genderList);
		
		hobiesList=new ArrayList();
		hobiesList.add("roaming");hobiesList.add("eating");
		hobiesList.add("dancing");hobiesList.add("sleeping");
		hobiesList.add("surfing");
		dataMap.put("hobiesInfo",hobiesList);
		
		countriesList=new ArrayList();
		countriesList.add("select country");
		countriesList.add("india");countriesList.add("pakistan");
		countriesList.add("Austrilia");countriesList.add("nepal");
		countriesList.add("srilanka");
		dataMap.put("countriesInfo",countriesList);
		
		
		colorsList=new ArrayList();
		colorsList.add("red");colorsList.add("black");
		colorsList.add("white");colorsList.add("green");
		dataMap.put("colorsInfo",colorsList);
		return dataMap;
	}
	
	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		System.out.println("RegistrationController.onSubmit()");
		return new ModelAndView("result","cmdData",((RegisterCommand)command));
		
	}
	
}
