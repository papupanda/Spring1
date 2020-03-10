package com.nt.advice;

import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.ThrowsAdvice;

import com.nt.exception.CustomerAlreadyExistException;

public class CommongExceptionLogger_Grapher implements ThrowsAdvice {
	
	public  void afterThrowing(IllegalArgumentException iae) throws Throwable {
		  Writer writer=null;
		  System.out.println("2");
		  //create new FileWriter
		  writer=new FileWriter("e:/expLog.txt",true);
		  writer.write(iae.toString()+" exception is raised in \n");
		  writer.flush();
		  writer.close();
		}
	
	
	public  void afterThrowing(Exception iae) throws Throwable {
		  Writer writer=null;
		  System.out.println("3");
		  //create new FileWriter
		  writer=new FileWriter("e:/expLog.txt",true);
		  writer.write(iae.toString()+" exception is raised in \n");
		  writer.flush();
		  writer.close();
		}
	
	
	public  void afterThrowing(Method method,Object args[],Object target,IllegalArgumentException iae) throws Throwable {
		  Writer writer=null;
		  System.out.println("1");
		  //create new FileWriter
		  writer=new FileWriter("e:/expLog.txt",true);
		  writer.write(iae.toString()+" exception is raised in "+target.getClass().getName()+" for "+method.getName()+" with args"+Arrays.deepToString(args)+"\n");
		  writer.flush();
		  writer.close();
		}
	
	
	
	
	
	

	
	public  void afterThrowing(Method method,Object args[],Object target,Throwable iae) throws Throwable {
	  Writer writer=null;
	  System.out.println("4");
	  //create new FileWriter
	  writer=new FileWriter("e:/expLog.txt",true);
	  writer.write(iae.toString()+" exception is raised in "+target.getClass().getName()+" for "+method.getName()+" with args"+Arrays.deepToString(args)+"\n");
	  writer.flush();
	  writer.close();
	}
	
	
	
	
	
	

}
