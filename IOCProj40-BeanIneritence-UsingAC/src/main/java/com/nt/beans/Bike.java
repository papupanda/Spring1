package com.nt.beans;

public class Bike {
	private String regNo;
	private  long engineNo;
	private  String company;
	private  String  color;
	private int engienCC;
	private  String ownerName;
	private  int tankCapacity;
	private String modelName;
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public void setEngineNo(long engineNo) {
		this.engineNo = engineNo;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setEngienCC(int engienCC) {
		this.engienCC = engienCC;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public void setTankCapacity(int tankCapacity) {
		this.tankCapacity = tankCapacity;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	@Override
	public String toString() {
		return "Bike [regNo=" + regNo + ", engineNo=" + engineNo + ", company=" + company + ", color=" + color
				+ ", engienCC=" + engienCC + ", ownerName=" + ownerName + ", tankCapacity=" + tankCapacity
				+ ", modelName=" + modelName + "]";
	}
	
	

}
