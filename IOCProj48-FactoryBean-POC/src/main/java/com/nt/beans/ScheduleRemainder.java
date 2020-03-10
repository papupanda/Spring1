package com.nt.beans;

import java.util.Date;

public class ScheduleRemainder {
	private Date date;
	
	public ScheduleRemainder() {
		System.out.println("ScheduleRemainder::0-param constructor");
	}

	public void setDate(Date date) {
		System.out.println("ScheduleRemainder.setDate()");
		this.date = date;
	}
	
	public  String  remainder1() {
		Date sysDate=new Date();
		if(date.getMonth()==sysDate.getMonth() && date.getDate()==sysDate.getDate())
			return "Remainder ...tring ..tring :: Its special one's BirthDay.. do Some thing"
					+ "otherwise u need to take rebirth";
		else
			return "No remainders for this day , just focus on fitness";
	}

}
