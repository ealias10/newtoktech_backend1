package com.example.demo.exception;

import com.example.demo.utility.Constiont;
import org.springframework.http.HttpStatus;

public class CountryExistException extends DemoException{

    public CountryExistException(String name)
    {
        super("this country already exist "+name,"error occar","pls support teaqanical team", Constiont.COUNTRY_EXIST, HttpStatus.CONFLICT);
    }
}
