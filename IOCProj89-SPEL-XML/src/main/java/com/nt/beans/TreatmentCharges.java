package com.nt.beans;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class TreatmentCharges {
	private  Date date;
	private Set<String> cardioTreatements;
	private Map<String,Float> cardioTreatementCharges;
	private Set<String> orthoTreatements;
	private Map<String,Float> orthoTreatementCharges;
	private Set<String> naturopathyTreatements;
	private Map<String,Float> naturopathyTreatementCharges;
	
	public TreatmentCharges() {
		System.out.println("TreatmentCharges:: 0-param constructor");
	}
	
	
	
	

}
