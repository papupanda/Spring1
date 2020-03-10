package com.nt.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("allAdvices")
@Aspect
public class AllAdvices {
	
	@Pointcut("execution(float com.nt.service.ArithmeticService.*(..))")
	public  void myPtc() {
		
	}
	
	@Around("myPtc()")
	public  Object  monitor(ProceedingJoinPoint pjp)throws Throwable{
		Object retVal=null;
		System.out.println("from Around advice");
		retVal=pjp.proceed();
		return retVal;
	}
	
	@Before("myPtc()")
	public  void    logBefore(JoinPoint jp)throws Throwable{
	     System.out.println("from before advice");	
	}
	
	@AfterReturning(value="myPtc()",returning = "result")
	public  void    logAfter(JoinPoint jp, float result)throws Throwable{
	     System.out.println("from after advice");	
	}
	
	@AfterThrowing(value="myPtc()",throwing="ex")
	public  void    expLogger(JoinPoint jp,Exception ex)throws Throwable{
	     System.out.println("from throws advice");	
	}

}
