package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.FactoryBean;

public class DateFactoryBean implements FactoryBean<Date> {
	private int year,month,date;

	
	public DateFactoryBean(int year, int month, int date) {
		System.out.println("DateFactoryBean::3-param constructor");
		this.year = year;
		this.month = month;
		this.date = date;
	}

	public Date getObject() throws Exception {
	  System.out.println("DateFactoryBean.getObject()");
		return new Date(year-1900,month,date);
	}

	public Class<?> getObjectType() {
		System.out.println("DateFactoryBean.getObjectType()");
		return Date.class;
	}
	
	public boolean isSingleton() {
		System.out.println("DateFactoryBean.isSingleton()");
	   return false;
	}

}
