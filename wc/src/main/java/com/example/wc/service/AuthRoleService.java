package com.example.wc.service;

import com.example.wc.mapper.AuthRoleMapper;
import com.example.wc.model.AuthRole;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthRoleService {

    @Autowired
    private AuthRoleMapper authRoleMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public AuthRole selectByPrimaryKey(String roleId){
        return authRoleMapper.selectByPrimaryKey(roleId);
    }

    public PageInfo<AuthRole> selectAll(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        redisTemplate.boundValueOps("test").set("this is ok");
        List<AuthRole> result = authRoleMapper.selectAll();
        PageInfo<AuthRole> pageInfo = new PageInfo<>(result);
        return pageInfo;
    }
}
