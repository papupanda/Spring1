package com.nt.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
@PropertySource(value="classpath:com/nt/commons/jdbc.properties")
public class PersistenceConfig {
	@Autowired
	private  Environment  env;
	
	@Bean(name="apacheDs")
	public   DataSource  createDataSource() {
		BasicDataSource  ds=null;
		ds=new BasicDataSource();
		ds.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
		ds.setUrl(env.getRequiredProperty("jdbc.url"));
		ds.setUsername(env.getRequiredProperty("jdbc.username"));
		ds.setPassword(env.getRequiredProperty("jdbc.pwd"));
		return ds;
	}
	
	@Bean(name="jt")
	public   JdbcTemplate  createJT() {
		return   new JdbcTemplate(createDataSource());
	}
	
	
	

}
