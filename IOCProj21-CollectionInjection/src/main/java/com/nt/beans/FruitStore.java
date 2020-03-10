package com.nt.beans;

import java.util.Properties;

public class FruitStore {
	private  Properties   fruits;
	
	
	public FruitStore(Properties fruits) {
	  System.out.println("FruitStore:1-param constructor");
		this.fruits = fruits;
	}


	@Override
	public String toString() {
		return "FruitStore [fruits=" + fruits + "]";
	}


	

}
