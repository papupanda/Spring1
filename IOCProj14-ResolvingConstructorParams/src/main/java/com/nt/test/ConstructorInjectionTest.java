package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.Marks;
import com.nt.beans.Student;

public class ConstructorInjectionTest {

	public static void main(String[] args) {
		 DefaultListableBeanFactory factory=null;
		 XmlBeanDefinitionReader reader=null;
		 Student st=null;
		 Marks mk=null;
		 //create IOC container
		 factory=new DefaultListableBeanFactory();
		 reader=new XmlBeanDefinitionReader(factory);
		 reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		 //get Bean class obj
		 st=factory.getBean("st",Student.class);
		 System.out.println(st);
		 System.out.println("=======================");
		 mk=factory.getBean("mk",Marks.class);
		 System.out.println(mk);
		 
		 

	}

}
