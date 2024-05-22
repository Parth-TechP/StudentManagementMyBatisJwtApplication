package com.parth.StudentManagementMyBatisJwt.services;

import com.parth.StudentManagementMyBatisJwt.dto.StudentAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.StudentDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.kafka.StudentAdditionReceiveDto;
import com.parth.StudentManagementMyBatisJwt.exceptions.DuplicateDataException;
import com.parth.StudentManagementMyBatisJwt.exceptions.ResourceNotFoundException;
import com.parth.StudentManagementMyBatisJwt.mapstructMapper.StudentMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumerStudentService {

  @Autowired
  StudentService studentService;

  @Autowired
  StudentMapper studentMapper;

  @Autowired
  KafkaProducerStudentService kafkaProducerStudentService;

  @KafkaListener(topics = "student-info1", groupId = "group1", containerFactory = "kafkaListenerContainerFactory")
  public void addStudents(StudentAdditionReceiveDto studentAdditionReceiveDto){

    try {
      studentService.addStudent(studentMapper.convertStudentAdditionReceiveDtoToStudentAdditionDto(studentAdditionReceiveDto));
      kafkaProducerStudentService.sendAcknowledgment(studentAdditionReceiveDto.getLogId(), (long) HttpStatus.OK.value(),  HttpStatus.OK.getReasonPhrase());
    } catch (Exception exception){
      kafkaProducerStudentService.sendAcknowledgment(studentAdditionReceiveDto.getLogId(), (long) HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }
  }


}
