package com.java.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.java.spring.MemberDao;

@Configuration
public class AppCtx {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/spring_pp?serverTimezone=UTC&characterEncoding=utf8");
		ds.setUsername("root");
		ds.setPassword("tmdgml65");
		return ds;
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}
	
}
