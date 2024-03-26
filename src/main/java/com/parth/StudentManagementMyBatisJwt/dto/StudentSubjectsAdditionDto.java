package com.parth.StudentManagementMyBatisJwt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.List;

@Data
public class StudentSubjectsAdditionDto {
    @NotBlank(message = "subject ids are mandatory")
    @PositiveOrZero(message = "sSubject Id must be positive")
    List<Long> subjectIds;
}
