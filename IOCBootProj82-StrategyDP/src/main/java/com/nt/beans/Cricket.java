package com.nt.beans;

import javax.inject.Named;

import org.springframework.context.annotation.Primary;

@Named("cricket")
@Primary
public final class Cricket implements Sport {
	
	public Cricket() {
		System.out.println("Cricket:: 0-param constructor");
	}

	@Override
	public String equipment() {
		return "Cricket:: Bat,ball,wickets,Golves,Helmet,pads and etc...";
	}

}
