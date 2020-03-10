package com.nt.service;

import java.util.Random;

public class ATMPinGenerator {
	
	public   int   generatePin() {
		Random rad=null;
		int value=0;
		rad=new Random();
		value=rad.nextInt(10000);
		return value;
	}

}
