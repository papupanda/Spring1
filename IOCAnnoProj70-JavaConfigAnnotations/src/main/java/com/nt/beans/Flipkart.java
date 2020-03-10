package com.nt.beans;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.lang.Nullable;

import jdk.nashorn.internal.ir.annotations.Ignore;

//@Component("fpkt")
@Named("fpkt")
public class Flipkart {
	//@Inject
	//@Qualifier("bDart")
	//@Named("bDart")
	private Courier courier;
	//@Inject	
	private Date date;
	
	public Flipkart() {
		System.out.println("Flipkart.0-param constructor");
	}
	
	/*@Inject
	public Flipkart(@Named("bDart")Courier courier,Date date) {
		System.out.println("Flipkart.2-param constructor");
		this.courier=courier;
		this.date=date;
	}*/
	
	/*@Inject
	public void setCourier(@Named("bDart") Courier courier) {
		this.courier=courier;
	}
	
	@Inject
	public  void  setDate(Date date) {
		this.date=date;
	}
	*/
	
	/*@Inject
	public void assignCourier(@Named("bDart") Courier courier) {
		this.courier=courier;
	}
	
	@Inject
	public  void  assignDate(Date date) {
		this.date=date;
	}
	*/
	
	@Inject
	
	public  void setCourier(@Named("bDart") Courier courier,@Nullable Date date) {
		this.courier=courier;
		this.date=date;
	}
	

	@Override
	public String toString() {
		return "Flipkart [courier=" + courier + ", date=" + date + "]";
	}

	
	
	
	

}
