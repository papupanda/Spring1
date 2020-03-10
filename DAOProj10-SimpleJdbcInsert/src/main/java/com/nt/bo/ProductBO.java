package com.nt.bo;

import lombok.Data;

@Data
public class ProductBO {
	private int pid;
	private String pname; 
	private float qty;
	private float price;
	private boolean status;

}
