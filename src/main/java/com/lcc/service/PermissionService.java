package com.lcc.service;

import com.lcc.bean.Result;
import com.lcc.bean.entity.RcPermission;

/**
 * 权限Service
 */
public interface PermissionService {

    Result<RcPermission> query(long id);

    Result<Integer> insert(RcPermission rcPermission);

    Result<Integer> update(RcPermission rcPermission);

    Result<Integer> delete(long id);
}
