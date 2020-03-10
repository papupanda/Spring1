package com.nt.beans;

import org.springframework.beans.factory.annotation.Required;

public class Viechle {
	private int vid;
	private String model;
	private Engine engine;
	
	public Viechle() {
		System.out.println("Viechle::0-param constructor");
	}

	@Required
	public void setVid(int vid) {
		System.out.println("Viechle.setVid()");
		this.vid = vid;
	}

	public void setModel(String model) {
		System.out.println("Viechle.setModel()");
		this.model = model;
	}

	@Required
	public void setEngine(Engine engine) {
		System.out.println("Viechle.setEngine()");
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Viechle [vid=" + vid + ", model=" + model + ", engine=" + engine + "]";
	}
	
	

}
