package com.parth.StudentManagementMyBatisJwt.services.messmanagement;

import com.parth.StudentManagementMyBatisJwt.dto.messmanagement.MessOwnerAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.messmanagement.MessOwnerDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.messmanagement.MessOwnerResponseDto;
import com.parth.StudentManagementMyBatisJwt.mapstructMapper.messmanagement.MessOwnerMapper;
import com.parth.StudentManagementMyBatisJwt.model.messmanagement.MessOwnerEntity;
import com.parth.StudentManagementMyBatisJwt.repository.messmanagement.MessOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessOwnerService {

    @Autowired
    MessOwnerRepository messOwnerRepository;

    @Autowired
    MessOwnerMapper messOwnerMapper;

    public List<MessOwnerDisplayDto> getAllMessOwners(){
        return messOwnerMapper.convertListOfMessEntityToMessOwnerDisplayDto(messOwnerRepository.findAllMessOwners());
    }

    public MessOwnerResponseDto addMessOwner(MessOwnerAdditionDto messOwnerAdditionDto){
        MessOwnerEntity messOwnerEntity = messOwnerMapper.convertMessOwnerAdditionDtoToMessOwnerEntity(messOwnerAdditionDto);
        messOwnerRepository.addMessOwner(messOwnerEntity);
        return messOwnerMapper.convertMessOwnerEntityToMessOwnerResponseDto(messOwnerEntity);
    }
}
