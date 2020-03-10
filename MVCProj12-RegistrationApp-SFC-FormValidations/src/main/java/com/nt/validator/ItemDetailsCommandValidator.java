package com.nt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.ItemDetailsCommand;

public class ItemDetailsCommandValidator implements Validator {
	
	public ItemDetailsCommandValidator() {
		System.out.println("ItemDetailsCommandValidator:: 0-param constructor");
	}

	@Override
	public boolean supports(Class<?> clazz) {
		
		//return clazz==ItemDetailsCommand.class;
		return clazz.isAssignableFrom(ItemDetailsCommand.class);
	}

	@Override
	public void validate(Object command, Errors errors) {
		System.out.println("ItemDetailsCommandValidator.validate()");
		ItemDetailsCommand cmd=null;
		//type csting
		cmd=(ItemDetailsCommand)command;
	  //enable server side form valiations only when client  side form validations are not done
  if(!cmd.isVflag()) {
	    System.out.println("ItemDetailsCommandValidator.validate()(server side form validations)");
		//form validation logic server side
		if(cmd.getItemName()==null ||cmd.getItemName().length()==0 || cmd.getItemName().equals("")) 
			errors.rejectValue("itemName","idCmd.name.required");
		
		if(cmd.getCategory()==null || cmd.getCategory().length()==0 || cmd.getCategory().equals("")) 
			errors.rejectValue("category","idCmd.category.required");

		if(cmd.getPrice()==null || cmd.getPrice()<=0.0f)  
			errors.rejectValue("price","idCmd.price.sign");
			
		if(cmd.getStatus()==null || cmd.getStatus().length()==0 || cmd.getStatus().equals("")) 
			errors.rejectValue("status","idCmd.status.required");
		
		if(cmd.getRestaurant()==null || cmd.getRestaurant().length()==0 || cmd.getRestaurant().equals("")) 
			errors.rejectValue("restaurant","idCmd.restaurant.required");

		else if(cmd.getRestaurant().length()<5)
			errors.rejectValue("restaurant","idCmd.restaurant.length");
			
       }//if
		
	}

}
