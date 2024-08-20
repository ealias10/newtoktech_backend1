package com.example.demo.mapper;

import com.example.demo.modal.Role;
import com.example.demo.vo.RoleVO;

public class RoleMapper {

    public static RoleVO getRoleVO(Role role)
    {
        return RoleVO.builder().name(role.getName()).build();
    }

}
