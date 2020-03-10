package com.nt.locator;

import org.springframework.beans.factory.FactoryBean;

import com.nt.external.ICCScoreComp;
import com.nt.external.ICCScoreCompImpl;

public class ICCScoreCompServiceLocator {

	
	public   static  ICCScoreComp getExtComp() {
	 System.out.println("ICCScoreCompServiceLocator.getExtComp()");
		ICCScoreComp  extComp=null;
		//actually we should write jndi lookup code  to get Extenal Comp ref from jndi registry
		//right row we creating that obj directly.. here..
		extComp=new ICCScoreCompImpl();
		return extComp;
	}

	
}
