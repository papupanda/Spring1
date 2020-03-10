package com.nt.test;

import java.util.Calendar;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class FactoryMethodBeanInstantiation {
	
	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		Class c1=null;
		Calendar cal=null;
		String s=null;
		String s1=null;
		//create IOC container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get  Bean classes objs
		c1=factory.getBean("cz",Class.class);
		System.out.println("c1  class name :"+c1.getClass()+"  c1 obj data::"+c1.toString());
		System.out.println("...........................................");
		cal=factory.getBean("cal",Calendar.class);
		System.out.println("cal class name::"+cal.getClass()+" cal obj data::"+cal.toString());
		System.out.println("...............................................");
		s=factory.getBean("s2",String.class);
		System.out.println("s class name::"+s.getClass()+" s obj data::"+s.toString());
		System.out.println(".....................................");
		s1=factory.getBean("s3",String.class);
		System.out.println("s1 class name::"+s1.getClass()+"s1 obj data:: "+s1.toString());
		
	}

}
