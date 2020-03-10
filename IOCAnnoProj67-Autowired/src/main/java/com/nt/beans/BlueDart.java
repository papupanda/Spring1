package com.nt.beans;

public class BlueDart implements Courier {
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
