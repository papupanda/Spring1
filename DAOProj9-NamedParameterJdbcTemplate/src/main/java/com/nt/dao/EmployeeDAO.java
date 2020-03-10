package com.nt.dao;

import java.util.List;
import java.util.Map;

import com.nt.bo.EmployeeBO;

public interface EmployeeDAO {
	
	public   Map<String,Object>  getEmpById(int no);
	public  String  getEmpNameById(int no);
	public   List<EmployeeBO> getEmpsByDesgs(String desg1,String desg2,String desg3);
    public   int insert(EmployeeBO bo);

}
