package com.parth.StudentManagementMyBatisJwt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.parth.StudentManagementMyBatisJwt.repository","com.parth.StudentManagementMyBatisJwt.repository.jwtUser"})
public class StudentManagementMyBatisJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementMyBatisJwtApplication.class, args);
	}

}
