package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.PatientDetailsDTO;
import com.nt.service.HospitalMgmtService;

public class DeletePatientController extends AbstractController {
    private  HospitalMgmtService service;
    
	public DeletePatientController(HospitalMgmtService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		String resultMsg=null;
		ModelAndView mav=null;
		List<PatientDetailsDTO> listDTO=null;
		System.out.println("DeletePatientController.handleRequestInternal()");
		//use service
		resultMsg=service.removePatientById(Integer.parseInt(req.getParameter("id")));
		listDTO=service.fetchAllPatients();
		//return MAV
		mav=new ModelAndView();
		mav.setViewName("list_patients");
		mav.addObject("resultMsg",resultMsg);
		mav.addObject("listDTO",listDTO);
		return mav;
	}
	
	
	
	

}
