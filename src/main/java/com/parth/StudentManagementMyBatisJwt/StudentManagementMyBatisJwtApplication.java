package com.parth.StudentManagementMyBatisJwt;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.parth.StudentManagementMyBatisJwt.repository")
@EnableTransactionManagement
public class StudentManagementMyBatisJwtApplication {

  public static void main(String[] args) {
    SpringApplication.run(StudentManagementMyBatisJwtApplication.class, args);
  }

}
