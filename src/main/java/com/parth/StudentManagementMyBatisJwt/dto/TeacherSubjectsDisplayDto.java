package com.parth.StudentManagementMyBatisJwt.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeacherSubjectsDisplayDto {
  private Long id;
  private String name;
  private int age;
  private String email;
  private String City;
  private List<SubjectDisplayDto> subjects;
}
