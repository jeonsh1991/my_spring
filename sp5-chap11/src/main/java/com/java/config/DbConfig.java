package com.java.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/spring?characterEncoding=utf8");
		ds.setUsername("root");
		ds.setPassword("tmdgml65");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		return ds;
	}

}
