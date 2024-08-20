package com.example.demo.request;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersRequest {

    private String name;

    private String password;

    private String role;
}
