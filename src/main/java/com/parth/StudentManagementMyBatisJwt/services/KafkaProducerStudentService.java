package com.parth.StudentManagementMyBatisJwt.services;

import com.parth.StudentManagementMyBatisJwt.dto.kafka.AcknowledgmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerStudentService {

  @Value("${topic.ack}")
  String ackTopic;

  @Autowired
  KafkaTemplate<String, AcknowledgmentDTO> acknowledgmentKafkaTemplate;

  public void sendAcknowledgment(Long logId, Long statusCode, String statusMessage){
    AcknowledgmentDTO acknowledgmentDTO = new AcknowledgmentDTO(logId, statusCode, statusMessage);
    CompletableFuture<SendResult<String, AcknowledgmentDTO>> send = acknowledgmentKafkaTemplate.send(ackTopic, acknowledgmentDTO);
    send.whenComplete((result, ex) -> {
      if (ex == null) {
        System.out.println("Sent data: " + acknowledgmentDTO.toString() + "\n with offset: " + result.getRecordMetadata().offset());
      }
      else System.out.println("Unable to send data due to " + ex.getMessage());
    });
  }
}
