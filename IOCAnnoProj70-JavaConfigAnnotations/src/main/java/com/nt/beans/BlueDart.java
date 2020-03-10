package com.nt.beans;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

//@Component("bDart")
//@Named("courier")
@Named("bDart")
//@Primary
public class BlueDart implements Courier {
	@Value("mumbai")
	private  String branch;
	
	public BlueDart() {
		System.out.println("BlueDart:0-param constructor");
	}

	
	public void setBranch(String branch) {
		System.out.println("BlueDart.setBranch(-)");
		this.branch = branch;
	}


	@Override
	public String toString() {
		return "BlueDart [branch=" + branch + "]";
	}
	
	


}
