package com.nt.service;

import java.util.List;

import com.nt.dto.JobDetailsDTO;

public interface JobPortalMgmtService {
	
	public  List<JobDetailsDTO> fetchAllOpenings();

}
