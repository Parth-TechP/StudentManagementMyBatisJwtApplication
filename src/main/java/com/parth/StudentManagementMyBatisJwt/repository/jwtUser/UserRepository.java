package com.parth.StudentManagementMyBatisJwt.repository.jwtUser;

import com.parth.StudentManagementMyBatisJwt.config.JwtUserConnMapper;
import com.parth.StudentManagementMyBatisJwt.model.jwtUser.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
@JwtUserConnMapper("UserMapper")
public interface UserRepository {
    UserEntity findUserByUsername(@Param("username") String username);
}
