package com.parth.StudentManagementMyBatisJwt.mapstructMapper.messManagement;

import com.parth.StudentManagementMyBatisJwt.dto.messManagement.HostelAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.messManagement.HostelDisplayDto;
import com.parth.StudentManagementMyBatisJwt.model.messManagement.HostelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HostelMapper {

  @Mapping(source = "name", target = "name")
  @Mapping(source = "capacity", target = "capacity")
  @Mapping(source = "rating", target = "rating")
  @Mapping(source = "location", target = "location")
  HostelEntity convertHostelAdditionDtoToHostelEntity(HostelAdditionDto hostelAdditionDto);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "capacity", target = "capacity")
  @Mapping(source = "rating", target = "rating")
  @Mapping(source = "location", target = "location")
  HostelDisplayDto convertHostelEntityToHostelDisplayDto(HostelEntity hostelEntity);

  List<HostelDisplayDto> convertListOfHostelEntityToHostelDisplayDto(List<HostelEntity> hostelEntities);
}
