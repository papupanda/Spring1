package com.nt.beans;

import java.util.Calendar;
import java.util.Date;

public class ScheduleRemainder {
	private Calendar date;
	
	public ScheduleRemainder() {
		System.out.println("ScheduleRemainder::0-param constructor");
	}

	public void setDate(Calendar date) {
		System.out.println("ScheduleRemainder.setDate()");
		this.date = date;
	}
	
	public  String  remainder1() {
		Calendar sysDate=Calendar.getInstance();
		if(date.get(Calendar.MONTH)==sysDate.get(Calendar.MONTH) && date.get(Calendar.DATE)==sysDate.get(Calendar.DATE))
			return "Remainder ...tring ..tring :: Its special one's BirthDay.. do Some thing"
					+ "otherwise u need to take rebirth";
		else
			return "No remainders for this day , just focus on fitness";
	}

}
