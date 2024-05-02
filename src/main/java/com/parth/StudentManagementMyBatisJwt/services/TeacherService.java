package com.parth.StudentManagementMyBatisJwt.services;

import com.parth.StudentManagementMyBatisJwt.dto.TeacherAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.TeacherDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.TeacherSubjectsDisplayDto;
import com.parth.StudentManagementMyBatisJwt.exceptions.ResourceNotFoundException;
import com.parth.StudentManagementMyBatisJwt.mapstructMapper.TeacherMapper;
import com.parth.StudentManagementMyBatisJwt.model.TeacherEntity;
import com.parth.StudentManagementMyBatisJwt.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public TeacherDisplayDto getTeacherById(Long id){
        TeacherEntity teacher = teacherRepository.findSubjectsByTeacherId(id);
        if (teacher != null){
            return teacherMapper.convertTeacherEntityToTeacherDisplayDto(teacher);
        } else {
            throw new ResourceNotFoundException(id);
        }
    }

    public TeacherSubjectsDisplayDto findSubjectsByTeacherId(Long id){
        TeacherEntity teacher = teacherRepository.findSubjectsByTeacherId(id);
        if (teacher != null){
            return teacherMapper.convertTeacherEntityToTeacherSubjectsDisplayDto(teacher);
        } else{
            throw new ResourceNotFoundException(id);
        }
    }

    public TeacherDisplayDto addTeacher(TeacherAdditionDto teacherAdditionDto){
        TeacherEntity teacherEntity = teacherMapper.convertTeacherAdditionDtoToTeacherEntity(teacherAdditionDto);
        teacherRepository.addTeacher(teacherEntity);
        return teacherMapper.convertTeacherEntityToTeacherDisplayDto(teacherEntity);
    }
}
