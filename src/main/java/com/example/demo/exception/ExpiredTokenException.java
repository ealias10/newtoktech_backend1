package com.example.demo.exception;

import com.example.demo.utility.Constiont;
import org.springframework.http.HttpStatus;

public class ExpiredTokenException extends DemoException{
    private static final long serialVersionUID = 30763009752460581L;

    public ExpiredTokenException() {
        super("Token is expired", HttpStatus.UNAUTHORIZED, Constiont.EXPIRED_TOKEN_ERROR_CODE);
    }
}
