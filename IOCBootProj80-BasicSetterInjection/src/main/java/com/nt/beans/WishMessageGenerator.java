package com.nt.beans;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	@Autowired
	private Calendar calendar;
	
	public   String genrateWishMessage(String user ) {
		int hour=0;
		//get current hour of the day
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		//generate wish Message
		if(hour<12)
			return "Good Morning:::"+user;
		else  if(hour<16)  
			return "Good AfterNoon:::"+user;
		else if(hour<20)
			return "Good evening:::"+user;
		else
			return "Good night:::"+user;
	}

}
