package com.nt.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.JobDetailsDTO;
import com.nt.service.JobPortalMgmtService;

public class ListJobOpeningsController extends AbstractController {
	private JobPortalMgmtService service;
	

	public ListJobOpeningsController(JobPortalMgmtService service) {
		this.service = service;
	}


	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<JobDetailsDTO> listDTO=null;
		ModelAndView mav=null;
		//use service
		listDTO=service.fetchAllOpenings();
		//return MAV object
		mav=new ModelAndView();
		mav.addObject("listJobs",listDTO);
		mav.addObject("sysDate",new Date());
		mav.setViewName("show_jobs");
		return mav;
	}

}
