package com.nt.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Viechle {
	private String beanId;
	
	
	
	public Viechle(String beanId) {
		System.out.println("Viechle:: 1-param constructor");
		this.beanId = beanId;
	}
	
	public  void entertainment() {
		System.out.println("Viechle.entertainment():: With Audio -Video Player");
	}
	
	public   void  soundHorn() {
		System.out.println("Viechle.soundHorn:: With Skoda horn");
	}
	
	public   void journey(String source ,String dest) {
		ApplicationContext ctx=null;
		Engine engg=null;
		//create Additional IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Engine class object (Dependent class object) through Dependency lookup
		engg=ctx.getBean(beanId,Engine.class);
		engg.start();
		System.out.println("Viechle.journey() :: Journery STarted from"+source+" to "+dest);
		engg.stop();
		System.out.println("Viechle.journey() :: Journery End from"+source+" to "+dest);
	}

}
