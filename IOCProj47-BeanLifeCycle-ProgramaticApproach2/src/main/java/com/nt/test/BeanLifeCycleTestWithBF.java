package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.beans.CheckVotingElgiblity;

public class BeanLifeCycleTestWithBF {

	public static void main(String[] args) {
		CheckVotingElgiblity voting=null;
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		//create IOC container
		factory=new  DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Bean
		voting=factory.getBean("cve",CheckVotingElgiblity.class);
		System.out.println(voting.checkVotingElgibility());
		System.out.println(voting);
		//close container
		factory.destroySingletons();

	}

}
