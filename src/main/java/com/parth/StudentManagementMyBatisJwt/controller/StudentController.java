package com.parth.StudentManagementMyBatisJwt.controller;


import com.parth.StudentManagementMyBatisJwt.dto.*;
import com.parth.StudentManagementMyBatisJwt.exceptions.DuplicateDataException;
import com.parth.StudentManagementMyBatisJwt.exceptions.ResourceNotFoundException;
import com.parth.StudentManagementMyBatisJwt.services.StudentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

  @Autowired
  StudentService studentService;

  @GetMapping
  @PreAuthorize("hasAnyRole('ROLE_ROLE_STUDENT','ROLE_ROLE_OFFICE_ADMIN')")public List<StudentDisplayDto> getAllStudents(@RequestParam(name = "name", required = false) String name,
                                                @RequestParam(name = "age", required = false) Integer age,
                                                @RequestParam(name = "city", required = false) String city) {
    return studentService.getAllStudents(name, age, city);
  }

  @GetMapping("/{id}")
  @PreAuthorize("(hasRole('ROLE_ROLE_STUDENT') and authentication.token.claims['RoleId'] == #id) or hasRole('ROLE_ROLE_OFFICE_ADMIN')")public StudentDisplayDto getStudentById(@PathVariable(value = "id") Long id) {
    return studentService.getStudentById(id);
  }

  @GetMapping("/{id}/subjects")
  @PreAuthorize("(hasRole('ROLE_ROLE_STUDENT') and authentication.token.claims['RoleId'] == #id) or hasRole('ROLE_ROLE_OFFICE_ADMIN')")public StudentSubjectsDisplayDto findSubjectsByStudentId(@PathVariable(value = "id") Long id) {
    return studentService.findSubjectsByStudentId(id);
  }

  @PostMapping
  @PreAuthorize("hasRole('ROLE_ROLE_OFFICE_ADMIN')")public StudentDisplayDto addStudent(@Valid @RequestBody StudentAdditionDto studentAdditionDto) {
    return studentService.addStudent(studentAdditionDto);
  }

  @PostMapping("/{id}/subjects")
  @PreAuthorize("hasRole('ROLE_ROLE_OFFICE_ADMIN')") public StudentSubjectsDisplayDto assignSubjectsToStudent(@Valid @PathVariable(value = "id") Long id,
                                                                                                             @RequestBody StudentSubjectsAdditionDto subjectsAdditionDto)
    throws Exception {
    return studentService.assignSubjectsToStudent(id, subjectsAdditionDto);
  }
}
