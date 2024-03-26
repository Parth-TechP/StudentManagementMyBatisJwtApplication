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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@MapperScan(value = "com.parth.StudentManagementMyBatisJwt", annotationClass = MyBatisDBConnMapper.class , sqlSessionFactoryRef = "MyBatisDBSessionFactory")

@Configuration
public class MyBatisDataSourceConfig {
    @Bean(name = "dataSource1")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource myBatisDataSource(){
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5432/MyBatisDemo")
                .username("postgres")
                .password("postgres").build();
    }

    @Bean(name = "MyBatisDBSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory1(@Qualifier("dataSource1")final DataSource dataSource1)throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource1);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis.mapper/*.xml"));
        return factoryBean.getObject();
    }
    @Primary
    @Bean(name = "sqlSessionTemplate1")
    public SqlSessionTemplate sqlSessionTemplate1(@Qualifier("MyBatisDBSessionFactory") final SqlSessionFactory sqlSessionFactory1) {
        return new SqlSessionTemplate(sqlSessionFactory1);
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }
}
