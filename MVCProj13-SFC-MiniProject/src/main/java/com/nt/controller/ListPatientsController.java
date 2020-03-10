package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.PatientDetailsDTO;
import com.nt.service.HospitalMgmtService;

public class ListPatientsController extends AbstractController {
	private HospitalMgmtService  service;

	public ListPatientsController(HospitalMgmtService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		List<PatientDetailsDTO> listDTO=null;
		//use service
		listDTO=service.fetchAllPatients();
		//return MAV object
		return new ModelAndView("list_patients","listDTO", listDTO);
	}

}
