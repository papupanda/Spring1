package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class CommonExceptionLogger {
	
	 public   void exceptionLogger(JoinPoint jp,ArithmeticException ex) {
		 System.out.println(ex.toString()+" exception is raised in"+jp.getSignature()+" with args"+Arrays.deepToString(jp.getArgs()));
	 }
	 
	 public   void exceptionLogger(JoinPoint jp,Exception e) {
		 System.out.println(e.toString()+" exception is raised in"+jp.getSignature()+" with args"+Arrays.deepToString(jp.getArgs()));
	 }

}
