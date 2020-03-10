package com.nt.beans;

import java.util.Date;
import java.util.Set;

import lombok.Data;

@Data
public class SeniorPatient {
	private  int pid;
	private  String pname;
	private Date billDate;
	private int age;
	private  Set<String> availedCardioTreatememts;
	private  float cardioTreatementChargesTotal;
	private  Set<String> availedorthoTreatememts;
	private  float orthoTreatementChargesTotal;
	private  Set<String> availedNaturopathyTreatememts;
	private  float naturopathyTreatementChargesTotal;
	private  float  finalBillAmount;
	
	
	
	
	

}
