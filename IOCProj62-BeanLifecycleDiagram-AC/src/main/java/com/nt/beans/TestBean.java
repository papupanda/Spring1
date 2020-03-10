package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class TestBean
		implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, DisposableBean, InitializingBean {
	private String name;
	private int age;
	
	public void setAge(int age) {
		System.out.println("TestBean.setAge()");
		this.age = age;
	}

	public TestBean(String name) {
		System.out.println("TestBean::1-param constructor");
		this.name = name;
	}
	
	public  void myInit() {
		System.out.println("TestBean.myInit() (custom init method)");
	}
	
	public  void myDestroy() {
		System.out.println("TestBean.myDestroy() (custom destroy method)");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("TestBean.afterPropertiesSet()");
		
	}

	public void destroy() throws Exception {
	System.out.println("TestBean.destroy()");

	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("TestBean.setApplicationContext()");

	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("TestBean.setBeanFactory()");
	}

	public void setBeanName(String name) {
		System.out.println("TestBean.setBeanName()");
	}
	
	public String  sayHello() {
		  return "Good Morning";
	}

}
