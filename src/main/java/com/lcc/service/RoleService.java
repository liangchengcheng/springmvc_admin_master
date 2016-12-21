package com.lcc.service;

/**
 * Created by lcc on 2016/12/21.
 */

import com.lcc.bean.Result;
import com.lcc.bean.entity.RcRole;

/**
 * 角色Service
 */
public interface RoleService {

    Result<RcRole> query(long id);

    Result<Integer> insert(RcRole rcRole);

    Result<Integer> update(RcRole rcRole);

    Result<Integer> delete(long id);
}
