package com.nt.beans;

import java.util.Date;

public class Owner {
	private String name;
	private long aid;
	private Date dob;
	private  Car  car;
	public void setName(String name) {
		this.name = name;
	}
	public void setAid(long aid) {
		this.aid = aid;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	
	@Override
	public String toString() {
		return "Owner [name=" + name + ", aid=" + aid + ", dob=" + dob + ", car=" + car + "]";
	}
	

}
