package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.CricketBat;
import com.nt.beans.ProffessionalCricketer;

public class InnerBeanTest {

	public static void main(String[] args) {
	   DefaultListableBeanFactory factory=null;
	   XmlBeanDefinitionReader reader=null;
	   ProffessionalCricketer pfCk=null,pfCk1=null;
	   CricketBat bat=null;
	   //create IOC container
	   factory=new DefaultListableBeanFactory();
	   reader=new XmlBeanDefinitionReader(factory);
	   reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
	   //get Taget Bean class obj
	   pfCk=factory.getBean("com.nt.beans.ProffessionalCricketer#0",ProffessionalCricketer.class);
	   System.out.println(pfCk);
	System.out.println("...........................................");
	pfCk1=factory.getBean("com.nt.beans.ProffessionalCricketer#1",ProffessionalCricketer.class);
	   System.out.println(pfCk1);
	   
	}
}
