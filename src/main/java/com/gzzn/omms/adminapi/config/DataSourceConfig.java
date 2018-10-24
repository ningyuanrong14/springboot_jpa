package com.gzzn.omms.adminapi.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {
	 @Bean(name = "primaryDataSource") 
     @Primary 
	 @ConfigurationProperties(prefix="spring.datasource.primary")
	 public DataSource primaryDataSource() 
	 { 
	   return DataSourceBuilder.create().build(); 
	 } 


	@Bean(name = "secondaryDataSource")
	@ConfigurationProperties(prefix="spring.datasource.secondary")
	public DataSource secondaryDataSource() 
	{ 
	  return DataSourceBuilder.create().build(); 
	}
}
