package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("logAdvice")
@Aspect
@Order(1)
public class AroundLoggingAdvice  {
   
	@Around("execution(float com.nt.service.BankService.calc*(..))")
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
	       Object retVal=null;
		System.out.println("Entering into "+pjp.getSignature()+" with args"+Arrays.toString(pjp.getArgs()));
				retVal=pjp.proceed();
		System.out.println("Exiting from "+pjp.getSignature()+" with args"+Arrays.toString(pjp.getArgs()));
		return retVal;
	}

}
