package com.nt.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import com.nt.service.ArithmeticService;

public class CommonStaticPointcut extends StaticMethodMatcherPointcut {
	private String methodNames[];

	public void setMethodNames(String[] methodNames) {
		this.methodNames = methodNames;
	}

	public boolean matches(Method method, Class<?> targetClass) {
		String mname=null;
		if(targetClass==ArithmeticService.class) {
			mname=method.getName();
			if(methodNames.length!=0) {
		     	for(String mn:methodNames) {
				  if(mn.equalsIgnoreCase(mname))
					  return true;
			  }//for
			}//if
		}//if
		return false;
	}//method

}//class
