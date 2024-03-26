package com.parth.StudentManagementMyBatisJwt.repository.messmanagement;

import com.parth.StudentManagementMyBatisJwt.config.MessManagementConnMapper;
import com.parth.StudentManagementMyBatisJwt.model.messmanagement.MessOwnerEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MessManagementConnMapper
public interface MessOwnerRepository {
    List<MessOwnerEntity> findAllMessOwners();

    List<MessOwnerEntity> findOwnersByMessId(@Param("messId") Long id);

    void addMessOwner(MessOwnerEntity messOwnerEntity);
}
