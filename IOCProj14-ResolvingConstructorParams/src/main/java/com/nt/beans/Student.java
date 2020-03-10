package com.nt.beans;

public class Student {
	private int sno;


	private String sname;
	private float avg;

	public Student(int no, String sname, float avg) {
		System.out.println("Student:3-param constructor");
		this.sno = no;
		this.sname = sname;
		this.avg =avg;
	}
	
	public void setSname(String sname) {
		System.out.println("Student.setSname(-)");
		this.sname = sname;
	}


	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", avg=" + avg + "]";
	}
	
	

}
