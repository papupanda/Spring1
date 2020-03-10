package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface EmployeeDAO {
	public EmployeeBO getEmployeeByNo(int no);
	public  List<EmployeeBO> getEmployessByDesgs(String desg1,String desg2,String desg3);
	public  List<EmployeeBO> getEmpsByJobs(String desg1,String desg2,String desg3);


}
