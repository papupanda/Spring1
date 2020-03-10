package com.nt.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundLoggingAdvice  implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object retVal=null;
		Object args[]=null;
		System.out.println("Entering into "+invocation.getMethod().getName()+" with args"+Arrays.toString(invocation.getArguments()));
		//get B.method args and modify them
		args=invocation.getArguments();

		if(((Float)args[0])<=0 || ((Float)args[1])<=0 || ((Float)args[2])<=0)
			throw new IllegalArgumentException("Invalid arguements");
		
		if(((Float)args[0])<=50000)
			args[1]=((Float)args[1])-0.5f;
		retVal=invocation.proceed();
		
		System.out.println("Exiting from "+invocation.getMethod().getName()+" with args"+Arrays.toString(invocation.getArguments()));
		
		//modify target method return value.
		retVal=((Float)retVal)+ ((Float)retVal)*0.05f;
		return retVal;
	}

}
