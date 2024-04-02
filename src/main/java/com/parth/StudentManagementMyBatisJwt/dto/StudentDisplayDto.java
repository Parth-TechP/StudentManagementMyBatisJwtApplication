package com.parth.StudentManagementMyBatisJwt.dto;

import lombok.Data;

@Data
public class StudentDisplayDto {
  private Long id;
  private String name;
  private int age;
  private String email;
  private String city;
}
