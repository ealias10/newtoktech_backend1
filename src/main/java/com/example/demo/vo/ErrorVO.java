package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class ErrorVO {

    private String displayTitle;

    private String displayMessage;

    private Integer status;

    private String errorCode;


    private List<String> errors;

    public ErrorVO ()
    {
       this.displayMessage="plz support tech team";
       this.displayTitle="error";
       errors=new ArrayList<>();
    }

}
