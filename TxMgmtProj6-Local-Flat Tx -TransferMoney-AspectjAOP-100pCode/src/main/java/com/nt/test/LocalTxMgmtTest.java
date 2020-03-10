package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankServiceMgmt;

public class LocalTxMgmtTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankServiceMgmt proxy=null;
		//create IOC container
          ctx=new AnnotationConfigApplicationContext(AppConfig.class);	
		//get Proxy  obj  having TxService
		proxy=ctx.getBean("bankService",BankServiceMgmt.class);
		try {
		//invoke methods
		System.out.println(proxy.transferMoney(1006,1002,2000));
		}
		catch(IllegalArgumentException iae) {
			iae.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
