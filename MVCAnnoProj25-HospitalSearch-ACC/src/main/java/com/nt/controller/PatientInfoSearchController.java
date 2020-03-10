package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nt.command.PatientDetailsInfoCommand;
import com.nt.dto.PatientDetailsInputDTO;
import com.nt.dto.PatientDetailsResultDTO;
import com.nt.service.PatientMgmtService;

@Controller
public class PatientInfoSearchController  {
	@Autowired
	private PatientMgmtService service;

	@RequestMapping("/home.htm")
	 public  String showHomePage() {
		
		 return "search";
	 }
	

	@RequestMapping("/search.htm")
	public String search(Map<String,Object> map, @ModelAttribute("patientCmd")PatientDetailsInfoCommand cmd) {
		PatientDetailsInputDTO idto=null;
		List<PatientDetailsResultDTO> listRDTO=null;
		//convert cmd to dto
		idto=new PatientDetailsInputDTO();
		BeanUtils.copyProperties(cmd, idto);
		//use service
		listRDTO=service.search(idto);
		//keep results in Map object
		map.put("listRDTO",listRDTO);
		//retrun lvn
		return "show_results";
		
	}

}
