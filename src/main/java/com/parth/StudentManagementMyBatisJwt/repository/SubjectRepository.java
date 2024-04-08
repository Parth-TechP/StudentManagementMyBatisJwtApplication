package com.parth.StudentManagementMyBatisJwt.repository;

import com.parth.StudentManagementMyBatisJwt.config.MyBatisDBConnMapper;
import com.parth.StudentManagementMyBatisJwt.model.SubjectEntity;
import jakarta.validation.constraints.NotBlank;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisDBConnMapper
public interface SubjectRepository {
  List<SubjectEntity> findAllSubjects();

  SubjectEntity findSubjectById(Long id);

  SubjectEntity displaySubjectById(Long id);

  boolean addSubject(SubjectEntity subject);
    Long getSubjectIdBySubjectName(@Param("subjectName") String names);
}
