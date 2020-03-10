package com.nt.beans;

import java.util.List;
import java.util.Set;

public class EnggCourse {
	private List<String> subjects;

	public EnggCourse(List<String> subjects) {
		System.out.println("EnggCourse:1 -param constructor");
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "EnggCourse [subjects=" + subjects + "]";
	}
	
	

}
