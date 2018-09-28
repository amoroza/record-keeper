package com.edmunds.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by alekseymorozov on 9/28/18.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends  RuntimeException{

    public PersonNotFoundException(String exception){
        super(exception);
    }
}
