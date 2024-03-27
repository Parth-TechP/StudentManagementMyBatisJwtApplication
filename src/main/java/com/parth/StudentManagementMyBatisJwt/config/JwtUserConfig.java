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

@MapperScan(value = "com.parth.StudentManagementMyBatisJwt", annotationClass = JwtUserConnMapper.class , sqlSessionFactoryRef = "JwtUserSessionFactory")

@Configuration
public class JwtUserConfig {

    @Bean(name = "dataSource3")
    @ConfigurationProperties(prefix = "spring.datasource.jwt")
    public DataSource JwtUserDataSource(){
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5432/jwt1")
                .username("postgres")
                .password("postgres").build();
    }

    @Bean(name = "JwtUserSessionFactory")
    public SqlSessionFactory sqlSessionFactory3(@Qualifier("dataSource3")final DataSource dataSource3)throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource3);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:jwt-user/mapper/*.xml"));
        return factoryBean.getObject();
    }

    @Bean(name = "sqlSessionTemplate3")
    public SqlSessionTemplate sqlSessionTemplate3(@Qualifier("JwtUserSessionFactory") final SqlSessionFactory sqlSessionFactory3) {
        return new SqlSessionTemplate(sqlSessionFactory3);
    }

    @Bean
    @ConfigurationProperties("spring.datasource.jwt")
    public DataSourceProperties thirdDataSourceProperties() {
        return new DataSourceProperties();
    }
}
