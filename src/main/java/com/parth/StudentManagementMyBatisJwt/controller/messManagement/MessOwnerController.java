package com.parth.StudentManagementMyBatisJwt.controller.messManagement;

import com.parth.StudentManagementMyBatisJwt.dto.messManagement.MessOwnerAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.messManagement.MessOwnerDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.messManagement.MessOwnerResponseDto;
import com.parth.StudentManagementMyBatisJwt.services.messManagement.MessOwnerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mess-owners")
public class MessOwnerController {

    @Autowired
    MessOwnerService messOwnerService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ROLE_OFFICE_ADMIN')")
    public List<MessOwnerDisplayDto> findAllMessOwners(){return messOwnerService.getAllMessOwners();}

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ROLE_OFFICE_ADMIN')")
    public MessOwnerResponseDto addMessOwners(@RequestBody MessOwnerAdditionDto messOwnerAdditionDto){
        return messOwnerService.addMessOwner(messOwnerAdditionDto);
    }
}
