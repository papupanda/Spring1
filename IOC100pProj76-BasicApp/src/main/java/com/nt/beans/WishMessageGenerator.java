package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("wmg")
//@Scope("prototype")
@Lazy
public class WishMessageGenerator {
	@Autowired
	//@Qualifier("createDate")
	private  Date date;
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator.WishMessageGenerator()");
	}
	
	public String  generateWishMessage(String user) {
		System.out.println("WishMessageGenerator.generateWishMessage()");
		int  hour=0;
		 //get current hour of the day
		hour=date.getHours();
		//generate wish Mssage
		if(hour<12)
			 return "Good Morning::"+user;
		else if(hour<16)
			 return "Good Afternoon::"+user;
		else if(hour<20)
			 return "Good Evening::"+user;
		else
			return "Good Night::"+user;
	}

}
