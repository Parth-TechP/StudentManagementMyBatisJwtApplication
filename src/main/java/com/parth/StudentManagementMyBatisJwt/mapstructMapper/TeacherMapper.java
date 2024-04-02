package com.parth.StudentManagementMyBatisJwt.mapstructMapper;

import com.parth.StudentManagementMyBatisJwt.dto.TeacherAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.TeacherDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.TeacherSubjectsDisplayDto;
import com.parth.StudentManagementMyBatisJwt.model.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = SubjectMapper.class)
public interface TeacherMapper {
  @Mapping(source = "name", target = "name")
  @Mapping(source = "age", target = "age")
  @Mapping(source = "email", target = "email")
  @Mapping(source = "city", target = "city")
  TeacherEntity convertTeacherAdditionDtoToTeacherEntity(TeacherAdditionDto teacherAdditionDto);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "age", target = "age")
  @Mapping(source = "email", target = "email")
  @Mapping(source = "city", target = "city")
  TeacherDisplayDto convertTeacherEntityToTeacherDisplayDto(TeacherEntity teacherEntity);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "age", target = "age")
  @Mapping(source = "email", target = "email")
  @Mapping(source = "city", target = "city")
  @Mapping(source = "subjects", target = "subjects")
  TeacherSubjectsDisplayDto convertTeacherEntityToTeacherSubjectsDisplayDto(TeacherEntity teacherEntity);

  List<TeacherDisplayDto> convertListOfTeacherEntityToTeacherDisplayDto(List<TeacherEntity> teacherEntity);
}
