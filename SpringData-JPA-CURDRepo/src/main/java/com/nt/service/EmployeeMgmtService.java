package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;

public interface EmployeeMgmtService {
	
	public  String registerEmployee(EmployeeDTO dto);
	public  EmployeeDTO fetchEmployeeById(int id);
	public  List<EmployeeDTO> fetchAllEmployees();
	public  List<EmployeeDTO>  fetchEmpsByIds(int id1,int id2);
	public  List<EmployeeDTO> fetchEmpsBySalaryRange(float start,float end);
	public  float  getEmpAvgSalary();
	public List<EmployeeDTO> fetchEmpsByAddrs(String addrs);
	public  int  addBonusToEmployeesByAddresses(String addrs1,String addrs2,float bonus);
	

}
