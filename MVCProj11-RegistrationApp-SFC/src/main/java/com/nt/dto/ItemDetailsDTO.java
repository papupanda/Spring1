package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ItemDetailsDTO implements Serializable {
	private String itemName;
	private String  category;
	private String  status;
	private float price;
	private  String restaurant;

}
