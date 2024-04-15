package com.parth.StudentManagementMyBatisJwt.dto;

import lombok.Data;

@Data
public class SubjectTeacherDisplayDto {
  private Long id;
  private String name;
  private int credits;
  private TeacherDisplayDto teacher;
}
