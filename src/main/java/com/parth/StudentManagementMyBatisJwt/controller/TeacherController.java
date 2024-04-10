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
@RolesAllowed({"ROLE_TEACHER", "ROLE_OFFICE_ADMIN"})
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping
    public List<TeacherDisplayDto> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public TeacherDisplayDto getTeacherById(@PathVariable(value = "id")Long id, @AuthenticationPrincipal Jwt jwt){
        return teacherService.getTeacherById(id, jwt);
    }

    @GetMapping("/{id}/subjects")
    public TeacherSubjectsDisplayDto findSubjectsByTeacherId(@PathVariable(value = "id")Long id, @AuthenticationPrincipal Jwt jwt){
        return teacherService.findSubjectsByTeacherId(id, jwt);
    }

    @PostMapping
    public TeacherDisplayDto addTeacher(@Valid @RequestBody TeacherAdditionDto teacherAdditionDto){
        return teacherService.addTeacher(teacherAdditionDto);
    }
}
