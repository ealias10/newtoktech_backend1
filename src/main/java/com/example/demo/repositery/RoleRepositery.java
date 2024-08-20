package com.example.demo.repositery;

import com.example.demo.modal.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface RoleRepositery extends JpaRepository<Role, UUID> {
    @Query("select r from Role r where r.name=:name")
    Role getRoleByName(@Param("name")String name);
}
