package com.nt.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class PinVerifier implements AfterReturningAdvice {

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		
		if( ((Integer)returnValue)<1000)
			throw new  IllegalArgumentException("Weak pin number is generated");

	}

}
