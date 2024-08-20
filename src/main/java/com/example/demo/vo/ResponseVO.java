package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class ResponseVO<T> {

    private String message;
    private Integer stutus;
    private List<T> data;
    private ErrorVO error;

    private Integer totalCount;

    public ResponseVO()
    {
        this.message="sucess";
        this.stutus=200;
        this.data=new ArrayList<>();
    }
    public void addData(T data)
    {
       if(data!=null)
       {
           this.data.add(data);
       }
    }

    public void addDataList(List<T> data) {
        if (data != null && !data.isEmpty()) {
            this.data.addAll(data);
            this.totalCount = data.size();
        }
    }
}
