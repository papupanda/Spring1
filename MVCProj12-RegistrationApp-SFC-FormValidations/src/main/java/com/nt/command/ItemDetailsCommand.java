package com.nt.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDetailsCommand {
	private String itemName;
	private String  category;
	private String  status;
	private Float price;
	private  String restaurant;
	private boolean vflag=false;
	
	public ItemDetailsCommand() {
		System.out.println("ItemDetailsCommand:: 0-param constructor");
	}

}
