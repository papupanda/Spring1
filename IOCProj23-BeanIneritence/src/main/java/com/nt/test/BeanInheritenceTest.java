package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.Bike;


public class BeanInheritenceTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		Bike bike1=null,bike2=null;
		//create IOc container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Target class object
		bike1=factory.getBean("pulsor1",Bike.class);
		System.out.println(bike1);
		System.out.println("--------------------------------");
		bike2=factory.getBean("pulsor2",Bike.class);
		System.out.println(bike2);
		/*System.out.println("------------------------");
		bike2=factory.getBean("basePulsor",Bike.class);
		System.out.println(bike2); */
		
		
		
		

	}

}
