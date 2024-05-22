package com.parth.StudentManagementMyBatisJwt.dto.kafka;

import lombok.Data;

@Data
public class AcknowledgmentDTO {
  private Long logId;
  private Long statusCode;
  private String statusMessage;

  public AcknowledgmentDTO(Long logId, Long statusCode, String statusMessage) {
    this.logId = logId;
    this.statusCode = statusCode;
    this.statusMessage = statusMessage;
  }
}
