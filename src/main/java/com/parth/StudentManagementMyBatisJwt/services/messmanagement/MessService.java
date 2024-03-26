package com.parth.StudentManagementMyBatisJwt.services.messmanagement;

import com.parth.StudentManagementMyBatisJwt.dto.messmanagement.MessAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.messmanagement.MessDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.messmanagement.MessOwnersInfoDisplayDto;
import com.parth.StudentManagementMyBatisJwt.mapstructMapper.messmanagement.MessMapper;
import com.parth.StudentManagementMyBatisJwt.model.messmanagement.MessEntity;
import com.parth.StudentManagementMyBatisJwt.repository.messmanagement.MessOwnerRepository;
import com.parth.StudentManagementMyBatisJwt.repository.messmanagement.MessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessService {
    @Autowired
    MessRepository messRepository;

    @Autowired
    MessMapper messMapper;

    @Autowired
    MessOwnerRepository messOwnerRepository;

    public List<MessDisplayDto> getAllMesses(){
        return messMapper.convertListOfMessEntityToMessDisplayDto(messRepository.findAllMesses());
    }

    public MessOwnersInfoDisplayDto findOwnersByMessID(Long id){
        return messMapper.convertMessEntityToMessOwnersInfoDisplayDto(messRepository.findMessById(id), messOwnerRepository.findOwnersByMessId(id));

    }

    public MessDisplayDto addMess(MessAdditionDto messAdditionDto){
        MessEntity messEntity = messMapper.convertMessAdditionDtoToMessEntity(messAdditionDto);
        messRepository.addMess(messEntity);
        return messMapper.convertMessEntityToMessDisplayDto(messEntity);
    }
}
