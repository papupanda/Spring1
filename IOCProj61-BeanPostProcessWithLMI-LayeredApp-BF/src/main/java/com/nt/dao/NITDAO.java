package com.nt.dao;

import com.nt.bo.EmployeeBO;
import com.nt.bo.StudentBO;

public interface NITDAO {
	public  int  insertStudent(StudentBO bo);
	public  int  insertEmployee(EmployeeBO bo);

}
