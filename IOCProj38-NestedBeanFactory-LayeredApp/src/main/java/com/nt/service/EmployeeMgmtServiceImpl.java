package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	private EmployeeDAO dao;

	public EmployeeMgmtServiceImpl(EmployeeDAO dao,String type) {
		System.out.println("EmployeeMgmtServiceImpl.2-param constructor:::"+type);
		this.dao = dao;
	}

	public List<EmployeeDTO> findEmployeesByDesg(String[] desg) throws Exception {
		StringBuffer sb=null;
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO> listDTO=null;
		EmployeeDTO  dto=null;
		//convert desg[] as required SQL Condition
		sb=new StringBuffer("(");
		for(int i=0;i<desg.length;++i) {
			  if(i==desg.length-1)
				  sb.append("'"+desg[i]+"'");
			  else
				  sb.append("'"+desg[i]+"',");
		}
		sb.append(")");
		//use DAO
		listBO=dao.getEmployeesByDesgs(sb.toString());
		//convert listBO to listDTO 
		listDTO=new ArrayList();
		for(EmployeeBO bo:listBO) {
			dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
		}//for
		return listDTO;
	}//method
}//class
