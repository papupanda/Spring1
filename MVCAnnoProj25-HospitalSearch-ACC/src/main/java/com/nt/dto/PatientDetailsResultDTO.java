package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PatientDetailsResultDTO extends PatientDetailsInputDTO {
   private int srNo;
	private int pid;
   private int wardNo;
   private long contactNo;
   private  int age;
   
	
}
