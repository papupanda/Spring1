package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("fpkt")
@Component
//@Scope("prototype")
public class Flipkart {
	//@Autowired(required = true)
	//@Autowired(required = false)
	//@Qualifier("bDart")
	//@Qualifier("dtdc")
	private  Courier courier;
	//@Autowired
	private Date date;
	
	public Flipkart() {
		System.out.println("Flipkart.0-param constructor");
	}
	
	/*	@Autowired(required = false)
		public  Flipkart(Courier courier) {
			System.out.println("Flipkart.Flipkart(-)");
			this.courier=courier;
		}*/
	
/*	@Autowired
	public  Flipkart(Courier courier,Date date) {
		System.out.println("Flipkart.Flipkart(-,-)");
		this.courier=courier;
		this.date=date;
	}*/

	@Override
	public String toString() {
		return "Flipkart [courier=" + courier + ", date=" + date + "]";
	}
	
	
	
	/*@Autowired
	@Qualifier("cr1")
	public  void setCourier(Courier courier) {
		System.out.println("Flipkart.setCourier(-)");
		this.courier=courier;
	}
	
	
	@Autowired
	@Qualifier("cr3")
	public    void assign(Courier courier) {
		System.out.println("Flipkart.assign()");
	  this.courier=courier;
	}*/
	
	/*	@Autowired
		public    void assign(@Qualifier("bDart")Courier courier,Date date) {
			System.out.println("Flipkart.assign()");
		  this.courier=courier;
		  this.date=date;
		}*/
	

	
	
	

}
