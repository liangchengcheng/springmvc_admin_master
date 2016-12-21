package com.lcc.service;

import com.lcc.bean.Result;
import com.lcc.bean.entity.RcUserRole;

import java.util.List;

/**
 * 用户-角色Service
 * Created by lcc on 2016/12/21.
 */
public interface UserRoleService {

    Result<RcUserRole> query(long id);

    Result<List<RcUserRole>> queryByUserId(long id);

    Result<RcUserRole> queryByUserRole(RcUserRole rcUserRole);

    Result<Integer> insert(RcUserRole rcUserRole);

    Result<Integer> update(RcUserRole rcUserRole);

    Result<Integer> delete(long id);

    Result<Integer> deleteByUserRole(RcUserRole rcUserRole);
}
