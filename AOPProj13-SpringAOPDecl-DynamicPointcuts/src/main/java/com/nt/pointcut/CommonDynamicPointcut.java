package com.nt.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import com.nt.service.ArithmeticService;

public class CommonDynamicPointcut extends DynamicMethodMatcherPointcut {
	private String methodNames[];
	private  float  condValues[];
	private  Class  tarClass;


	public void setTarClass(Class targetClass) {
		this.tarClass = targetClass;
	}

	public void setCondValues(float[] condValues) {
		this.condValues = condValues;
	}

	public void setMethodNames(String[] methodNames) {
		this.methodNames = methodNames;
	}

	public boolean matches(Method method, Class<?> targetClass, Object... args) {
    if(tarClass!=null) {		
	   if(targetClass==tarClass) {
		   if(methodNames!=null) {
			   for(String m:methodNames) {
				   if(m.equalsIgnoreCase(method.getName())) {
					    if(((Float)args[0])>=condValues[0] && ((Float)args[1])>=condValues[1])
					    	return true;
				   }
			   }
		   }
	   }
    }
		return false;
	}//method
}//class
