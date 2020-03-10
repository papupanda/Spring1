package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeMgmtService {
    public   String registerEmployee(EmployeeDTO dto);
    public   List<EmployeeDTO>  getAllEmployees();
    public   String  updateEmployeeById(int id,String[] newAddrs);
}
