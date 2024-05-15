package com.parth.StudentManagementMyBatisJwt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.List;

@Data
public class SubjectAssignmentDto {
    @NotBlank(message = "subject are mandatory")
    List<String> subjects;
}
