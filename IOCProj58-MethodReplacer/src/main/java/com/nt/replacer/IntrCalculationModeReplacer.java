package com.nt.replacer;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.beans.factory.support.MethodReplacer;

public class IntrCalculationModeReplacer implements MethodReplacer {

	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("IntrCalculationModeReplacer.reimplement():: compound Intr Calculation");
		System.out.println("Target obj class name:"+obj.getClass());
		System.out.println("Target method name::"+method.getName());
		System.out.println("Target method args"+Arrays.toString(args));
		//get Parameter values
		float pAmt=(Float)(args[0]);
		float rate=(Float)args[1];
		float time=(Float)args[2];
		
		if(pAmt<=0.0f || rate<=0.0f || time<=0.0f)
			throw new IllegalArgumentException("Invalid Inputs");
		//calculate Compund Intr Amount
		return  (pAmt*Math.pow(1+rate/100, time))-pAmt;
	}

}
