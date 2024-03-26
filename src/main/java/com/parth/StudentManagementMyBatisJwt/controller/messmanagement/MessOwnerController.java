package com.parth.StudentManagementMyBatisJwt.controller.messmanagement;

import com.parth.StudentManagementMyBatisJwt.dto.messmanagement.MessOwnerAdditionDto;
import com.parth.StudentManagementMyBatisJwt.dto.messmanagement.MessOwnerDisplayDto;
import com.parth.StudentManagementMyBatisJwt.dto.messmanagement.MessOwnerResponseDto;
import com.parth.StudentManagementMyBatisJwt.services.messmanagement.MessOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
