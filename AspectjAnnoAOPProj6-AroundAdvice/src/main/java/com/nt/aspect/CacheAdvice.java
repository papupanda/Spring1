package com.nt.aspect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("cacheAdvice")
@Aspect
@Order(0)
public class CacheAdvice {
   private Map<String,Object>  cacheMap=new HashMap<String, Object>();
   
   @Around("execution(float com.nt.service.BankService.calcCompound*(..))")
	public Object caching(ProceedingJoinPoint pjp) throws Throwable {
		Object retVal=null;
		String key=null;
		//prepare key
		key=pjp.getSignature()+Arrays.toString(pjp.getArgs());
		if(!cacheMap.containsKey(key)) {
			retVal=pjp.proceed();
			cacheMap.put(key,retVal);
			System.out.println("from tagret method");
		}
		return cacheMap.get(key);
	}

}
