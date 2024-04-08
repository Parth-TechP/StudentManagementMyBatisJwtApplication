package com.parth.StudentManagementMyBatisJwt.services;

import com.parth.StudentManagementMyBatisJwt.dto.*;
import com.parth.StudentManagementMyBatisJwt.exceptions.DuplicateDataException;
import com.parth.StudentManagementMyBatisJwt.exceptions.DuplicateDataException;
import com.parth.StudentManagementMyBatisJwt.exceptions.ResourceNotFoundException;
import com.parth.StudentManagementMyBatisJwt.mapstructMapper.StudentMapper;
import com.parth.StudentManagementMyBatisJwt.model.StudentEntity;
import com.parth.StudentManagementMyBatisJwt.model.SubjectEntity;
import com.parth.StudentManagementMyBatisJwt.repository.StudentRepository;
import com.parth.StudentManagementMyBatisJwt.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

@Service
public class StudentService {

  @Autowired
  StudentRepository studentRepository;

  @Autowired
  StudentMapper studentMapper;

  @Autowired
  SubjectRepository subjectRepository;

  public List<StudentDisplayDto> getAllStudents(String name, Integer age, String city) {
    return studentMapper.convertListOfStudentEntityToStudentDisplayDto(studentRepository.findAllStudents(name, age, city));
  }

  public StudentDisplayDto getStudentById(Long id) {
    StudentEntity student = studentRepository.findStudentById(id);
        if (student != null){
            return studentMapper.convertStudentEntityToStudentDisplayDto(student);
        }
        else {
            throw new ResourceNotFoundException(id);
  }}

  public StudentSubjectsDisplayDto findSubjectsByStudentId(Long id) {
    StudentEntity student = studentRepository.findStudentById(id);
        if (student != null){return studentMapper.convertStudentEntityToStudentSubjectsDisplayDto(studentRepository.findSubjectsByStudentId(id));
  }else {
            throw new ResourceNotFoundException(id);
        }
    }

  public StudentDisplayDto addStudent(StudentAdditionDto studentAdditionDto) {
    StudentEntity studentEntity = studentMapper.convertStudentAdditionDtoToStudentEntity(studentAdditionDto);
    studentRepository.addStudent(studentEntity);
    return studentMapper.convertStudentEntityToStudentDisplayDto(studentEntity);
  }

  @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = DataFormatException.class)
  public StudentSubjectsDisplayDto assignSubjectsToStudent(Long id, StudentSubjectsAdditionDto subjectsAdditionDto)
    throws ResourceNotFoundException {
    List<SubjectEntity> subjectEntities = subjectRepository.findAllSubjects();
    List<SubjectEntity> assignedSubjects = studentRepository.findSubjectsByStudentId(id).getSubjects();
    if (subjectsAdditionDto != null) {
      List<Long> subjectIds = subjectsAdditionDto.getSubjectIds();

        for (Long subjectId : subjectIds) {
          boolean existsInEntities = subjectEntities.stream().anyMatch(s -> s.getId().equals(subjectId) );
          boolean existsInAssigned = assignedSubjects.stream().anyMatch(s ->s.getId().equals(subjectId)) ;
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

    @Transactional(transactionManager = "MyBatisSchoolTransactionManager", rollbackFor = DataFormatException.class)
    public List<StudentSubjectsDisplayDto> assignSubjectsToAllStudents(SubjectAssignmentDto subjectAssignmentDto) throws Exception {
        List<Long> subjectIds = new ArrayList<>();
        for (String name: subjectAssignmentDto.getSubjects()){
            subjectIds.add(subjectRepository.getSubjectIdBySubjectName(name));
        }

        List<StudentEntity> studentEntities = studentRepository.findAllStudents(null, null,null);

        List<StudentSubjectsDisplayDto> studentSubjectsDisplayDtos = new ArrayList<>();

        StudentSubjectsAdditionDto subjectsAdditionDto = new StudentSubjectsAdditionDto();
        subjectsAdditionDto.setSubjectIds(subjectIds);

        for(StudentEntity student: studentEntities){
            studentSubjectsDisplayDtos.add(assignSubjectsToStudent(student.getId(), subjectsAdditionDto));
        }
        return studentSubjectsDisplayDtos;
    }

}
