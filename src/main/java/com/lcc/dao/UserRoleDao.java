package com.lcc.dao;

import com.lcc.bean.entity.RcUserRole;

import java.util.List;

/**
 * Created by lcc on 2016/12/21.
 */
public interface UserRoleDao {

    RcUserRole selectById(long id);

    List<RcUserRole> selectByUserId(long id);

    RcUserRole selectByUserRole(RcUserRole rcUserRole);

    int insert(RcUserRole rcUserRole);

    int update(RcUserRole rcUserRole);

    int delectByRcUserRole(RcUserRole rcUserRole);

    int deleteById(long id);
}
