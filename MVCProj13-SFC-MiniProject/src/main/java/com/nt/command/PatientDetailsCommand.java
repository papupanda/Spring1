package com.nt.command;

import lombok.Data;

@Data
public class PatientDetailsCommand {
	private int pid;
	private String pname;
	private String paddrs;
	private String problem;
	private int wardNo;
	private long contactNo;
	private String doctor;
	private int age;

}
