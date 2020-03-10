package com.nt.beans;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

//@Component("dtdc")
@Named("dtdc")
public class DTDC implements Courier {
	@Value("hyd")
	private  String branch;
	
	public DTDC() {
		System.out.println("DTDC:0-param constructor");
	}

	
	public void setBranch(String branch) {
		System.out.println("DTDC.setBranch(-)");
		this.branch = branch;
	}


	@Override
	public String toString() {
		return "DTDC [branch=" + branch + "]";
	}
	
	


}
