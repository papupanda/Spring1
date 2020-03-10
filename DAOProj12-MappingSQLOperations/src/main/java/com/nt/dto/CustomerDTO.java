package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CustomerDTO implements Serializable {
	private int srNo;
	private int custId;
	private  String custName;
	private String custAddrs;
	private  float  pAmt;
	private  float intrAmt;

}
