package com.nt.beans;

public class Kashmir {
	private  String name;
	private  String type;
	private  float area;
	
	public Kashmir() {
		System.out.println("Kashmir::0-param constructor");
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setArea(float area) {
		this.area = area;
	}
	
	@Override
	public String toString() {
		return "Kashmir [name=" + name + ", type=" + type + ", area=" + area + "]";
	}
	
	

}
