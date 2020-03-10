package com.nt.dao;

import java.util.List;

import com.nt.bo.PatientDetailsInputBO;
import com.nt.bo.PatientDetailsResultBO;

public interface PatientInfoDAO {
	
	public List<PatientDetailsResultBO> find(PatientDetailsInputBO ibo);

}
