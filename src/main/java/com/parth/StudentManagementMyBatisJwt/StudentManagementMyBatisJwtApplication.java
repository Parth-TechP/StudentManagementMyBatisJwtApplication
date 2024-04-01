package com.parth.StudentManagementMyBatisJwt;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.parth.StudentManagementMyBatisJwt.repository","com.parth.StudentManagementMyBatisJwt.repository.jwtUser"})
@SecurityScheme(
		name = "bearerAuth",
		scheme = "bearer",
		bearerFormat = "JWT",
		type = SecuritySchemeType.HTTP
)
public class StudentManagementMyBatisJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementMyBatisJwtApplication.class, args);
	}

}
