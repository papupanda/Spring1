package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.PatientDetailsInputBO;
import com.nt.bo.PatientDetailsResultBO;
import com.nt.dao.PatientInfoDAO;
import com.nt.dto.PatientDetailsInputDTO;
import com.nt.dto.PatientDetailsResultDTO;

public class PatientMgmtServiceImpl implements PatientMgmtService {
	private PatientInfoDAO dao;

	public PatientMgmtServiceImpl(PatientInfoDAO dao) {
		this.dao = dao;
	}

	@Override
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
