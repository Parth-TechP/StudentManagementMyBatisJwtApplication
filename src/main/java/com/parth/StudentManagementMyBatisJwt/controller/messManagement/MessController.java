package com.parth.StudentManagementMyBatisJwt.controller.messManagement;

import com.parth.StudentManagementMyBatisJwt.dto.messManagement.MessAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.messManagement.MessDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.messManagement.MessOwnersInfoDisplayDto;
import com.parth.StudentManagementMyBatisJwt.services.messManagement.MessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
