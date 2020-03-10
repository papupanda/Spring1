package com.nt.service;

import java.util.List;

import com.nt.dto.CustomerDTO;

public interface CustomerMgmtService {
	
	public CustomerDTO  fetchCustomerById(int id);
	public List<CustomerDTO> fetchCustomersByLoanAmtRange(float start,float end);

}
