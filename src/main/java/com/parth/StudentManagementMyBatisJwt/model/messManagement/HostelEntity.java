package com.parth.StudentManagementMyBatisJwt.model.messManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HostelEntity {
  private Long id;
  private String name;
  private Integer capacity;
  private Integer rating;
  private String location;
}
