package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.PatientDetailsCommand;
import com.nt.dto.PatientDetailsDTO;
import com.nt.service.HospitalMgmtService;

public class EditPatientController extends SimpleFormController {
	private HospitalMgmtService service;
	

	public EditPatientController(HospitalMgmtService service) {
		this.service = service;
	}


	@Override
	public Object formBackingObject(HttpServletRequest req) throws Exception {
       int id=0;
       PatientDetailsDTO dto=null;
       PatientDetailsCommand cmd=null;
		// read id req param value
       id=Integer.parseInt(req.getParameter("id"));
       //use service
       dto=service.fetchPatientById(id);
       //create Command class object
       cmd=new PatientDetailsCommand();
       BeanUtils.copyProperties(dto,cmd);
       return cmd;
	}
	
	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		PatientDetailsCommand cmd=null;
		PatientDetailsDTO dto=null;
		String resultMsg=null;
		List<PatientDetailsDTO> listDTO=null;
		ModelAndView mav=null;
		//type casting
		cmd=(PatientDetailsCommand)command;
		//convert cmd to dto
		dto=new PatientDetailsDTO();
		BeanUtils.copyProperties(cmd,dto);
		//use Service
		resultMsg=service.modifyPatientById(dto);
		listDTO=service.fetchAllPatients();
		//create and return MAV object
		mav=new ModelAndView();
		mav.addObject("listDTO",listDTO);
		mav.addObject("resultMsg",resultMsg);
		mav.setViewName(getSuccessView());
        return mav;		
	
	}
	
}
