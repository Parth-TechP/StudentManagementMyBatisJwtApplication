package com.parth.StudentManagementMyBatisJwt.controller;

import com.parth.StudentManagementMyBatisJwt.dto.TeacherAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.TeacherDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.TeacherSubjectsDisplayDto;
import com.parth.StudentManagementMyBatisJwt.services.TeacherService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

  @Autowired
  TeacherService teacherService;

  @GetMapping
  @PreAuthorize("hasAnyRole('ROLE_TEACHER', 'ROLE_OFFICE_ADMIN')")public List<TeacherDisplayDto> getAllTeachers() {
    return teacherService.getAllTeachers();
  }

  @GetMapping("/{id}")
  @PreAuthorize("(hasRole('ROLE_TEACHER') and authentication.token.claims['RoleId'] == #id) or hasRole('ROLE_ROLE_OFFICE_ADMIN')")public TeacherDisplayDto getTeacherById(@PathVariable(value = "id") Long id) {
    return teacherService.getTeacherById(id);
  }

  @GetMapping("/{id}/subjects")
  @PreAuthorize("(hasRole('ROLE_TEACHER') and authentication.token.claims['RoleId'] == #id) or hasRole('ROLE_ROLE_OFFICE_ADMIN')")public TeacherSubjectsDisplayDto findSubjectsByTeacherId(@PathVariable(value = "id") Long id) {
    return teacherService.findSubjectsByTeacherId(id);
  }

  @PostMapping
  @PreAuthorize("hasRole('ROLE_ROLE_OFFICE_ADMIN')")public TeacherDisplayDto addTeacher(@Valid @RequestBody TeacherAdditionDto teacherAdditionDto) {
    return teacherService.addTeacher(teacherAdditionDto);
  }
}
