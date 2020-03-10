package com.nt.command;

import java.util.Date;

import lombok.Data;

@Data
public class PersonCommand {
	private String pname;
	private String paddrs;
	private Date dob;
	private Date doj;
	private Date dom=new Date();

}
