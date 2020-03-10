package com.nt.beans;

import java.util.Date;

public class Car {
	private String regNo;
	private  String model;
	private  Date dop;
	
	public Car(String regNo, String model, Date dop) {
		System.out.println("Car.Car(-,-,-)");
		this.regNo = regNo;
		this.model = model;
		this.dop = dop;
	}

	@Override
	public String toString() {
		return "Car [regNo=" + regNo + ", model=" + model + ", dop=" + dop + "]";
	}
	
	
 
	

}
