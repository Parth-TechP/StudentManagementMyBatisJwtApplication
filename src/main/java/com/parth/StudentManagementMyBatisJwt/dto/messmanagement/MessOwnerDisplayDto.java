package com.parth.StudentManagementMyBatisJwt.dto.messmanagement;

import com.parth.StudentManagementMyBatisJwt.model.messmanagement.MessEntity;
import lombok.Data;

@Data
public class MessOwnerDisplayDto {
    private Long id;
    private String name;
    private String contactNumber;
    private String email;
    private MessEntity mess;
}
