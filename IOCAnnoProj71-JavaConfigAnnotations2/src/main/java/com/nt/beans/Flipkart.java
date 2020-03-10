package com.nt.beans;

import java.util.Date;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.lang.Nullable;

import jdk.nashorn.internal.ir.annotations.Ignore;

//@Component("fpkt")
@Named("fpkt")
public class Flipkart {
	//@Resource(name="bDart")
	private Courier courier;
	//@Resource	
	private Date date;
	
	/*public Flipkart() {
		System.out.println("Flipkart.0-param constructor");
	}*/
	
	/*@Resource  (Not allowed here)
	public Flipkart(@Named("bDart")Courier courier,Date date) {
		System.out.println("Flipkart.2-param constructor");
		this.courier=courier;
		this.date=date;
	}*/
	
	/*@Resource(name="bDart")
	public void setCourier(Courier courier) {
		this.courier=courier;
	}
	
	@Resource
	public  void  setDate(Date date) {
		this.date=date;
	}*/
	
	
	@Resource
	public void assignCourier(@Named("bDart") Courier courier) {
		this.courier=courier;
	}
	
	@Resource
	public  void  assignDate(@Nullable Date date) {
		this.date=date;
	}
	
	
	/*@Resource
	public  void setCourier(@Named("bDart")Courier courier, Date date) {
		this.courier=courier;
		this.date=date;
	}
	
	*/
	@Override
	public String toString() {
		return "Flipkart [courier=" + courier + ", date=" + date + "]";
	}

	
	
	
	

}
