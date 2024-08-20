package com.example.demo.dao;


import com.example.demo.repositery.UserRepositery;
import com.example.demo.modal.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserDao {

    @Autowired
    UserRepositery userRepositery;



    public Users userExistByUserName(String name)
    {
        return userRepositery.user(name);
    }

}
