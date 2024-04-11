package com.parth.StudentManagementMyBatisJwt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UnauthorizedAccessException extends RuntimeException{
    public UnauthorizedAccessException(){super("Access Denied !");}
}
