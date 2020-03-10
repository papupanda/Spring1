package com.nt.dao;

import java.util.List;

import com.nt.entity.EmployeeHLO;

public interface EmployeeDAO {
	public  int insert(EmployeeHLO hlo);
	public EmployeeHLO getEmpById(int id);
	public List<?> getEmpsByAddresses(String adrrs1,String addrs2);
	public List<?> getEmpsByAddresses1(String adrrs1,String addrs2);
	public  List<?> getEmpsBySalaryRange(float start,float end);
	public  int fireEmpsBySalaryMark(float maxSalary);
	public  int updateEmpsSalaryByAddrs(String addrs,float newSalary);
	
	

}
