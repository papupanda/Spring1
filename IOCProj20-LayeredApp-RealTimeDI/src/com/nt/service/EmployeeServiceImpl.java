package com.nt.service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmplyoeeDTO;

public final class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO dao;
	
	public EmployeeServiceImpl(EmployeeDAO dao) {
		System.out.println("EmployeeServiceImpl.1-param constructor");
		this.dao = dao;
	}//constructor

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
		bo.setEmpNo(dto.getEmpNo());
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
