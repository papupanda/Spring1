package com.nt.dao;

import java.util.List;

import com.nt.bo.CustomerBO;

public interface CustomerDAO {
	public  CustomerBO  getCustomerById(int id);
	public  List<CustomerBO> getCustomersByLoanAmtRange(float start,float end);

}
