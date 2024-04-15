package com.parth.StudentManagementMyBatisJwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectEntity {

  private Long id;
  private String name;
  private int credits;
  private TeacherEntity teacher;
}
