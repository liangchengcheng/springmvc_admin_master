package com.lcc.dao;

import com.lcc.bean.entity.RcPermission;

/**
 * Created by lcc on 2016/12/21.
 */
public interface PermissionDao {

    RcPermission selectById(long id);

    int insert(RcPermission permission);

    int update(RcPermission permission);

    int deleteById(Long id);
}
