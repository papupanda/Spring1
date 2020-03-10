package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeMgmtService {
   public int registerEmployee(EmployeeDTO dto);
   public  EmployeeDTO fetchEmpById(int id);
   public List<EmployeeDTO> fetchEmpsByAddresses(String addrs1,String addrs2);
   public List<EmployeeDTO> fetchEmpsByAddresses1(String addrs1,String addrs2);
   public  List<EmployeeDTO> fetchEmpsBySalaryRange(float start,float end);
   public  int   removeEmpsBySalaryMark(float maxSalary);
   public  int   hikeEmpsSalaryByAddrs(String addrs,float percentage);
   
}
