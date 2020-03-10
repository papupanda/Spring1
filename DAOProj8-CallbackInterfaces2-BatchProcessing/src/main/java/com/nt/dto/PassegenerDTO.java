package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PassegenerDTO implements Serializable {
	private String psngrName;
	private int age;
	private  String source;
	private  String destination;
	private  int fare;

}
