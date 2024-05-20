package com.parth.StudentManagementMyBatisJwt.services;

import com.parth.StudentManagementMyBatisJwt.dto.AcknowledgmentDTO;
import com.parth.StudentManagementMyBatisJwt.dto.StudentAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.StudentDisplayDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
public class KafkaStudentService {

  @Autowired
  StudentService studentService;
  
  @Value("${topic.ack}")
  String ackTopic;

  @Autowired
  KafkaTemplate <String, AcknowledgmentDTO> acknowledgmentKafkaTemplate;

  @KafkaListener(topics = "student-info1", groupId = "group1", containerFactory = "kafkaListenerContainerFactory")
  public StudentDisplayDto addStudents(@Valid StudentAdditionDto studentAdditionDto){
    System.out.println(studentAdditionDto);
    StudentDisplayDto studentDisplayDto = null;
    try {
      studentDisplayDto = studentService.addStudent(studentAdditionDto);
      sendAcknowledgment(studentDisplayDto.getName(), "SUCCESS");
    }catch (Exception exception){
      sendAcknowledgment(studentAdditionDto.getName(), "FAILURE: "+exception.getCause());
    }
    return studentDisplayDto;
  }

  private void sendAcknowledgment(String name, String message){
    AcknowledgmentDTO acknowledgmentDTO = new AcknowledgmentDTO(name, message);
    CompletableFuture<SendResult<String, AcknowledgmentDTO>> send = acknowledgmentKafkaTemplate.send(ackTopic, acknowledgmentDTO);
    send.whenComplete((result, ex) -> {
      if (ex == null) {
        System.out.println("Sent data: " + acknowledgmentDTO.toString() + "\n with offset: " + result.getRecordMetadata().offset());
      }
      else System.out.println("Unable to send data due to " + ex.getMessage());
    });
  }
}
