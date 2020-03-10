package com.nt.vo;



public class EmployeeVO {
	private String empName;
	private String empAddress;
	private String basicSalary;
	
	public EmployeeVO() {
		System.out.println("EmployeeVO:0-paaram constructor");
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

	public String getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(String basicSalary) {
		this.basicSalary = basicSalary;
	}

}//class
