package com.nt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO extends BaseDTO {
	private  String  desg;
	private float exp;
	
	public EmployeeDTO() {
		System.out.println("EmployeeDTO::0-param constructor");
	}

	@Override
	public String toString() {
		return "EmployeeDTO:"+super.toString()+" [desg=" + desg + ", exp=" + exp + "]";
	}
	
	
	

}
