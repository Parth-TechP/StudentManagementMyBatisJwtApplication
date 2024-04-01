package com.parth.StudentManagementMyBatisJwt.controller;


import com.parth.StudentManagementMyBatisJwt.dto.StudentAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.StudentDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.StudentSubjectsAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.StudentSubjectsDisplayDto;
import com.parth.StudentManagementMyBatisJwt.exceptions.ResourceNotFoundException;
import com.parth.StudentManagementMyBatisJwt.services.StudentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RolesAllowed({"STUDENT","OFFICE_ADMIN"})
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<StudentDisplayDto> getAllStudents(@RequestParam(name = "name",required = false)String name,
                                                  @RequestParam(name = "age",required = false)Integer age,
                                                  @RequestParam(name = "city",required = false)String city){
        return studentService.getAllStudents(name, age, city);
    }

    @GetMapping("/{id}")
    public StudentDisplayDto getStudentById(@PathVariable(value = "id")Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/{id}/subjects")
    public StudentSubjectsDisplayDto findSubjectsByStudentId(@PathVariable(value = "id")Long id){
        return studentService.findSubjectsByStudentId(id);
    }

    @PostMapping
    public StudentDisplayDto addStudent(@Valid @RequestBody StudentAdditionDto studentAdditionDto){
         return studentService.addStudent(studentAdditionDto);
    }

    @PostMapping("/{id}/subjects")
    public StudentSubjectsDisplayDto assignSubjectsToStudent(@Valid@PathVariable(value = "id")Long id, @RequestBody StudentSubjectsAdditionDto subjectsAdditionDto) throws ResourceNotFoundException {
        return studentService.assignSubjectsToStudent(id, subjectsAdditionDto);
    }
}
