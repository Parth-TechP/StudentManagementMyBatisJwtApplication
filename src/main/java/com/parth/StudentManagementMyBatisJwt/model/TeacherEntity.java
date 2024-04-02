package com.parth.StudentManagementMyBatisJwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherEntity {

  private Long id;
  private String name;
  private int age;
  private String email;
  private String city;
  private List<SubjectEntity> subjects;
}
