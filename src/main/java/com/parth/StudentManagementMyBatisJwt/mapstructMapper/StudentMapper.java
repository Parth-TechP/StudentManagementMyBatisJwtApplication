package com.parth.StudentManagementMyBatisJwt.mapstructMapper;

import com.parth.StudentManagementMyBatisJwt.dto.StudentAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.StudentDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.StudentSubjectsDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.kafka.StudentAdditionReceiveDto;
import com.parth.StudentManagementMyBatisJwt.model.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = SubjectMapper.class)
public interface StudentMapper {

  @Mapping(source = "name", target = "name")
  @Mapping(source = "age", target = "age")
  @Mapping(source = "email", target = "email")
  @Mapping(source = "city", target = "city")
  StudentEntity convertStudentAdditionDtoToStudentEntity(StudentAdditionDto studentAdditionDto);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "age", target = "age")
  @Mapping(source = "email", target = "email")
  @Mapping(source = "city", target = "city")
  StudentDisplayDto convertStudentEntityToStudentDisplayDto(StudentEntity studentEntity);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "age", target = "age")
  @Mapping(source = "email", target = "email")
  @Mapping(source = "city", target = "city")
  @Mapping(source = "subjects", target = "subjects")
  StudentSubjectsDisplayDto convertStudentEntityToStudentSubjectsDisplayDto(StudentEntity studentEntity);

  List<StudentDisplayDto> convertListOfStudentEntityToStudentDisplayDto(List<StudentEntity> studentEntity);

  StudentAdditionDto convertStudentAdditionReceiveDtoToStudentAdditionDto(StudentAdditionReceiveDto studentAdditionReceiveDto);
}
