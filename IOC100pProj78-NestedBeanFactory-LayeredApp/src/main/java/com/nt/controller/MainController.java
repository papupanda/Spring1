package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

@Controller("controller")
@Lazy
public class MainController {
	@Autowired
	private  EmployeeMgmtService service;

	
	public    List<EmployeeDTO>  fetchEmployeesByDesgs(String[] desg)throws Exception{
		List<EmployeeDTO> listDTO=null;
		//use Service
		listDTO=service.findEmployeesByDesg(desg);
		return listDTO;
		
		
	}

}
