package com.example.demo.repositery;

import com.example.demo.modal.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UserRepositery extends JpaRepository<Users, UUID> {

    @Query("select u from Users u where u.username=:name")
    Users user(@Param("name")String name);
}
