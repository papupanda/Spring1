package com.nt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "NIT")
@Data
public class Employee {
	@Id
	private int eid;
	private String ename;
	private String[] addrs;
	private float salary;
	

}
