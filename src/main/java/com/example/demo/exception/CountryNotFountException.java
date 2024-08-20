package com.example.demo.exception;

import com.example.demo.utility.Constiont;
import org.springframework.http.HttpStatus;

public class CountryNotFountException extends DemoException{
    public CountryNotFountException(String city)
    {
        super("country not fount by city:"+city,"error","pls support tech team", Constiont.COUNTRY_NOTFOUNT, HttpStatus.NOT_FOUND);
    }
}
