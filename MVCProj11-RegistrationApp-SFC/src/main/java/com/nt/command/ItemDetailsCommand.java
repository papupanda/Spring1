package com.nt.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDetailsCommand {
	private String itemName;
	private String  category;
	private String  status="yes";
	private float price=100.0f;
	private  String restaurant="Kritunga";
	
	public ItemDetailsCommand() {
		System.out.println("ItemDetailsCommand:: 0-param constructor");
	}

}
