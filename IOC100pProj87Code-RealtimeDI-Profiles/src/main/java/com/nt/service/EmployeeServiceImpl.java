package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmplyoeeDTO;

@Service("empService")
public  class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO dao;
	
	
	@Override
	public String registerEmployee(EmplyoeeDTO dto) throws Exception {
		float grossSalary=0.0f;
		float netSalary=0.0f;
		EmployeeBO bo=null;
		int count;
		//write B.Logic
		//calculate net salary
		grossSalary=dto.getBasicSalary()+(dto.getBasicSalary()*0.3f);
		netSalary=grossSalary-((dto.getBasicSalary())*0.2f);
		//prepare BO object
		bo=new EmployeeBO();
		bo.setEmpName(dto.getEmpName());
		bo.setEmpAddress(dto.getEmpAddress());
		bo.setBasicSalary(dto.getBasicSalary());
		bo.setGrossSalary(grossSalary);
		bo.setNetSalary(netSalary);
		//use DAO
		count=dao.insert(bo);
		//process the result
		if(count==1)
			return "Employee Registration Done::->"+" BasicSalary:"+dto.getBasicSalary()+" GrossSalary:"+grossSalary+" Netsalary:"+netSalary;
		else
			return "Employee Registration Failed::->"+" BasicSalary:"+dto.getBasicSalary()+" GrossSalary:"+grossSalary+" Netsalary:"+netSalary;
	}//registerEmp(-)

}//class
