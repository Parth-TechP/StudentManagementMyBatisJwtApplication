package com.parth.StudentManagementMyBatisJwt.services;

import com.parth.StudentManagementMyBatisJwt.dto.SubjectAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.SubjectDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.SubjectTeacherDisplayDto;
import com.parth.StudentManagementMyBatisJwt.exceptions.ResourceNotFoundException;
import com.parth.StudentManagementMyBatisJwt.mapstructMapper.SubjectMapper;
import com.parth.StudentManagementMyBatisJwt.model.SubjectEntity;
import com.parth.StudentManagementMyBatisJwt.model.TeacherEntity;
import com.parth.StudentManagementMyBatisJwt.repository.SubjectRepository;
import com.parth.StudentManagementMyBatisJwt.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    SubjectMapper subjectMapper;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    TeacherRepository teacherRepository;

    public List<SubjectDisplayDto> getAllSubjects(){
        return subjectMapper.convertListOfSubjectEntityToSubjectDisplayDto(subjectRepository.findAllSubjects());
    }

    public SubjectTeacherDisplayDto getSubjectById(Long id){
        SubjectEntity subject = subjectRepository.findSubjectById(id);
        if (subject != null){
            return subjectMapper.convertSubjectEntityToSubjectTeacherDisplayDto(subject);
        } else {
            throw new ResourceNotFoundException(id);
        }
    }

    public SubjectDisplayDto addSubject(SubjectAdditionDto subjectAdditionDto){
        TeacherEntity teacher = teacherRepository.findTeacherById(subjectAdditionDto.getTeacherId());
        if (teacher == null){
            throw new ResourceNotFoundException(subjectAdditionDto.getTeacherId());
        }else {
            SubjectEntity subjectEntity = subjectMapper.convertSubjectAdditionDtoToSubjectEntity(subjectAdditionDto);
            subjectRepository.addSubject(subjectEntity);
            return subjectMapper.convertSubjectEntityToSubjectDisplayDto(subjectEntity);
        }
    }
}
