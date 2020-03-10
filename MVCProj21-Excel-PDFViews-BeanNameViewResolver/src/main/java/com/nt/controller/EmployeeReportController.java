package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.EmployeeDTO;

public class EmployeeReportController extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		EmployeeDTO dto1=null,dto2=null,dto3=null;
		List<EmployeeDTO> listDTO=null;
		//construct model data
		dto1=new EmployeeDTO();
		dto1.setEid(1001); dto1.setEname("karan"); dto1.setDesg("clerk");
		dto1.setEaddrs("hyd"); dto1.setSalary(9000);
		dto2=new EmployeeDTO();
		dto2.setEid(1002); dto2.setEname("arjun"); dto2.setDesg("clerk");
		dto2.setEaddrs("vizag"); dto2.setSalary(10000);
		dto3=new EmployeeDTO();
		dto3.setEid(1003); dto3.setEname("reddy"); dto3.setDesg("manager");
		dto3.setEaddrs("delhi"); dto3.setSalary(3000);
		listDTO=new ArrayList();
		listDTO.add(dto1); listDTO.add(dto2); listDTO.add(dto3);
		
		//return MAV object
		if(req.getParameter("type").equalsIgnoreCase("excel"))
		      return new ModelAndView("excelView","listDTO",listDTO);
		else
			  return new ModelAndView("pdfView","listDTO",listDTO);
	}

}
