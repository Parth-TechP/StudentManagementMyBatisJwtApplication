package com.parth.StudentManagementMyBatisJwt.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AcknowledgmentDTO {
  String studentName;
  String message;

  public AcknowledgmentDTO(String name, String message) {
    this.studentName = name;
    this.message = message;
  }
}
