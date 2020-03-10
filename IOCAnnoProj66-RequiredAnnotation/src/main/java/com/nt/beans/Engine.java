package com.nt.beans;

import org.springframework.beans.factory.annotation.Required;

public class Engine {
	
	private int engineId;
	private String engineCC;
	
	public Engine() {
		System.out.println("Engine:: 0-param constructor");
	}

	
	public void setEngineId(int engineId) {
		this.engineId = engineId;
	}

	@Required
	public void setEngineCC(String engineCC) {
		this.engineCC = engineCC;
	}

	@Override
	public String toString() {
		return "Engine [engineId=" + engineId + ", engineCC=" + engineCC + "]";
	}
	
	
	
	
	
	

}
