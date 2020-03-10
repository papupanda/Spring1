package com.nt.bo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentBO extends BaseBO {
	private  String course;
	private  String qlfy;
	
	public StudentBO() {
		System.out.println("StudentBO.0-param constructor");
	}

	@Override
	public String toString() {
		return "StudentBO"+super.toString()+" [course=" + course + ", qlfy=" + qlfy + "]";
	}
	
	
}
