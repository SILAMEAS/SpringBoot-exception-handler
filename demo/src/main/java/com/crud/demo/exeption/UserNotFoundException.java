package com.crud.demo.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends  RuntimeException{
    public UserNotFoundException(Long id){
        super("Could not found the user with id : "+id);
    }
}
