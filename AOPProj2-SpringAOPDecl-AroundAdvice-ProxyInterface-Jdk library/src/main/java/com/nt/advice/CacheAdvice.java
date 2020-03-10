package com.nt.advice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.IvParameterSpec;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CacheAdvice implements MethodInterceptor {
   private Map<String,Object>  cacheMap=new HashMap<String, Object>();
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object retVal=null;
		String key=null;
		//prepare key
		key=invocation.getMethod().getName()+Arrays.toString(invocation.getArguments());
		if(!cacheMap.containsKey(key)) {
			retVal=invocation.proceed();
			cacheMap.put(key,retVal);
			System.out.println("from tagret method");
		}
		return cacheMap.get(key);
	}

}
