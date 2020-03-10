package com.nt.advice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component("pmAdvice")
public class PerformenceMonitoringAdvice implements MethodInterceptor {
       
	public Object invoke(MethodInvocation invocation) throws Throwable {
		  Object retVal=null;
		  long start=0,end=0;
		  if(invocation.getMethod().getName().equals("add") || invocation.getMethod().getName().equals("mul")) {
		  start=System.currentTimeMillis();
		  retVal=invocation.proceed();
		  end=System.currentTimeMillis();
		  System.out.println(invocation.getMethod().getName()+" has taken "+(end-start)+" ms to complete the execution");
		  }
		  else {
			  retVal=invocation.proceed();
		  }
		
		return retVal;
	}

}
