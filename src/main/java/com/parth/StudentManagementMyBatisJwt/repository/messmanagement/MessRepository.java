package com.parth.StudentManagementMyBatisJwt.repository.messmanagement;

import com.parth.StudentManagementMyBatisJwt.config.MessManagementConnMapper;
import com.parth.StudentManagementMyBatisJwt.model.messmanagement.MessEntity;

import java.util.List;

@MessManagementConnMapper
public interface MessRepository {
    List<MessEntity> findAllMesses();

    MessEntity findMessById(Long id);

    void addMess(MessEntity messEntity);
}
