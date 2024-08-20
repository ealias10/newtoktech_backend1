package com.example.demo.request;

import lombok.*;

import java.util.UUID;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryRequest {
    private UUID id;

    private String name;


    private String state;


    private String district;


    private String city;
}
