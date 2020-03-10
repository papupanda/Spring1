package com.nt.config;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nt.service.ArithmeticService;

@Configuration
@ComponentScan(basePackages = {"com.nt.service","com.nt.advice"})
public class AppConfig {
	@Autowired
	private  ArithmeticService service;
	
	@Bean(name="pfb")
	public ProxyFactoryBean   createPfb() {
		ProxyFactoryBean  pfb=new  ProxyFactoryBean();
		//set target
		pfb.setTarget(service);
		pfb.setInterceptorNames("pmAdvice");
		return pfb;
	}

}
