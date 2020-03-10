package com.nt.dao;

import java.util.List;

import com.nt.bo.PatientDetailsBO;

public interface PatientDAO {
	
	public List<PatientDetailsBO>  getAllPatients();
	public PatientDetailsBO  getPatientById(int id);
	public int updatePatientById(PatientDetailsBO bo);
	public  int deletePatientById(int pid);

}
