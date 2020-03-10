package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.CheckVotingElgibilty;

public class BeanLifeCycleTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CheckVotingElgibilty voting=null;
		//create IOC Container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		voting=ctx.getBean("voting",CheckVotingElgibilty.class);
		System.out.println(voting.checkVotingElgibility());
		System.out.println(voting);
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
