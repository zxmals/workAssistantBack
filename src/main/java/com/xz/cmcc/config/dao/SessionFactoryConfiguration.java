package com.xz.cmcc.config.dao;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class SessionFactoryConfiguration {
	
	  @Value("${mybatis_config_file}") 
	  private String mybatisConfighFilePath;
	  
	  @Value("${entity_package}") 
	  private String entityPackage;
	  
	  @Value("${mapper_path}") 
	  private String mapperPath;
	  
	  @Autowired	  
	  @Qualifier("dataSource") 
	  private DataSource dataSource;
	  
	  @Bean("sqlSessionFactory") 
	  public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException { 
		  SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		  sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfighFilePath));
		  PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(); 
		  String packgeSerchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
		  sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packgeSerchPath)); 
		  sqlSessionFactoryBean.setDataSource(dataSource);
		  sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage); 
		  return sqlSessionFactoryBean;	  
	  }	 
}
