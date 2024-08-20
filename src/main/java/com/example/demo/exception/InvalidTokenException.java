package com.example.demo.exception;

import com.example.demo.utility.Constiont;
import org.springframework.http.HttpStatus;

public class InvalidTokenException extends DemoException{

    public InvalidTokenException() {
        super("Token is invalid", HttpStatus.UNAUTHORIZED, Constiont.INVALID_TOKEN_ERROR_CODE);
    }
}
