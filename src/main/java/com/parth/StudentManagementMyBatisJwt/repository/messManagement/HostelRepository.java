package com.parth.StudentManagementMyBatisJwt.repository.messManagement;

import com.parth.StudentManagementMyBatisJwt.config.MessManagementConnMapper;
import com.parth.StudentManagementMyBatisJwt.model.messManagement.HostelEntity;

import java.util.List;
@MessManagementConnMapper
public interface HostelRepository {
    List<HostelEntity> findAllHostels();

    void addHostel(HostelEntity hostelEntity);
}
