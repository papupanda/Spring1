package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	      
	@Override
	public Map<String, Object> fetchEmpById(int no) {
		Map<String,Object> empMap=null;
		//use dAO
		empMap=dao.getEmpById(no);
		return empMap;
	}

	@Override
	public String fetchEmpNameById(int no) {
		String name=null;
		//use DAO
		name=dao.getEmpNameById(no);
		return name;
	}

	@Override
	public List<EmployeeDTO> fetchEmpsByDesgs(String desg1, String desg2, String desg3) {
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO> listDTO=new ArrayList();
		
		
		//use DAO
		listBO=dao.getEmpsByDesgs(desg1, desg2, desg3);
		//convert listBO to listDTO
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
			listDTO.add(dto);
		});
		return listDTO;
	}//method

	@Override
	public String registerEmployee(EmployeeDTO dto) {
		int count=0;
		EmployeeBO bo=null;
		//convert dto to bo
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		count=dao.insert(bo);
		//process the result
		if(count==0)
			return "Emp registration failed";
		else
			return "Emp Registration succeded";
	}
}//class
