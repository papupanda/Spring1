package com.nt.beans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

@Named("voting")
public class CheckVotingElgibilty {
	@Value("raja")
	private  String name;
	@Value("-30")
	private int age;
	//@Value("not sure")
	private String isSingle;
	private  Date sysDate;
	
	public CheckVotingElgibilty() {
		System.out.println("CheckVotingElgibilty.CheckVotingElgibilty()");
	}
	
	
	@PostConstruct
	public void myInit() {
		System.out.println("CheckVotingElgibilty.myInit()");
		//Intiializing left over  properties
		sysDate=new Date();
		//Bean Processing 
		if(isSingle==null)
			isSingle="yes";
		//checking the injection bean propertioes
		if(name==null || age<=0)
			   throw new IllegalArgumentException("set Proper values");
	}
	
	@PreDestroy
	public void  myDestroy() {
		System.out.println("CheckVotingElgibilty.myDestroy()");
		  sysDate=null;
		  name=null;
		  age=0;
		  isSingle=null;
	}
	
	
	//b.method
	public String   checkVotingElgibility() {
		if(age<18)
			  return "Mr."+name+"  u r not elgible to vote or choose modi";
		else
			  return "Mr."+name+"  u r  elgible to vote or choose modi";
	}


	@Override
	public String toString() {
		return "CheckVotingElgibilty [name=" + name + ", age=" + age + ", isSingle=" + isSingle + ", sysDate=" + sysDate
				+ "]";
	}
	
	
	
	
	

}
