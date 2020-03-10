package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class CheckVotingElgiblity implements InitializingBean,DisposableBean{
	private  String name;
	private  byte age;
	private  String addrs;
	private  Date sysDate;
	
	public CheckVotingElgiblity() {
		System.out.println("CheckVotingElgiblity::0-param constructor");
	}
	
	public void setName(String name) {
		System.out.println("CheckVotingElgiblity.setName(-)");
		this.name = name;
	}
	public void setAge(byte age) {
		System.out.println("CheckVotingElgiblity.setAge(-)");
		this.age = age;
	}
	public void setAddrs(String addrs) {
		System.out.println("CheckVotingElgiblity.setAddrs(-)");
		this.addrs = addrs;
	}
	
	public  void myInit() {
		System.out.println("CheckVotingElgiblity.myInit()");
		sysDate=new Date();
		if(name==null  || age<=0)
			throw new IllegalArgumentException("Invalid inputs");
	}
	
	public void myDestroy() {
		System.out.println("CheckVotingElgiblity.myDestroy()");
		name=null;
		addrs=null;
		age=0;
		sysDate=null;
	}
	
	//method
	public   String  checkVotingElgibility() {
		if(age>=18)
			return "Mr/Miss/Mrs."+name+"  u r eglible for voting";
		else
			return "Mr/Miss/Mrs."+name+"  u r not eglible for voting";
	}

	@Override
	public String toString() {
		return "CheckVotingElgiblity [name=" + name + ", age=" + age + ", addrs=" + addrs + ", sysDate=" + sysDate
				+ "]";
	}

	public void destroy() throws Exception {
		System.out.println("CheckVotingElgiblity.destroy()");
		name=null;
		addrs=null;
		age=0;
		sysDate=null;
		
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("CheckVotingElgiblity.afterPropertiesSet()");
		sysDate=new Date();
		if(name==null  || age<=0)
			throw new IllegalArgumentException("Invalid inputs");
		
	}
	
	

}
