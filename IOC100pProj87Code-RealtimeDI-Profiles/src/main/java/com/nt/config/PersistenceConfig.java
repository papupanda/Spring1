package com.nt.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
@PropertySource(value="classpath:com/nt/commons/jdbc.properties")
public class PersistenceConfig {
	@Autowired
	private  Environment env;
	
	@Bean
	@Profile({"dev","test"})
	public   DataSource  createApacheDs() {
		System.out.println("PersistenceConfig.createApacheDs()");
		BasicDataSource bds=null;
		bds=new BasicDataSource();
		bds.setDriverClassName(env.getProperty("mysql.jdbc.driver"));
		bds.setUrl(env.getRequiredProperty("mysql.jdbc.url"));
		bds.setUsername(env.getRequiredProperty("mysql.jdbc.username"));
		bds.setPassword(env.getRequiredProperty("mysql.jdbc.password"));
		return bds;
	}
	
	@Bean
	@Profile("uat")
	public   DataSource  createC3P0Ds()throws Exception {
		System.out.println("PersistenceConfig.createC3P0Ds()");
		ComboPooledDataSource cpds=null;
		cpds=new ComboPooledDataSource();
		cpds.setDriverClass(env.getProperty("oracle.jdbc.driver"));
		cpds.setJdbcUrl(env.getRequiredProperty("oracle.jdbc.url"));
		cpds.setUser(env.getRequiredProperty("oracle.jdbc.username"));
		cpds.setPassword(env.getRequiredProperty("oracle.jdbc.password"));
		return cpds;
	}
	
	@Bean
	@Profile("prod")
	public   DataSource  createHKDs()throws Exception {
		System.out.println("PersistenceConfig.createHKDs()");
		HikariDataSource hkds=null;
		hkds=new HikariDataSource();
		hkds.setDriverClassName(env.getProperty("oracle.jdbc.driver"));
		hkds.setJdbcUrl(env.getRequiredProperty("oracle.jdbc.url"));
		hkds.setUsername(env.getRequiredProperty("oracle.jdbc.username"));
		hkds.setPassword(env.getRequiredProperty("oracle.jdbc.password"));
		return hkds;
	}


}
