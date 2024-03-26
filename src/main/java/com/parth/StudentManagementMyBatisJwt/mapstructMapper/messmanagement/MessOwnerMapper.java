package com.parth.StudentManagementMyBatisJwt.mapstructMapper.messmanagement;

import com.parth.StudentManagementMyBatisJwt.dto.messmanagement.MessOwnerAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.messmanagement.MessOwnerDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.messmanagement.MessOwnerResponseDto;
import com.parth.StudentManagementMyBatisJwt.model.messmanagement.MessEntity;
import com.parth.StudentManagementMyBatisJwt.model.messmanagement.MessOwnerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = MessMapper.class)
public interface MessOwnerMapper {

    @Mapping(source = "name",target = "name")
    @Mapping(source = "contactNumber",target = "contactNumber")
    @Mapping(source = "email",target = "email")
    @Mapping(target = "mess", expression = "java(getMessEntity(messOwnerAdditionDto))")
    MessOwnerEntity convertMessOwnerAdditionDtoToMessOwnerEntity(MessOwnerAdditionDto messOwnerAdditionDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name",target = "name")
    @Mapping(source = "contactNumber",target = "contactNumber")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "mess",target = "mess")
    MessOwnerDisplayDto convertMessEntityToMessOwnerDisplayDto(MessOwnerEntity messOwnerEntity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name",target = "name")
    @Mapping(source = "contactNumber",target = "contactNumber")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "mess.id",target = "messId")
    MessOwnerResponseDto convertMessOwnerEntityToMessOwnerResponseDto(MessOwnerEntity messOwnerEntity);
    List<MessOwnerDisplayDto> convertListOfMessEntityToMessOwnerDisplayDto(List<MessOwnerEntity> messOwnerEntities);

    default MessEntity getMessEntity(MessOwnerAdditionDto messOwnerAdditionDto){
        MessEntity messEntity = new MessEntity();
        messEntity.setId(messOwnerAdditionDto.getMessId());
        return messEntity;
    }
}
