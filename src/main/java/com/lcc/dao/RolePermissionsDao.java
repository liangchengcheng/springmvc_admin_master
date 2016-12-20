package com.lcc.dao;

import com.lcc.bean.entity.RcRolePermissions;

import java.util.List;

/**
 * Created by lcc on 2016/12/21.
 */
public interface RolePermissionsDao {

    RcRolePermissions selectById(long id);

    List<RcRolePermissions> selectByRoleId(long id);

    int insert(RcRolePermissions rcRolePermissions);

    int update(RcRolePermissions rcRolePermissions);

    int delectByRolePermissions(RcRolePermissions rcRolePermissions);

    int deleteById(Long id);
}
