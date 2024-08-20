package com.example.demo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class DemoException extends Exception{

    private String displayMessage;

    private String displayTitle;

    private String errorCode;

    private HttpStatus status;

    public DemoException(String message,String displayTitle, String displayMessage, String errorCode, HttpStatus status)
    {
        super(message);
        this.errorCode=errorCode;
        this.displayMessage=displayMessage;
        this.displayTitle=displayTitle;
        this.status=status;

    }

    public DemoException(String message, HttpStatus status, String errorCode) {
        super(message);
        this.status = status;
        this.errorCode = errorCode;
        this.displayTitle = "Some Error Occurred";
        this.displayMessage = "Please check with technical support for assistance!";
    }

}
