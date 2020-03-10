package com.nt.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public abstract class BaseDTO implements Serializable {
	private int id;
	private String name;
	private String addrs;

}
