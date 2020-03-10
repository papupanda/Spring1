package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
    public   int getEmpsCount();
    public  String getEmpNameByNo(int no);
    public Map<String,Object>  getEmployeeByNo(int no);
    public List<Map<String,Object>>  getEmployeesByDesg(String desg);
    public int insert(String ename,String desg,float salary);
    public  int getSalary(int empNo);
    public  int  updateSalary(int empNo,int newSalary);
    
}
