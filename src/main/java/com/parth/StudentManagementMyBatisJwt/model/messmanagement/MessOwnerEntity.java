package com.parth.StudentManagementMyBatisJwt.model.messmanagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessOwnerEntity {
    private Long id;
    private String name;
    private String contactNumber;
    private String email;
    private MessEntity mess;
}
