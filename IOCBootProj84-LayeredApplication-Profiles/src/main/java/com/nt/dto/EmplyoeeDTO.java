package com.nt.dto;

import java.io.Serializable;

import lombok.Data;



@Data
public class EmplyoeeDTO implements Serializable {
	private String empName;
	private String empAddress;
	private float basicSalary;
	

}//class
