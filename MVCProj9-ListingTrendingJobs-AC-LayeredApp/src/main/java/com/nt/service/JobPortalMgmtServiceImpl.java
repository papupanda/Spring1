package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.JobDetailsBO;
import com.nt.dao.JobOpeningsDAO;
import com.nt.dto.JobDetailsDTO;

public class JobPortalMgmtServiceImpl implements JobPortalMgmtService {
	private JobOpeningsDAO dao;

	public JobPortalMgmtServiceImpl(JobOpeningsDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<JobDetailsDTO> fetchAllOpenings() {
		List<JobDetailsBO> listBO=null;
		List<JobDetailsDTO> listDTO=new ArrayList();
		
		//use DAO
		listBO=dao.getAllJobOpenings();
		//convert listBO to listDTO;
		listBO.forEach(bo->{
			JobDetailsDTO dto=new JobDetailsDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
		});
		return listDTO;
	}//method
}//class
