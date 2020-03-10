package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankServiceMgmt;

@SpringBootApplication
@Import(AppConfig.class)
public class LocalTxMgmtTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankServiceMgmt proxy=null;
		//get IOC container
          ctx=SpringApplication.run(LocalTxMgmtTest.class, args);	
		//get Proxy  obj  having TxService
		proxy=ctx.getBean("bankService",BankServiceMgmt.class);
		try {
		//invoke methods
		System.out.println(proxy.transferMoney(1008,1001,2000));
		}
		catch(IllegalArgumentException iae) {
			iae.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
