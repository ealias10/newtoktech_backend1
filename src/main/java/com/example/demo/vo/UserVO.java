package com.example.demo.vo;

import lombok.*;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {


    private UUID id;

    private String name;

    private String  role;
}
