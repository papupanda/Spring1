package com.nt.beans;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Student {
	private  int[] marks;
	private Date  dates[];

	

	public void setDates(Date[] dates) {
		System.out.println("Student:setDates(-)");
		this.dates = dates;
	}

	public Student() {
		System.out.println("Student:0-param constructor");
	}

	public void setMarks(int[] marks) {
		System.out.println("Student.setMarks(-)");
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [marks=" + Arrays.toString(marks) + ", dates=" + Arrays.toString(dates) + "]";
	}

	
	

}
