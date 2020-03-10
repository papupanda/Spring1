package com.nt.beans;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("tc")
@PropertySource(value="classpath:com/nt/commons/info.properties")
public class TreatmentCharges {
	@Value("#{sysDate}")
	private  Date date;
	@Value("#{'${cardioTreatements}'.split(',')}")
	private Set<String> cardioTreatements;
	@Value("#{${cardioTreatementCharges}}")
	private Map<String,Float> cardioTreatementCharges;
	
	@Value("#{'${orthoTreatements}'.split(',')}")
	private Set<String> orthoTreatements;
	@Value("#{${orthoTreatementCharges}}")
	private Map<String,Float> orthoTreatementCharges;
	
	@Value("#{'${naturopathyTreatements}'.split(',')}")
	private Set<String> naturopathyTreatements;
	@Value("#{${naturopathyTreatementCharges}}")
	private Map<String,Float> naturopathyTreatementCharges;
	
	public TreatmentCharges() {
		System.out.println("TreatmentCharges:: 0-param constructor");
	}
	
	
	
	

}
