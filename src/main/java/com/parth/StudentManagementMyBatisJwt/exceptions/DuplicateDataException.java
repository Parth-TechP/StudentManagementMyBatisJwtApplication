package com.parth.StudentManagementMyBatisJwt.exceptions;

public class DuplicateDataException extends RuntimeException{
    public DuplicateDataException(Long id) {
        super("409 conflict with id "+id+" already exists");
    }
}
