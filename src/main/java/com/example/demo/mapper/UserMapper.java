package com.example.demo.mapper;


import com.example.demo.modal.Users;
import com.example.demo.vo.LoginVO;
import com.example.demo.vo.UserVO;

public class UserMapper {

    public static LoginVO createLoginVO(String accessToken) {
        return LoginVO.builder()
                .accessToken(accessToken)
                .build();
    }
    public static UserVO createUserVO(Users users)
    {
        return UserVO.builder().role(users.getRole().getName()).name(users.getUsername()).build();
    }
}
