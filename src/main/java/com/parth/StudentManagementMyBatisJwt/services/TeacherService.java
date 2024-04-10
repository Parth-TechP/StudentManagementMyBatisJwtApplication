package com.parth.StudentManagementMyBatisJwt.services;

import com.parth.StudentManagementMyBatisJwt.dto.TeacherAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.TeacherDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.TeacherSubjectsDisplayDto;
import com.parth.StudentManagementMyBatisJwt.exceptions.UnauthorizedAccessException;
import com.parth.StudentManagementMyBatisJwt.mapstructMapper.TeacherMapper;
import com.parth.StudentManagementMyBatisJwt.model.TeacherEntity;
import com.parth.StudentManagementMyBatisJwt.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherMapper teacherMapper;

    public List<TeacherDisplayDto> getAllTeachers(){
        return teacherMapper.convertListOfTeacherEntityToTeacherDisplayDto(teacherRepository.findAllTeachers());
    }

    public TeacherDisplayDto getTeacherById(Long id, Jwt jwt){
        Long roleId = (Long) jwt.getClaims().get("RoleId");
        if (id.equals(roleId))
            return teacherMapper.convertTeacherEntityToTeacherDisplayDto(teacherRepository.findSubjectsByTeacherId(id));
        else
            throw new UnauthorizedAccessException();
    }

    public TeacherSubjectsDisplayDto findSubjectsByTeacherId(Long id, Jwt jwt){
        Long roleId = (Long) jwt.getClaims().get("RoleId");
        if (id.equals(roleId))
            return teacherMapper.convertTeacherEntityToTeacherSubjectsDisplayDto(teacherRepository.findSubjectsByTeacherId(id));
        else
            throw new UnauthorizedAccessException();
    }

    public TeacherDisplayDto addTeacher(TeacherAdditionDto teacherAdditionDto){
        TeacherEntity teacherEntity = teacherMapper.convertTeacherAdditionDtoToTeacherEntity(teacherAdditionDto);
        teacherRepository.addTeacher(teacherEntity);
        return teacherMapper.convertTeacherEntityToTeacherDisplayDto(teacherEntity);
    }
}
