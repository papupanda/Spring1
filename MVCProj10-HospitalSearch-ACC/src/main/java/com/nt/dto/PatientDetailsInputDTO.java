package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PatientDetailsInputDTO implements Serializable {
	private String pname;
	private String paddrs;
	private String problem;
	private String doctor;

}
