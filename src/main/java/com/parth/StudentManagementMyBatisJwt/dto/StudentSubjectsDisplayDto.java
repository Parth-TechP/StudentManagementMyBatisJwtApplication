package com.parth.StudentManagementMyBatisJwt.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentSubjectsDisplayDto {
  private Long id;
  private String name;
  private int age;
  private String email;
  private String city;
  private List<SubjectDisplayDto> subjects;
}
