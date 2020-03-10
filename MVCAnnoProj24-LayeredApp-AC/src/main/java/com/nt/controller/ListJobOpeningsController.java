package com.nt.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.dto.JobDetailsDTO;
import com.nt.service.JobPortalMgmtService;

@Controller
public class ListJobOpeningsController  {
	@Autowired
	private JobPortalMgmtService service;
	

	
	@RequestMapping("/home.htm")
	public  String  showHome() {
		return  "welcome";
	}


	@RequestMapping("/list_jobs.htm")
	public String fetchOpenings(Map<String,Object> map) {
		List<JobDetailsDTO> listDTO=null;
		//use service
		listDTO=service.fetchAllOpenings();
		//return MAV object
		map.put("listJobs",listDTO);
		map.put("sysDate",new Date());
		return "show_jobs";
	}

}
