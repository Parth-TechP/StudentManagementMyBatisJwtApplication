package com.parth.StudentManagementMyBatisJwt.mapstructMapper;


import com.parth.StudentManagementMyBatisJwt.dto.SubjectAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.SubjectDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.SubjectTeacherDisplayDto;
import com.parth.StudentManagementMyBatisJwt.model.SubjectEntity;
import com.parth.StudentManagementMyBatisJwt.model.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring", uses = TeacherMapper.class)
public interface SubjectMapper {

  @Mapping(source = "name", target = "name")
  @Mapping(source = "credits", target = "credits")
  @Mapping(target = "teacher", expression = "java(getTeacherEntity(subjectAdditionDto))")
  SubjectEntity convertSubjectAdditionDtoToSubjectEntity(SubjectAdditionDto subjectAdditionDto);


  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "credits", target = "credits")
  @Mapping(source = "teacher.id", target = "teacher")
  SubjectDisplayDto convertSubjectEntityToSubjectDisplayDto(SubjectEntity subjectEntity);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "credits", target = "credits")
  @Mapping(source = "teacher", target = "teacher")
  SubjectTeacherDisplayDto convertSubjectEntityToSubjectTeacherDisplayDto(SubjectEntity subjectEntity);


  default TeacherEntity getTeacherEntity(SubjectAdditionDto subjectAdditionDto) {
    TeacherEntity teacherEntity = new TeacherEntity();
    teacherEntity.setId(subjectAdditionDto.getTeacherId());
    return teacherEntity;
  }

  List<SubjectDisplayDto> convertListOfSubjectEntityToSubjectDisplayDto(List<SubjectEntity> subjectEntity);
}
