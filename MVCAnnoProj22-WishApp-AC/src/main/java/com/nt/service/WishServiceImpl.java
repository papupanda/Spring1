package com.nt.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service("wService")
public class WishServiceImpl implements WishService {

	@Override
	public String generateWishMessage() {
		Calendar calendar=null;
		int hour=0;
		//get System date and time
		calendar=Calendar.getInstance();
		//get current hour of the day
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		//generate  wish MEssage
		if(hour<=12)
			return "Good Morning::";
		else if(hour<=16)
			return "Good after noon:";
		else if(hour<=20)
			return "Good  evening:";
		else
			return "Good night:";
	}

}
