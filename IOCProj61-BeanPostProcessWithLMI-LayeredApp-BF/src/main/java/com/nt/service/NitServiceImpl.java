package com.nt.service;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBO;
import com.nt.bo.StudentBO;
import com.nt.dao.NITDAO;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.StudentDTO;

public  abstract class NitServiceImpl implements NitService {
		private  NITDAO  dao;
		
		
	
	public NitServiceImpl(NITDAO dao) {
		this.dao = dao;
	}
	
	public abstract StudentBO createStudentBO();
	public abstract EmployeeBO createEmployeeBO();

	@Override
	public String registerStudent(StudentDTO dto) {
		StudentBO bo=null;
		int count=0;
	     //get StudentBO class obj by using LMI
		bo=createStudentBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		count=dao.insertStudent(bo);
		if(count==0)
		   return  "Student registration failed";
		else
			 return  "Student registration succeded";
	}

	@Override
	public String registerEmployee(EmployeeDTO dto) {
		EmployeeBO bo=null;
		int count=0;
	     //get StudentBO class obj by using LMI
		bo=createEmployeeBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		count=dao.insertEmployee(bo);
		if(count==0)
		   return  "Employee registration failed";
		else
			 return  "Employee registration succeded";
	}

}
