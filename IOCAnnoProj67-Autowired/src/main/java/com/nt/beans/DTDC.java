package com.nt.beans;

public class DTDC implements Courier {
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
