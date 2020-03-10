package com.nt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
@EnableConfigurationProperties
@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {
	
	@Bean(name="oraXAds")
	@ConfigurationProperties(prefix = "jta.atomikos.datasource.first")
	public  AtomikosDataSourceBean createXADsForOracle() {
		AtomikosDataSourceBean xaOraDs=new AtomikosDataSourceBean();
		return xaOraDs;
	}
	
	@Bean(name="MysqlXAds")
	@ConfigurationProperties(prefix = "jta.atomikos.datasource.second")
	public  AtomikosDataSourceBean createXADsForMySql() {
		AtomikosDataSourceBean xaMysqlDs=new AtomikosDataSourceBean();
		return xaMysqlDs;
	}
	
	@Bean(name="oraTemplate")
	public JdbcTemplate  createJdbcTemplateForOracle() {
       return new  JdbcTemplate(createXADsForOracle());		
	}
	
	@Bean(name="mysqlTemplate")
	public JdbcTemplate  createJdbcTemplateForMySql() {
       return new  JdbcTemplate(createXADsForMySql());		
	}


}
