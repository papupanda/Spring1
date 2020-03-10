package com.nt.bo;

import lombok.Data;

@Data
public class CustomerBO {
	private int custId;
	private  String custName;
	private String custAddrs;
	private  float  pAmt;
	private  float intrAmt;

}
