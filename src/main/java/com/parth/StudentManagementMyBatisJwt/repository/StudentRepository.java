package com.parth.StudentManagementMyBatisJwt.repository;

import com.parth.StudentManagementMyBatisJwt.config.MyBatisDBConnMapper;
import com.parth.StudentManagementMyBatisJwt.model.StudentEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@MyBatisDBConnMapper
public interface StudentRepository {
    List<StudentEntity> findAllStudents(@Param("name") String name, @Param("age") Integer age, @Param("city") String city);
    StudentEntity findStudentById(Long id);
    StudentEntity findSubjectsByStudentId(Long id);
    boolean addStudent(StudentEntity student);
    void assignSubjectsToStudent(@Param("studentId") Long studentId, @Param("subjectIds") List<Long> subjectIds);
}
