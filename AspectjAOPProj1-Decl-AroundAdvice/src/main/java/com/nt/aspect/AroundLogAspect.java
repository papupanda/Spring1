package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundLogAspect {
	
	public   Object   logAround(ProceedingJoinPoint pjp) throws Throwable{
		Object retVal=null;
		Object args[]=null;
		System.out.println("Entering into "+pjp.getSignature()+" with args"+Arrays.deepToString(pjp.getArgs()));
		 args=pjp.getArgs();
		 if(((Float)args[0])<=50000)
			    args[1]=((Float)args[1])-0.5f;
		if(((Float)args[0])<=0 || ((Float)args[1])<=0 || ((Float)args[2])<=0)
			 throw new  IllegalArgumentException("Invalid arg values..");
		else
		   retVal=pjp.proceed(args);
		   
		
		System.out.println("Exiting into "+pjp.getSignature()+" with args"+Arrays.deepToString(pjp.getArgs()));
		 retVal=((Float)retVal)+(((Float)retVal)*0.05f);
		return retVal;
	}//method
}//class
