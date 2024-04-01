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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RolesAllowed({"TEACHER","STUDENT","OFFICE_ADMIN"})
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @GetMapping
    public List<SubjectDisplayDto> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{id}")
    public SubjectTeacherDisplayDto getSubjectById(@PathVariable(value = "id")Long id){
        return subjectService.getSubjectById(id);
    }

    @PostMapping
    public SubjectDisplayDto addSubject(@Valid @RequestBody SubjectAdditionDto subjectAdditionDto){
        return subjectService.addSubject(subjectAdditionDto);
    }
}
