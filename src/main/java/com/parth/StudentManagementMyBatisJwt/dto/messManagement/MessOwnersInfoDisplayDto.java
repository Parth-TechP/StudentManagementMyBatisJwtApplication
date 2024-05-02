package com.parth.StudentManagementMyBatisJwt.dto.messManagement;

import lombok.Data;

import java.util.List;

@Data
public class MessOwnersInfoDisplayDto {
    private Long id;
    private String name;
    private String messType;
    private String location;
    private List<MessOwnerResponseDto> messOwners;
}
