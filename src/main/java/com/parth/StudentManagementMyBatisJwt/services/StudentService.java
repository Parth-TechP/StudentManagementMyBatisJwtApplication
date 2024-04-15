package com.parth.StudentManagementMyBatisJwt.services;

import com.parth.StudentManagementMyBatisJwt.dto.StudentAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.StudentDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.StudentSubjectsAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.StudentSubjectsDisplayDto;
import com.parth.StudentManagementMyBatisJwt.exceptions.DuplicateDataException;
import com.parth.StudentManagementMyBatisJwt.exceptions.ResourceNotFoundException;
import com.parth.StudentManagementMyBatisJwt.exceptions.UnauthorizedAccessException;
import com.parth.StudentManagementMyBatisJwt.mapstructMapper.StudentMapper;
import com.parth.StudentManagementMyBatisJwt.model.StudentEntity;
import com.parth.StudentManagementMyBatisJwt.model.SubjectEntity;
import com.parth.StudentManagementMyBatisJwt.repository.StudentRepository;
import com.parth.StudentManagementMyBatisJwt.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    SubjectRepository subjectRepository;
    public List<StudentDisplayDto> getAllStudents(String name, Integer age, String city){
        return studentMapper.convertListOfStudentEntityToStudentDisplayDto(studentRepository.findAllStudents(name, age, city));
    }

    public StudentDisplayDto getStudentById(Long id){
        return studentMapper.convertStudentEntityToStudentDisplayDto(studentRepository.findStudentById(id));
    }

    public StudentSubjectsDisplayDto findSubjectsByStudentId(Long id){
        return studentMapper.convertStudentEntityToStudentSubjectsDisplayDto(studentRepository.findSubjectsByStudentId(id));
    }

    public StudentDisplayDto addStudent(StudentAdditionDto studentAdditionDto){
        StudentEntity studentEntity = studentMapper.convertStudentAdditionDtoToStudentEntity(studentAdditionDto);
        studentRepository.addStudent(studentEntity);
        return studentMapper.convertStudentEntityToStudentDisplayDto(studentEntity);
    }

    public StudentSubjectsDisplayDto assignSubjectsToStudent(Long id, StudentSubjectsAdditionDto subjectsAdditionDto)throws ResourceNotFoundException {
        List<SubjectEntity> subjectEntities = subjectRepository.findAllSubjects();
        List<SubjectEntity> assignedSubjects = studentRepository.findSubjectsByStudentId(id).getSubjects();
        if (subjectsAdditionDto != null) {
            List<Long> subjectIds = subjectsAdditionDto.getSubjectIds();
            for (Long subjectId : subjectIds) {
                boolean existsInEntities = subjectEntities.stream().anyMatch(s -> s.getId().equals(subjectId));
                boolean existsInAssigned = assignedSubjects.stream().anyMatch(s -> s.getId().equals(subjectId));
                if (!existsInEntities) {
                    throw new ResourceNotFoundException(subjectId);
                }
                if (existsInAssigned) {
                    throw new DuplicateDataException(subjectId);
                }
            }
            studentRepository.assignSubjectsToStudent(id, subjectIds);
        }
        return studentMapper.convertStudentEntityToStudentSubjectsDisplayDto(studentRepository.findSubjectsByStudentId(id));
    }

}
