package com.nt.advice;

import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class DiscountCuponAdvice implements AfterReturningAdvice {

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		float bAmt=0.0f;
		String cuponMsg=null;
		bAmt=(Float)returnValue;
		Writer writer=null;
		
		if(bAmt>=50000)
			cuponMsg="Avail  30% discount on next purchase";
		else if(bAmt>=30000)
			cuponMsg="Avail  20% discount on next purchase";
		else if(bAmt>=10000)
			cuponMsg="Avail  10% discount on next purchase";
		else
			cuponMsg="Avail  5% discount on next purchase";
		//generate Cupon
		writer=new FileWriter("E:/cupon.txt");
		writer.write(cuponMsg);
		writer.flush();
		writer.close();
		

	}

}
