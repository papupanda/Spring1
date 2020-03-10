package com.nt.service;

import com.nt.dto.EmployeeDTO;
import com.nt.dto.StudentDTO;

public interface NitService {
	
	public   String  registerStudent(StudentDTO dto);
	public   String  registerEmployee(EmployeeDTO dto);

}
