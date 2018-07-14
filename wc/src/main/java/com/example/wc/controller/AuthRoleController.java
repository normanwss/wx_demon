package com.example.wc.controller;

import com.example.wc.entity.result.WcFailure;
import com.example.wc.model.AuthRole;
import com.example.wc.service.AuthRoleService;
import com.example.wc.utils.result.IResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class AuthRoleController {

    @Autowired
    private AuthRoleService authRoleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public AuthRole findOneCity() {
        String roleId = "ROLE_ADMIN";
        return authRoleService.selectByPrimaryKey(roleId);
    }

    @RequestMapping(value = "/roleAll/{pageSize}/{pageNum}", method = RequestMethod.GET)
    public PageInfo<AuthRole> selectAll(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return authRoleService.selectAll(pageNum, pageSize);
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public IResult save(){
        return WcFailure.USER_SERVER_ERROR.setArgs(new Object[]{"报错了"});
    }
}
