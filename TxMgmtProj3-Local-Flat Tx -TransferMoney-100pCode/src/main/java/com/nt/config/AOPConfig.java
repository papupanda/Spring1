package com.nt.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;

import com.nt.service.BankServiceMgmt;

@Configuration
public class AOPConfig {

	@Autowired
	private DataSource ds;
	@Autowired
	private  BankServiceMgmt service;
	
	@Bean(name="dsTxMgmr")
	public   DataSourceTransactionManager  createDsTxMgmr() {
		DataSourceTransactionManager dsTxMgmr=null;
		dsTxMgmr=new DataSourceTransactionManager();
		dsTxMgmr.setDataSource(ds);
		return dsTxMgmr;
	}
	
	@Bean(name="tpfb")
	public   TransactionProxyFactoryBean  createTxFPB() {
		 TransactionProxyFactoryBean tfb=null;
		 Properties props=null;
		 tfb=new TransactionProxyFactoryBean();
		 tfb.setTarget(service);
		 tfb.setTransactionManager(createDsTxMgmr());
		 props=new Properties();
		 props.put("transferMoney", "PROPAGATION_REQUIRED");
		 tfb.setTransactionAttributes(props);
      return tfb;		 
	}
	
	
	
	

}
