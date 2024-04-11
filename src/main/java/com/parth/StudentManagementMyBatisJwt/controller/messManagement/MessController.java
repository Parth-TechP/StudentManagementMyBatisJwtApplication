package com.parth.StudentManagementMyBatisJwt.controller.messManagement;

import com.parth.StudentManagementMyBatisJwt.dto.messManagement.MessAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.messManagement.MessDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.messManagement.MessOwnersInfoDisplayDto;
import com.parth.StudentManagementMyBatisJwt.services.messManagement.MessService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RolesAllowed({"ROLE_MESS_OWNER", "ROLE_OFFICE_ADMIN"})
@RequestMapping("/messes")
public class MessController {

    @Autowired
    MessService messService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ROLE_OFFICE_ADMIN', 'ROLE_ROLE_MESS_OWNER')")
    public List<MessDisplayDto> findAllMesses(){return messService.getAllMesses();}

    @GetMapping("/{id}/owners")
    @PreAuthorize("(hasRole('ROLE_ROLE_MESS_OWNER') and authentication.token.claims['RoleId'] == #id) or hasRole('ROLE_ROLE_OFFICE_ADMIN')")
    public MessOwnersInfoDisplayDto findOwnersByMessID(@PathVariable(value = "id")Long id){
        return messService.findOwnersByMessID(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ROLE_OFFICE_ADMIN')")
    public MessDisplayDto addMess(@RequestBody MessAdditionDto messAdditionDto){
        return messService.addMess(messAdditionDto);
    }
}
