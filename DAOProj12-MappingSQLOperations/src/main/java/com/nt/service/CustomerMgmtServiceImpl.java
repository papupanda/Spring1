package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.CustomerBO;
import com.nt.dao.CustomerDAO;
import com.nt.dto.CustomerDTO;

@Service("custService")
public class CustomerMgmtServiceImpl implements CustomerMgmtService {
	@Autowired
	private CustomerDAO dao;

	public CustomerDTO fetchCustomerById(int id) {
		CustomerBO bo=null;
		CustomerDTO dto=null;
		//use DAO
		bo=dao.getCustomerById(id);
		//convert bo to dto
		dto=new CustomerDTO();
		dto.setSrNo(1);
		BeanUtils.copyProperties(bo,dto);
		return dto;
	}
	
	public List<CustomerDTO> fetchCustomersByLoanAmtRange(float start, float end) {
	    List<CustomerBO> listBO=null;
	    List<CustomerDTO> listDTO=new ArrayList();
	    //use DAO
	    listBO=dao.getCustomersByLoanAmtRange(start, end);
	    //convert listBO to listDTO
	    listBO.forEach(bo->{
	    	CustomerDTO dto=new CustomerDTO();
	    	dto.setSrNo(listDTO.size()+1);
	    	BeanUtils.copyProperties(bo,dto);
	    	listDTO.add(dto);
	    });
	    
		return listDTO;
	}

}
