package com.nt.service;

import java.util.List;

import com.nt.dto.PatientDetailsInputDTO;
import com.nt.dto.PatientDetailsResultDTO;

public interface PatientMgmtService {
	
	public  List<PatientDetailsResultDTO> search(PatientDetailsInputDTO idto);

}
