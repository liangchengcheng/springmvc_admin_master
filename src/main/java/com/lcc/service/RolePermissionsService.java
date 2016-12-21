package com.lcc.service;

import com.lcc.bean.Result;
import com.lcc.bean.entity.RcRolePermissions;

import java.util.List;

/**
 * 角色-权限Service
 */
public interface RolePermissionsService {
    Result<RcRolePermissions> query(long id);

    Result<List<RcRolePermissions>> queryByRoleId(long id);

    Result<Integer> insert(RcRolePermissions rcRolePermissions);

    Result<Integer> update(RcRolePermissions rcRolePermissions);

    Result<Integer> delete(long id);

    Result<Integer> deleteByRolePermissions(RcRolePermissions rcRolePermissions);
}
