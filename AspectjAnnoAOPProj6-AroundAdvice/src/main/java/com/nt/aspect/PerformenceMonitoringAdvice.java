package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("pmAdvice")
@Aspect
@Order(2)
public class PerformenceMonitoringAdvice  {
   private long start,end;
   
   @Around("execution(float com.nt.service.BankService.calc*(..))")
	public Object monitoring(ProceedingJoinPoint pjp) throws Throwable {
		Object retVal=null;
		start=System.currentTimeMillis();
		retVal=pjp.proceed();
		end=System.currentTimeMillis();
		System.out.println(pjp.getSignature()+" with args"+Arrays.toString(pjp.getArgs())+" has taken "+(end-start)+" ms to complete the execution");
		return retVal;
	}

}
