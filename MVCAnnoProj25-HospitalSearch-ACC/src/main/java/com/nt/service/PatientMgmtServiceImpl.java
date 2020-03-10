package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.PatientDetailsInputBO;
import com.nt.bo.PatientDetailsResultBO;
import com.nt.dao.PatientInfoDAO;
import com.nt.dto.PatientDetailsInputDTO;
import com.nt.dto.PatientDetailsResultDTO;

@Service("patientMgmtService")
public class PatientMgmtServiceImpl implements PatientMgmtService {
	@Autowired
	private PatientInfoDAO dao;

	

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<PatientDetailsResultDTO> search(PatientDetailsInputDTO iDTO) {
		PatientDetailsInputBO iBO=null;
		List<PatientDetailsResultBO> listRBO=null;
		List<PatientDetailsResultDTO> listRDTO=new ArrayList();
		//convert iDTO to iBO
		iBO=new PatientDetailsInputBO();
		BeanUtils.copyProperties(iDTO, iBO);
		
		if(iBO.getPname().length()!=0)
			iBO.setPname(iBO.getPname()+"%");
		
		iBO.setPaddrs(iBO.getPaddrs().length()!=0?iBO.getPaddrs()+"%":iBO.getPaddrs());
		iBO.setDoctor(iBO.getDoctor().length()!=0?iBO.getDoctor()+"%":iBO.getDoctor());
		iBO.setProblem(iBO.getProblem().length()!=0?iBO.getProblem()+"%":iBO.getProblem());
		
		
		//use DAO
		listRBO=dao.find(iBO);
		//convert listRBO to listRDTO
		listRBO.forEach(bo->{
			PatientDetailsResultDTO dto=new PatientDetailsResultDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSrNo(listRDTO.size()+1);
			listRDTO.add(dto);
		});
		return listRDTO;
	}//serch

}//class
