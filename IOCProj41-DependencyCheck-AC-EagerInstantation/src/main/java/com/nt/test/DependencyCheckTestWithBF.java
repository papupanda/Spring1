package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.India;

public class DependencyCheckTestWithBF {

	public static void main(String[] args) {
		BeanFactory factory=null;
		India india=null;
		//create IOC container
		factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		//get Target Bean
		/*india=factory.getBean("india",India.class);
		System.out.println(india); */
		
		//close container
		//((AbstractApplicationContext) ctx).close();
		
		

	}

}
