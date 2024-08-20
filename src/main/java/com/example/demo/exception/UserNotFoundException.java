package com.example.demo.exception;

import com.example.demo.utility.Constiont;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class UserNotFoundException extends DemoException {
    public UserNotFoundException(String name)
    {
        super("user not found by this name : "+name,"error","plz support techqanical team", Constiont.USER_NOTFOUND, HttpStatus.NOT_FOUND);
    }

}
