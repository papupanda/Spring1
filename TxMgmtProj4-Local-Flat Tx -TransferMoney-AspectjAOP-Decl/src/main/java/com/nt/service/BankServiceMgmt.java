package com.nt.service;

public interface BankServiceMgmt {
	
	public  String transferMoney(int srcAcno,int destAcno,float amt)throws IllegalArgumentException;

}
