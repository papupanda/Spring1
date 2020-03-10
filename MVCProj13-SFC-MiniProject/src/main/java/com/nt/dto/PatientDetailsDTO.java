package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PatientDetailsDTO implements Serializable{
	private int srNo;
	private int pid;
	private String pname;
	private String paddrs;
	private String problem;
	private int wardNo;
	private long contactNo;
	private String doctor;
	private int age;

}
