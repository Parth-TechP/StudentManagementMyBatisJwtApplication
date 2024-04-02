package com.parth.StudentManagementMyBatisJwt.services.messManagement;

import com.parth.StudentManagementMyBatisJwt.dto.messManagement.HostelAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.messManagement.HostelDisplayDto;
import com.parth.StudentManagementMyBatisJwt.mapstructMapper.messManagement.HostelMapper;
import com.parth.StudentManagementMyBatisJwt.model.messManagement.HostelEntity;
import com.parth.StudentManagementMyBatisJwt.repository.messManagement.HostelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostelService {

  @Autowired
  HostelRepository hostelRepository;

  @Autowired
  HostelMapper hostelMapper;

  public List<HostelDisplayDto> getAllHostel() {
    return hostelMapper.convertListOfHostelEntityToHostelDisplayDto(hostelRepository.findAllHostels());
  }

  public HostelDisplayDto addHostel(HostelAdditionDto hostelAdditionDto) {
    HostelEntity hostelEntity = hostelMapper.convertHostelAdditionDtoToHostelEntity(hostelAdditionDto);
    hostelRepository.addHostel(hostelEntity);
    return hostelMapper.convertHostelEntityToHostelDisplayDto(hostelEntity);
  }
}
