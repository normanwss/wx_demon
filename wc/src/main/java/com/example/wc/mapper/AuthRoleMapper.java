package com.example.wc.mapper;

import com.example.wc.model.AuthRole;

import java.util.List;

public interface AuthRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(AuthRole record);

    int insertSelective(AuthRole record);

    AuthRole selectByPrimaryKey(String roleId);

    List<AuthRole> selectAll();

    int updateByPrimaryKeySelective(AuthRole record);

    int updateByPrimaryKey(AuthRole record);
}