package com.nt.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.nt.manager.AuthenticationManager;

public class SecurityCheckAdvice implements MethodBeforeAdvice {
	private AuthenticationManager manager;

	public SecurityCheckAdvice(AuthenticationManager manager) {
		this.manager = manager;
	}

	public void before(Method method, Object[] args, Object target) throws Throwable {
		   if(!manager.validate())
			   throw new IllegalAccessException("Invalid Credetails");

	}

}
