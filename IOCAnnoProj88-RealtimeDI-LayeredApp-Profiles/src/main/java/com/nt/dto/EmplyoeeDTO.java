package com.nt.dto;

import java.io.Serializable;



public class EmplyoeeDTO implements Serializable {
	private String empName;
	private String empAddress;
	private float basicSalary;
	
	public EmplyoeeDTO() {
		System.out.println("EmplyoeeDTO:0-param constructor");
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public float getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}

}//class
