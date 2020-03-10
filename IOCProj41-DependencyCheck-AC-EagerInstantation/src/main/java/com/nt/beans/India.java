package com.nt.beans;

public class India {
	private  int countryCode;
	private String nickName;
	private  float area;
    private  Kashmir  kashmir;
    
    public India() {
		System.out.println("India:: 0-param costructor");
	}
    
	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setArea(float area) {
		this.area = area;
	}
	public void setKashmir(Kashmir kashmir) {
		this.kashmir = kashmir;
	}

	@Override
	public String toString() {
		return "India [countryCode=" + countryCode + ", nickName=" + nickName + ", area=" + area + ", kashmir="
				+ kashmir + "]";
	}
	
	
	

}
