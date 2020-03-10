package com.nt.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
/*@PropertySources(value= {@PropertySource(value="classpath:com/nt/commons/jdbc1.properties"),
		                                          @PropertySource(value="classpath:com/nt/commons/jdbc2.properties")
		                                        }
                                   )*/
@PropertySource(value="classpath:com/nt/commons/jdbc1.properties")
@PropertySource(value="classpath:com/nt/commons/jdbc2.properties")
public class PersistenceConfig {
	@Autowired
	private Environment env;
	@Bean(name="apacheDs")
	public   DataSource createDS() {
		BasicDataSource bds=null;
		bds=new BasicDataSource();
		bds.setDriverClassName(env.getProperty("jdbc.driver"));
		bds.setUrl(env.getProperty("jdbc.url"));
		bds.setUsername(env.getProperty("jdbc.user"));
		bds.setPassword(env.getProperty("jdbc.pwd"));
		System.out.println(env.getProperty("os.name")+"<---->"+env.getProperty("PATH"));
		return bds;
		
	}
	

}
