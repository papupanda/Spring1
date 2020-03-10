package com.nt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO extends BaseDTO {
	private  String course;
	private  String qlfy;
	
	public StudentDTO() {
		System.out.println("StudentDTO:0-param constructor");
	}

	@Override
	public String toString() {
		return "StudentDTO"+super.toString()+" [course=" + course + ", qlfy=" + qlfy + "]";
	}
	
	
	

}
