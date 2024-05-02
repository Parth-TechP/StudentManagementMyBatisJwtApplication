package com.parth.StudentManagementMyBatisJwt.dto.messManagement;

import lombok.Data;

@Data
public class MessOwnerResponseDto {
    private Long id;
    private String name;
    private String contactNumber;
    private String email;
    private Long messId;
}
