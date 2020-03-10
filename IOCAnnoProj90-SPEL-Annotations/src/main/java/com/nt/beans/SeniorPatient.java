package com.nt.beans;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("patient")
@PropertySource(value="classpath:com/nt/commons/info.properties")
public class SeniorPatient {
	@Value("#{T(java.lang.Math).random()*100}")
	private  int pid;
	@Value("#{'${patient.name}'}")
	private  String pname;
	@Value("#{sysDate}")
	private Date billDate;
	@Value("#{'${patient.age}'}")
	private int age;
	@Value("#{T(java.util.Arrays).asList(tc.cardioTreatements[0],tc.cardioTreatements[3])}")
	private  List<String> availedCardioTreatememts;
	@Value("#{tc.cardioTreatementCharges['ag']+tc.cardioTreatementCharges['ap']}")
	private  float cardioTreatementChargesTotal;
	
	@Value("#{T(java.util.Arrays).asList(tc.orthoTreatements[0],tc.orthoTreatements[2])}")
	private  List<String> availedorthoTreatememts;
	@Value("#{tc.orthoTreatementCharges['krt']+tc.orthoTreatementCharges['dl']}")
	private  float orthoTreatementChargesTotal;

	@Value("#{T(java.util.Arrays).asList(tc.naturopathyTreatements[0],tc.naturopathyTreatements[2])}")
	private  List<String> availedNaturopathyTreatememts;
	@Value("#{tc.naturopathyTreatementCharges['masaz']+tc.naturopathyTreatementCharges['steamBath']}")
	private  float naturopathyTreatementChargesTotal;
	@Value("#{tc.cardioTreatementCharges['ag']+tc.cardioTreatementCharges['ap'] + tc.orthoTreatementCharges['krt']+tc.orthoTreatementCharges['dl'] + tc.naturopathyTreatementCharges['masaz']+tc.naturopathyTreatementCharges['steamBath']}")
	private  float  finalBillAmount;
	
	
	
	
	

}
