package com.nt.controller;

import com.nt.dto.EmplyoeeDTO;
import com.nt.service.EmployeeService;
import com.nt.vo.EmployeeVO;

public class MainController {
	 private EmployeeService  service;
	
	public MainController(EmployeeService service) {
	   System.out.println("MainController.1-param constructor");
		this.service = service;
	}

	public   String processEmployee(EmployeeVO vo)throws   Exception{
		EmplyoeeDTO dto=null;
		String result=null;
		//convert VO class obj  to DTO class object
		dto=new EmplyoeeDTO();
		dto.setEmpName(vo.getEmpName());
		dto.setEmpAddress(vo.getEmpAddress());
		dto.setBasicSalary(Float.parseFloat(vo.getBasicSalary()));
		//use Service
		result=service.registerEmployee(dto);
		return result;
	}
}
