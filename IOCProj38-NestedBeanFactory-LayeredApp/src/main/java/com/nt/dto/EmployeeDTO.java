package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable {
	private int srNo;
	private int eno;
	private String ename;
	private  String desg;
	private int  salary;
	private int deptNo;
}
