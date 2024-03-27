package com.parth.StudentManagementMyBatisJwt.services.messManagement;

import com.parth.StudentManagementMyBatisJwt.dto.messManagement.MessOwnerAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.messManagement.MessOwnerDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.messManagement.MessOwnerResponseDto;
import com.parth.StudentManagementMyBatisJwt.mapstructMapper.messManagement.MessOwnerMapper;
import com.parth.StudentManagementMyBatisJwt.model.messManagement.MessOwnerEntity;
import com.parth.StudentManagementMyBatisJwt.repository.messManagement.MessOwnerRepository;
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
