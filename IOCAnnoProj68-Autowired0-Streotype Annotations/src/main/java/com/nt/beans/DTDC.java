package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("dtdc")
//@Primary
@Scope("prototype")
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
