package com.nt.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.nt.entity.EmployeeHLO;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {
	
	@Bean(name="ds")
	public  DataSource createDs() {
		HikariDataSource hkDs=new HikariDataSource();
		hkDs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hkDs.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hkDs.setUsername("system");
		hkDs.setPassword("manager");
		return hkDs;
		
	}
	
	@Bean(name="sesfact")
	public  LocalSessionFactoryBean createLocalSesFact() {
		LocalSessionFactoryBean sesfact=null;
		Properties props=null;
		sesfact=new LocalSessionFactoryBean();
		sesfact.setDataSource(createDs());
		sesfact.setAnnotatedClasses(EmployeeHLO.class);
		props=new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		props.put("hibernate.show_sql","true");
		sesfact.setHibernateProperties(props);
		return sesfact;
	}
	
	@Bean(name="template")
	public HibernateTemplate createHT() {
		return new HibernateTemplate(createLocalSesFact().getObject());
		
	}
	
	

}
