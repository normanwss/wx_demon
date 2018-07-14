package com.example.wc.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户表
 */
@Data
public class User implements Serializable{

    /**
     * 名称
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 角色
     */
    private Role role;

}
