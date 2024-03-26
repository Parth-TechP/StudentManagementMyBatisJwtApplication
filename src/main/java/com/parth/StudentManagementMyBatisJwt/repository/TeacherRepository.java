package com.parth.StudentManagementMyBatisJwt.repository;

import com.parth.StudentManagementMyBatisJwt.config.MyBatisDBConnMapper;
import com.parth.StudentManagementMyBatisJwt.model.TeacherEntity;

import java.util.List;
@MyBatisDBConnMapper
public interface TeacherRepository {
    List<TeacherEntity> findAllTeachers();
    TeacherEntity findTeacherById(Long id);
    TeacherEntity findSubjectsByTeacherId(Long id);

    boolean addTeacher(TeacherEntity teacher);
}
