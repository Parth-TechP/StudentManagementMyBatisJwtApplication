package com.parth.StudentManagementMyBatisJwt.model.messmanagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessEntity {
    private Long id;
    private String name;
    private String messType;
    private String location;
}
