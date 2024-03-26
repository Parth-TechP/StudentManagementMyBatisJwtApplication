package com.parth.StudentManagementMyBatisJwt.dto.messmanagement;

import lombok.Data;

@Data
public class HostelDisplayDto {
    private Long id;
    private String name;
    private Integer capacity;
    private Integer rating;
    private String location;
}
