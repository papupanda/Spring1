package com.nt.test;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Viechle;

public class RequiredAnnotationTestWithBF {

	public static void main(String[] args) {
		DefaultListableBeanFactory  factory=null;
		XmlBeanDefinitionReader reader=null;
		Viechle viechle=null;
		BeanPostProcessor bpp=null;
		 //create IOC container 
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get BeanPostProcessor
		bpp=factory.getBean("rabpp",BeanPostProcessor.class);
		factory.addBeanPostProcessor(bpp);
		//get Bean
		viechle=factory.getBean("viechle",Viechle.class);
		System.out.println(viechle);
		
		



	}//main
}//class
