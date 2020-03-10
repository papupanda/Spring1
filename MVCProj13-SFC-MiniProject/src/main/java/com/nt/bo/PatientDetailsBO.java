package com.nt.bo;

import lombok.Data;

@Data
public class PatientDetailsBO {
	private int pid;
	private String pname;
	private String paddrs;
	private String problem;
	private int wardNo;
	private long contactNo;
	private String doctor;
	private int age;

}
