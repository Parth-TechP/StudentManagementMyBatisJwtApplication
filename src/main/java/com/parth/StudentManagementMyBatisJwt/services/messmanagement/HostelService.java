package com.parth.StudentManagementMyBatisJwt.services.messmanagement;

import com.parth.StudentManagementMyBatisJwt.dto.messmanagement.HostelAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.messmanagement.HostelDisplayDto;
import com.parth.StudentManagementMyBatisJwt.mapstructMapper.messmanagement.HostelMapper;
import com.parth.StudentManagementMyBatisJwt.model.messmanagement.HostelEntity;
import com.parth.StudentManagementMyBatisJwt.repository.messmanagement.HostelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostelService {

    @Autowired
    HostelRepository hostelRepository;

    @Autowired
    HostelMapper hostelMapper;

    public List<HostelDisplayDto> getAllHostel(){
        return hostelMapper.convertListOfHostelEntityToHostelDisplayDto(hostelRepository.findAllHostels());
    }

    public HostelDisplayDto addHostel(HostelAdditionDto hostelAdditionDto){
        HostelEntity hostelEntity = hostelMapper.convertHostelAdditionDtoToHostelEntity(hostelAdditionDto);
        hostelRepository.addHostel(hostelEntity);
        return hostelMapper.convertHostelEntityToHostelDisplayDto(hostelEntity);
    }
}
