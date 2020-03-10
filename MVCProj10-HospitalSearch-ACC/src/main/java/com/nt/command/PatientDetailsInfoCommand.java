package com.nt.command;

import lombok.Getter;
import lombok.Setter;

//@Data
@Getter
@Setter
public class PatientDetailsInfoCommand {
	private String pname;
	private String paddrs;
	private String problem;
	private String doctor;
	
	public PatientDetailsInfoCommand() {
		System.out.println("PatientDetailsInfoCommand::0-param constructor");
	}

}
