package com.nt.aspect;

import java.io.FileWriter;
import java.io.Writer;

import org.aspectj.lang.JoinPoint;

public class DiscountCuponAspect {
	
	public  void   cuponGeneration(JoinPoint jp,float billAmt)throws Throwable{
		String cuponMsg=null;
		Writer writer=null;
		
		if(billAmt>=50000)
			cuponMsg="Avail 30% on next purchase";
		else if(billAmt>=30000)
			cuponMsg="Avail 20% on next purchase";
		else if(billAmt>=20000)
			cuponMsg="Avail 10% on next purchase";
		else
			cuponMsg="Avail 5% on next purchase";
		try {
		//generate discount cupon
		writer=new FileWriter("e:/cupont.txt");
		writer.write(cuponMsg);
		writer.flush();
		writer.close();
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
	}//method
}//class
