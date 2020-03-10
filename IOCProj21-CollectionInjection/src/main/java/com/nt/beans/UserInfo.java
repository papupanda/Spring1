package com.nt.beans;

import java.util.Date;
import java.util.Set;

public class UserInfo {
	private  Set<Long> phoneNumbers;
	private  Set<Date> dates;
	
	public UserInfo() {
		System.out.println("UserInfo:0-param constructor");
	}
	
	public void setPhoneNumbers(Set<Long> phoneNumbers) {
		System.out.println("UserInfo:setPhoneNumbers(-)"+phoneNumbers.getClass());
		this.phoneNumbers = phoneNumbers;
	}
	public void setDates(Set<Date> dates) {
		System.out.println("UserInfo:setDates(-)");
		this.dates = dates;
	}

	@Override
	public String toString() {
		return "UserInfo [phoneNumbers=" + phoneNumbers + ", dates=" + dates + "]";
	}
	
	

}
