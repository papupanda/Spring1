package com.nt.beans;

import java.util.List;

public class University {
	private  List<String> courses;

	public void setCourses(List<String> courses) {
		this.courses = courses;
		System.out.println(courses.getClass());
	}

	@Override
	public String toString() {
		return "University [courses=" + courses + "]";
	}
	
	

}
