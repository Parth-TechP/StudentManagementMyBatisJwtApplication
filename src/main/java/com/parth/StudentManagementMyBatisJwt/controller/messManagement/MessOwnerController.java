package com.parth.StudentManagementMyBatisJwt.controller.messManagement;

import com.parth.StudentManagementMyBatisJwt.dto.messManagement.MessOwnerAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.messManagement.MessOwnerDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.messManagement.MessOwnerResponseDto;
import com.parth.StudentManagementMyBatisJwt.services.messManagement.MessOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ROLE_OFFICE_ADMIN')")
@RequestMapping("/mess-owners")
public class MessOwnerController {

    @Autowired
    MessOwnerService messOwnerService;

    @GetMapping
    public List<MessOwnerDisplayDto> findAllMessOwners(){return messOwnerService.getAllMessOwners();}

    @PostMapping
    public MessOwnerResponseDto addMessOwners(@RequestBody MessOwnerAdditionDto messOwnerAdditionDto){
        return messOwnerService.addMessOwner(messOwnerAdditionDto);
    }
}
