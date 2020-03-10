package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.JobDetailsBO;
import com.nt.dao.JobOpeningsDAO;
import com.nt.dto.JobDetailsDTO;

@Service("jobService")
public class JobPortalMgmtServiceImpl implements JobPortalMgmtService {
	@Autowired
	private JobOpeningsDAO dao;

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
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
