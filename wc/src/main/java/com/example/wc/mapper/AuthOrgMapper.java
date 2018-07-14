package com.example.wc.mapper;

import com.example.wc.model.AuthOrg;

public interface AuthOrgMapper {
    int deleteByPrimaryKey(Integer orgId);

    int insert(AuthOrg record);

    int insertSelective(AuthOrg record);

    AuthOrg selectByPrimaryKey(Integer orgId);

    int updateByPrimaryKeySelective(AuthOrg record);

    int updateByPrimaryKey(AuthOrg record);
}