package com.example.demo.vo;

import lombok.*;

import java.util.UUID;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryVO {

    private UUID id;

    private String name;


    private String state;


    private String district;


    private String city;

}
