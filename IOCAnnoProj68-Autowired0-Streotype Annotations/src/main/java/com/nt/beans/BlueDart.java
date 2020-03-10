package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bDart")
public class BlueDart implements Courier {
	@Value("ameerpet")
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
