package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeMgmtService {
	
	public  void  showAllEmployeesPageWise(int pageSize);
	public  String  removeEmployeeInBatch(List<EmployeeDTO> batchDTO);

}
