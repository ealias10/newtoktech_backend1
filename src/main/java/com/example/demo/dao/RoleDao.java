package com.example.demo.dao;


import com.example.demo.modal.Role;
import com.example.demo.repositery.RoleRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao {
    @Autowired
    RoleRepositery roleRepositery;

    public Role getRoleByName(String name)
    {
        return roleRepositery.getRoleByName(name);
    }

    public Role createRole(Role role)
    {
       return roleRepositery.save(role);
    }
}
