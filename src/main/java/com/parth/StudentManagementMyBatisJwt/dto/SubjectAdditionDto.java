package com.parth.StudentManagementMyBatisJwt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class SubjectAdditionDto {
    @NotBlank(message = "name is mandatory")
    private String name;
    @NotBlank(message = "credits is mandatory")
    @PositiveOrZero(message = "credits must be positive")
    private int credits;
    @NotBlank(message = "teacher is mandatory")
    private Long teacherId;
}
