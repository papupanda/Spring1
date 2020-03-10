package com.nt.command;

import lombok.Data;

@Data
public class RegisterCommand {
	private String name;
	private int age;
	private String gender="female";
	private String[] hobies=new String[] {"dancing","roaming"};
	private String[] colors=new String[] {"red","green"};
	private String country="select country";

}
