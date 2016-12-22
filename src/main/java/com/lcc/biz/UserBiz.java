package com.lcc.biz;

import java.util.List;

import com.lcc.bean.Result;
import com.lcc.bean.entity.*;
import com.lcc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserBiz {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RolePermissionsService rolePermissionsService;

    @Autowired
    private PermissionService permissionService;

    public Result<RcUser> login(String userno, String password) {
        return userService.login(userno, password);
    }

    public Result<RcUser> getUser(String userno){
        return userService.queryByUserNo(userno);
    }

    public Result<List<RcUserRole>> getUserRole(long id){
        return userRoleService.queryByUserId(id);
    }

    public Result<RcRole> getRole(long id){
        return roleService.query(id);
    }

    public Result<List<RcRolePermissions>> getRolePermissions(long id){
        return rolePermissionsService.queryByRoleId(id);
    }

    public Result<RcPermission> getPermission(long id){
        return permissionService.query(id);
    }
}
