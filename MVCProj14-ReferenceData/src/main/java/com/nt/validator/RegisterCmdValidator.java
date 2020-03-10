package com.nt.validator;

import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.validation.Validator;

import org.springframework.validation.Errors;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import com.nt.command.RegisterCommand;

public class RegisterCmdValidator implements org.springframework.validation.Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(RegisterCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegisterCommand cmd=null;
        //type casting
		cmd=(RegisterCommand)target;
		if(cmd.getName().length()==0 || cmd.getName().equalsIgnoreCase(""))
			errors.rejectValue("name","name.required");
		if(cmd.getAge()<=0)
			errors.rejectValue("age","age.positive");
	}


}
