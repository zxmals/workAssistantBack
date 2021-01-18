package com.xz.cmcc.config.dao;

import java.beans.PropertyVetoException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration

//配置mybatis mapper的扫描路径
@MapperScan("com.xz.cmcc.dao")
public class DatasSourceConfiguration {

	@Value("${jdbc.driver}")
	private String jdbcDriver;
	@Value("${jdbc.url}")
	private String jdbcUrl;
	@Value("${jdbc.username}")
	private String jabcUsername;
	@Value("${jdbc.pwd}")
	private String jdbcPassword;

	@Bean(name = "dataSource")
	public ComboPooledDataSource createDataSource() throws PropertyVetoException {
		ComboPooledDataSource datasource = new ComboPooledDataSource();
		datasource.setDriverClass(jdbcDriver);
		datasource.setJdbcUrl(jdbcUrl);
		datasource.setUser(jabcUsername);
		datasource.setPassword(jdbcPassword);
		//关闭连接后，不自动commit
		datasource.setAutoCommitOnClose(false);
		return datasource;
	}
	
}
