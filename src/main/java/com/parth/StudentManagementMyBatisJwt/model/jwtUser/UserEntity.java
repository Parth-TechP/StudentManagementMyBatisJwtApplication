package com.parth.StudentManagementMyBatisJwt.model.jwtUser;

import com.parth.StudentManagementMyBatisJwt.enumPackage.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    private Long id;
    private String username;
    private String password;
    private Role role;
}
