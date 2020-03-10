package com.nt.aspect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

public class CacheAspect {
	private Map<String,Object> map=new HashMap();
	public  Object  caching(ProceedingJoinPoint pjp) throws Throwable{
		Object retVal=null;
		String key=null;
		key=pjp.getSignature()+Arrays.toString(pjp.getArgs());
		if(!map.containsKey(key)) {
			retVal=pjp.proceed();
			map.put(key, retVal);
			System.out.println("from target method");
		}
		else {
			retVal=map.get(key);
			System.out.println("from cache");
		}
		
		return retVal;
		
	}//method
}//class
