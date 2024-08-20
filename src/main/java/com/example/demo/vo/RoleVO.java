package com.example.demo.vo;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleVO {

    private UUID id;
    private String name;

}
