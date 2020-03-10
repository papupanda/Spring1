package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class JobDetailsDTO implements Serializable{
	private int srNo;
	private int jobId;
	private String company;
	private String domain;
	private String position;
	private String salaryRange;
	private int nop;
	private String expRange;
	private  String  location;

}
