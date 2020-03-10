package com.nt.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.nt.repository")
@EntityScan(basePackages = "com.nt.entity")
public class PersistenceConfig {

}
