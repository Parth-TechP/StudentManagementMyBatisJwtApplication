package com.parth.StudentManagementMyBatisJwt.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@MapperScan(value = "com.parth.StudentManagementMyBatisJwt", annotationClass = MessManagementConnMapper.class, sqlSessionFactoryRef =
  "MessManagementSessionFactory")

@Configuration
public class MessManagementDataSourceConfig {
  @Bean(name = "dataSource2")
  @ConfigurationProperties(prefix = "spring.datasource.management")
  public DataSource MessManagementDataSource() {
    return DataSourceBuilder.create()
      .driverClassName("org.postgresql.Driver")
      .url("jdbc:postgresql://localhost:5432/messManagement")
      .username("postgres")
      .password("postgres").build();
  }

  @Bean(name = "MessManagementSessionFactory")
  public SqlSessionFactory sqlSessionFactory2(@Qualifier("dataSource2") final DataSource dataSource2) throws Exception {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(dataSource2);
    factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mess-management.mapper/*.xml"));
    return factoryBean.getObject();
  }

  @Bean(name = "sqlSessionTemplate2")
  public SqlSessionTemplate sqlSessionTemplate2(@Qualifier("MessManagementSessionFactory") final SqlSessionFactory sqlSessionFactory2) {
    return new SqlSessionTemplate(sqlSessionFactory2);
  }

  @Bean
  @ConfigurationProperties("spring.datasource.management")
  public DataSourceProperties secondDataSourceProperties() {
    return new DataSourceProperties();
  }
}
