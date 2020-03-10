package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductDTO implements Serializable {
	private String pname; 
	private float qty;
	private float price;
	private boolean status;

}
