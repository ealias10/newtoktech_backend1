package com.example.demo.service;


import com.example.demo.dao.RoleDao;
import com.example.demo.dao.UserDao;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.modal.Users;
import com.example.demo.request.LoginRequest;
import com.example.demo.utility.GenerateJWTToken;
import com.example.demo.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserSevice {

    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;

    @Autowired
    GenerateJWTToken generateJWTToken;


    @Value("${access.token.expiry.minutes}")
    private long accessTokenExpiry;



    @Value("${spring.security.jwt.secret}")
    private String jwtSecret;




    public LoginVO createLogIn(LoginRequest request) throws UserNotFoundException {
        Users users=userDao.userExistByUserName(request.getUserName());
        if(users==null || users.getUsername()==request.getUserName())
        {
            throw new UserNotFoundException(request.getUserName());
        }
        String tocken=getAccessToken(users);
        return LoginVO.builder().accessToken(tocken).userVO(UserMapper.createUserVO(users)).build();

    }
    private String getAccessToken(Users users)
    {
        Map<String, Object> claims=new HashMap<>();
        String role=users.getRole().getName();
        claims.put("role",role);
        claims.put("name",users.getUsername());
        claims.put("sub",users.getId());
        return generateJWTToken.createJWTToken(accessTokenExpiry,claims);
    }




}
