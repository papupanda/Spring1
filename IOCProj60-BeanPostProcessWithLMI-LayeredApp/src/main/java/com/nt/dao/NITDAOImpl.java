package com.nt.dao;

import com.nt.bo.EmployeeBO;
import com.nt.bo.StudentBO;

public class NITDAOImpl implements NITDAO {

	@Override
	public int insertStudent(StudentBO bo) {
		System.out.println("NITDAOImpl.insertStudent()--->"+bo);
		return 1;
	}

	@Override
	public int insertEmployee(EmployeeBO bo) {
		System.out.println("NITDAOImpl.insertEmployee()--->"+bo);
		return 1;
	}

}
