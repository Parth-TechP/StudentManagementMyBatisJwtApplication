package com.parth.StudentManagementMyBatisJwt.dto.kafka;

import lombok.Data;

@Data
public class StudentAdditionReceiveDto {
    private Long logId;
    private String name;
    private int age;
    private String email;
    private String city;
}
