package com.nt.service;

import java.util.Calendar;

public class WishMessageServiceImpl implements WishMessageService {
  
	@Override
	public String generateWishMessage() {
		Calendar calendar=null;
		int hour=0;
		//get System date
		calendar=Calendar.getInstance();
		//get current hour of the day
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		//generate wish Message
		if(hour<12)
			return "Good Morning";
		else if(hour<16)
			return "Good AfterNoon";
		else if(hour<20)
			return "Good Evening";
		else 
			return "Good Night";
	}

}
