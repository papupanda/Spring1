package com.nt.bo;

import lombok.Data;

@Data
public class PatientDetailsResultBO extends PatientDetailsInputBO {
   private int pid;
   private int wardNo;
   private long contactNo;
   private  int age;
   
	
}
