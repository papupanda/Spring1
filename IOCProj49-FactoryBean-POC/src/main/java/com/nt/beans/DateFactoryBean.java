package com.nt.beans;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.FactoryBean;

public class DateFactoryBean implements FactoryBean<Calendar> {
	private int year,month,date;

	
	public DateFactoryBean(int year, int month, int date) {
		System.out.println("DateFactoryBean::3-param constructor");
		this.year = year;
		this.month = month;
		this.date = date;
	}

	public Calendar getObject() throws Exception {
		Calendar cal=null;
	  System.out.println("DateFactoryBean.getObject()");
	  cal=Calendar.getInstance();
	  cal.set(year, month, date);
		return  cal; 
	}

	public Class<?> getObjectType() {
		System.out.println("DateFactoryBean.getObjectType()");
		return Calendar.class;
	}
	
	public boolean isSingleton() {
		System.out.println("DateFactoryBean.isSingleton()");
	   return true;
	}

}
