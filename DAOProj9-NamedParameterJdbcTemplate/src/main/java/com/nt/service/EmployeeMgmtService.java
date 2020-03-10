package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.dto.EmployeeDTO;

public interface EmployeeMgmtService {
	
	public  Map<String,Object>  fetchEmpById(int no);
	public  String  fetchEmpNameById(int no);
	public  List<EmployeeDTO>  fetchEmpsByDesgs(String desg1,String desg2,String desg3);
	public  String  registerEmployee(EmployeeDTO dto);

}
