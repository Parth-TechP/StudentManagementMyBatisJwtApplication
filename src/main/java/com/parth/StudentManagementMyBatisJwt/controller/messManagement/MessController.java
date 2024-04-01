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
@RolesAllowed({"MESS_OWNER", "OFFICE_ADMIN"})
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/messes")
public class MessController {

    @Autowired
    MessService messService;

    @GetMapping
    public List<MessDisplayDto> findAllMesses(){return messService.getAllMesses();}

    @GetMapping("/{id}/owners")
    public MessOwnersInfoDisplayDto findOwnersByMessID(@PathVariable(value = "id")Long id){
        return messService.findOwnersByMessID(id);
    }

    @PostMapping
    public MessDisplayDto addMess(@RequestBody MessAdditionDto messAdditionDto){
        return messService.addMess(messAdditionDto);
    }
}
