package com.nt.command;

import lombok.Data;

@Data
public class UserCommand {
	private  String user;
	private String pwd;
	private String[] hobies=new String[] {"singing"};
	private String[] domains=new String[] {"gmail"};
	private  String country="china";
	
	/*public UserCommand() {
		System.out.println("UserCommand :: 0-param constructor");
	}*/

}
