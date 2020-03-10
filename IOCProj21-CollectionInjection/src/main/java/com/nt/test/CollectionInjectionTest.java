package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.FacultyProfile;
import com.nt.beans.FruitStore;
import com.nt.beans.Student;
import com.nt.beans.University;
import com.nt.beans.UserInfo;

public class CollectionInjectionTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		Student st=null;
		University university=null;
		UserInfo info=null;
		FacultyProfile profile=null;
		FruitStore store=null;
		//create IOC container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Bean class obj
		st=factory.getBean("st",Student.class);
		System.out.println(st);
		System.out.println("=========================");
		university=factory.getBean("univrsty",University.class);
		System.out.println(university);
		System.out.println("===========================");
		info=factory.getBean("userInfo",UserInfo.class);
		System.out.println(info);
		System.out.println("=============================");
		profile=factory.getBean("fp",FacultyProfile.class);
		System.out.println(profile);
		store=factory.getBean("fstore",FruitStore.class);
		System.out.println(store);
		
	}

}
