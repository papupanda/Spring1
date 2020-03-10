package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.dao.EmployeeDAO;

public class EmployeeMgmtService {
	private  EmployeeDAO  dao;

	public EmployeeMgmtService(EmployeeDAO dao) {
		System.out.println("EmployeeMgmtService:: 1-param constructor");
		this.dao = dao;
	}
	
	public  int fetchEmpsCount() {
		int count=0;
		//use DAO
		count=dao.getEmpsCount();
		return count;
	}
	
	public  Map<String,Object>  fetchEmpByNo(int no){
		Map<String,Object> map=null;
		//use DAO
		map=dao.getEmployeeByNo(no);
		return map;
		
	}
	
	public   List<Map<String,Object>> fetchEmpsByDesg(String desg){
		List<Map<String,Object>> list=null;
		//use DAO
		list=dao.getEmployeesByDesg(desg);
		return list;
		
	}
	
	public  String fetchEmpNameByNo(int no) {
		String name=null;
		//use DAO
		name=dao.getEmpNameByNo(no);
		return name;
	}
	
	public    String  register(String name,String desg,float salary) {
		int count=0;
		//use DAO
		count=dao.insert(name, desg, salary);
		if(count==0)
			return "Emp Regsitration failed";
		else
			return "Emp Regsitration succeded";
			
	}
	
	public  int fetchSalaryByEmpNo(int no) {
		int salary=0;
		salary=dao.getSalary(no);
		return salary;
	}
	
	public  String  hikeEmpSalary(int empNo,float hikePercentage) {
		int count=0;
		int salary=0;
		//get salary of the emp
		salary=fetchSalaryByEmpNo(empNo);
		//hike salary
		salary=salary + Math.round((salary*hikePercentage/100.0f));
		//use dAO
		count=dao.updateSalary(empNo, salary);
		if(count==0)
			return " Salary hike failed";
		else
			return " Salary hike succeded";
	}
	
	

}
