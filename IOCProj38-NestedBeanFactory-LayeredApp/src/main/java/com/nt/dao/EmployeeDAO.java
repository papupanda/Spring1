package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface EmployeeDAO {
	public   List<EmployeeBO>  getEmployeesByDesgs(String cond)throws Exception;

}
