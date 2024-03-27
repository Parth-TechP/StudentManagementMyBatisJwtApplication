package com.parth.StudentManagementMyBatisJwt.services.messManagement;

import com.parth.StudentManagementMyBatisJwt.dto.messManagement.MessAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.messManagement.MessDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.messManagement.MessOwnersInfoDisplayDto;
import com.parth.StudentManagementMyBatisJwt.mapstructMapper.messManagement.MessMapper;
import com.parth.StudentManagementMyBatisJwt.model.messManagement.MessEntity;
import com.parth.StudentManagementMyBatisJwt.repository.messManagement.MessOwnerRepository;
import com.parth.StudentManagementMyBatisJwt.repository.messManagement.MessRepository;
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
