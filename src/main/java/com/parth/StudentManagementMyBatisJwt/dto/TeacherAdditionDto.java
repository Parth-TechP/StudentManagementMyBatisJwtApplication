package com.parth.StudentManagementMyBatisJwt.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class TeacherAdditionDto {
    @NotBlank(message = "name is mandatory")
    private String name;
    @NotBlank(message = "age is mandatory")
    @PositiveOrZero(message = "age must be Positive")
    private int age;
    @NotBlank(message = "email is mandatory")
    @Email(message = "enter proper email")
    private String email;
    @NotBlank(message = "city is mandatory")
    private String city;
}
