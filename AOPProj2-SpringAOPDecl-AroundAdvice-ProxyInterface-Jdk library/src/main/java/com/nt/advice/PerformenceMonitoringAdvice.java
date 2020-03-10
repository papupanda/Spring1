package com.nt.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformenceMonitoringAdvice implements MethodInterceptor {
   private long start,end;
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object retVal=null;
		start=System.currentTimeMillis();
		retVal=invocation.proceed();
		end=System.currentTimeMillis();
		System.out.println(invocation.getMethod().getName()+" with args"+Arrays.toString(invocation.getArguments())+" has taken "+(end-start)+" ms to complete the execution"+invocation.getClass());
		return retVal;
	}

}
