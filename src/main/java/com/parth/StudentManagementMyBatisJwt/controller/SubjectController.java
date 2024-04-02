package com.parth.StudentManagementMyBatisJwt.controller;

import com.parth.StudentManagementMyBatisJwt.dto.SubjectAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.SubjectDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.SubjectTeacherDisplayDto;
import com.parth.StudentManagementMyBatisJwt.services.SubjectService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

  @GetMapping
  @PreAuthorize("hadAnyRole('ROLE_ROLE_TEACHER', 'ROLE_ROLE_STUDENT', 'ROLE_ROLE_OFFICE_ADMIN')")public List<SubjectDisplayDto> getAllSubjects() {
    return subjectService.getAllSubjects();
  }

  @GetMapping("/{id}")
  @PreAuthorize("hadAnyRole('ROLE_ROLE_TEACHER', 'ROLE_ROLE_STUDENT', 'ROLE_ROLE_OFFICE_ADMIN')")public SubjectTeacherDisplayDto getSubjectById(@PathVariable(value = "id") Long id) {
    return subjectService.getSubjectById(id);
  }

  @PostMapping
  @PreAuthorize("hasRole('ROLE_ROLE_OFFICE_ADMIN')") public SubjectDisplayDto addSubject(@Valid @RequestBody SubjectAdditionDto subjectAdditionDto) {
    return subjectService.addSubject(subjectAdditionDto);
  }
}
