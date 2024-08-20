package com.example.demo.utility;

public class Constiont {
    public Constiont ( )
    {
        throw new IllegalStateException("java class");
    }

    public static final String UNAUTHORIZED_ERROR_CODE = "401-100";
    public static final String INVALID_TOKEN_ERROR_CODE = "401-101";
    public static final String USER_NOTFOUND="403-100";
    public static final String COUNTRY_NOTFOUNT="403-101";


    public static final String COUNTRY_EXIST="404-100";
    public static final String EXPIRED_TOKEN_ERROR_CODE = "404-102";
}
