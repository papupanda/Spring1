package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

@Configuration
public class AopConfig {
	
	@Bean(name="atsDTxService")
	public  UserTransactionImp createDTxService()throws Exception {
		UserTransactionImp imp=new UserTransactionImp();
		imp.setTransactionTimeout(300);
		return imp;
	}
	
	@Bean(name="atsDTxManager")
	public  UserTransactionManager createDTxManager()throws Exception {
		UserTransactionManager dtxMgmr=new UserTransactionManager();
		dtxMgmr.setForceShutdown(true);
		return dtxMgmr;
	}
	
	@Bean(name="jtaMgmr")
	public  JtaTransactionManager createJTAMgmr()throws Exception {
		JtaTransactionManager jtaMgmr=new JtaTransactionManager();
		jtaMgmr.setTransactionManager(createDTxManager());
		jtaMgmr.setUserTransaction(createDTxService());
		return jtaMgmr;
	}

}
