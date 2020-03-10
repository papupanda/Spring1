package com.nt.peditor;

import java.beans.PropertyEditorSupport;

import com.nt.beans.IntrestAmountDetails;

public class IntrestAmountDetailsEditor extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		                                                     //100000,2,12
		
		IntrestAmountDetails  details=null;
		//get values from attrubte (text)
		float pAmt=Float.parseFloat(text.substring(0,text.indexOf(",")));
		float rate=Float.parseFloat(text.substring(text.indexOf(",")+1,text.lastIndexOf(",")));
		float time=Float.parseFloat(text.substring(text.lastIndexOf(",")+1,text.length()));
		//create object and set values
		details=new IntrestAmountDetails();
		details.setPAmt(pAmt);
		details.setRate(rate);
		details.setTime(time);
		//set value /object to bean property
		setValue(details);
	}//method
}//cass
