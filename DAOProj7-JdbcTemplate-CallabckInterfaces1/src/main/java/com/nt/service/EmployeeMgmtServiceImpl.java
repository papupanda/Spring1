package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	@Autowired
	private EmployeeDAO dao;
	

	public EmployeeDTO fetchEmployeeByNo(int empNo) {
		EmployeeBO bo=null;
		EmployeeDTO dto=null;
		//use DAO
		bo=dao.getEmployeeByNo(empNo);
		//convert BO to DTO
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(bo,dto);
		return dto;
	}


	@Override
	public List<EmployeeDTO> fetchEmployeesByDesgs(String desg1, String desg2, String desg3) {
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO> listDTO=new ArrayList();

		//use DAO
		listBO=dao.getEmployessByDesgs(desg1, desg2, desg3);
		//convert listBO to listDTO
		/*listDTO=new ArrayList();
		for(EmployeeBO bo:listBO) {
		   EmployeeDTO dto=new EmployeeDTO();
		   BeanUtils.copyProperties(bo, dto);
		   listDTO.add(dto);
		}*/
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
			listDTO.add(dto);
		});
		return listDTO;
	}//method


	@Override
	public List<EmployeeDTO> fetchEmpsByJobs(String desg1, String desg2, String desg3) {
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO> listDTO=new ArrayList();
	    //use DAO
		listBO=dao.getEmpsByJobs(desg1, desg2, desg3);
		//convert listBO to listDTO
		 listBO.forEach(bo->{
			 EmployeeDTO dto=new EmployeeDTO();
			 BeanUtils.copyProperties(bo, dto);
			 listDTO.add(dto);
		 });
		return listDTO;
	}
}//class
