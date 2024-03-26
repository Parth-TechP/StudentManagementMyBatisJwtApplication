package com.parth.StudentManagementMyBatisJwt.repository.messmanagement;

import com.parth.StudentManagementMyBatisJwt.config.MessManagementConnMapper;
import com.parth.StudentManagementMyBatisJwt.model.messmanagement.HostelEntity;

import java.util.List;
@MessManagementConnMapper
public interface HostelRepository {
    List<HostelEntity> findAllHostels();

    void addHostel(HostelEntity hostelEntity);
}
