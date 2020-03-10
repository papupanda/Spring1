package com.nt.advice;

import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.springframework.aop.MethodBeforeAdvice;

import com.nt.dto.LoanCustomerInfo;

public class LoanAuditingAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target) throws Throwable {
	 String auditMsg=null;
	 Writer writer=null;
	 
		/*System.out.println("target method name::"+method.getName());
		System.out.println("target method args::"+Arrays.deepToString(args));
		System.out.println("taget class name::"+target.getClass());*/
		if(method.getName().equalsIgnoreCase("generateLoanId")) {
			auditMsg=((LoanCustomerInfo)args[0]).getCustName()+" customer Loan came for verification to "+((LoanCustomerInfo)args[0]).getClerkName()+" on  "+new Date();
		}
		if(method.getName().equalsIgnoreCase("approveLoan")) { 
			auditMsg=((LoanCustomerInfo)args[1]).getCustName()+" customer Loan with LoanId"+((Integer)args[0])+" came for Approval to "+((LoanCustomerInfo)args[1]).getManagerName()+" on  "+new Date();
		}
		//write to audit log file
		writer =new FileWriter("E:/auditLog.txt",true);
		writer.write(auditMsg+"\n");
		writer.flush();
		writer.close();
		

	}

}
