package com.nt.command;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JobSeekerInfoCommand {
	private String name;
	private  int age;
	private  String addrs;
	private String skillDomain;
	private  String currentCompany;
	private float experience;
	private String prefferedLocation;
	private  float expectedSalary;
	private  float noticePeriod; 
	
	public JobSeekerInfoCommand() {
		System.out.println("JobSeekerInfoCommand:: 0-param contructor");
	}
	
	

}
