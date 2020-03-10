package com.nt.config;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.nt.beans")
public class AppConfig {
	public AppConfig() {
		System.out.println("AppConfig.0-param constructor");
	}
	
	@Bean
	//@Scope("prototype")
	public   Date  createDate() {
		System.out.println("AppConfig.createDate()");
		return  new Date();
	}
	
	@Bean
	//@Scope("prototype")
	@Primary
	@Lazy
	public   Date  createDate1() {
		System.out.println("AppConfig.createDate1()");
		return  new Date();
	}
}
