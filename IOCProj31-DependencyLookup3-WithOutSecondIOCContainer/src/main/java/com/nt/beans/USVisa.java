package com.nt.beans;

import java.util.Calendar;

public class USVisa {
	
	public USVisa() {
		System.out.println("USVisa:0-param constructor");
	}
	
	public boolean isApproved() {
		Calendar cal=null;
		int month=0;
		cal=Calendar.getInstance(); //sys date
		month=cal.get(Calendar.MONTH); //0-11
		if(month>=1 && month<=5)
			return true;
		else
			return false;
		
	}

}
