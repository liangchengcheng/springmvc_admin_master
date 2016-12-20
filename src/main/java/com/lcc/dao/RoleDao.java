package com.lcc.dao;

import com.lcc.bean.entity.RcRole;

/**
 * Created by lcc on 2016/12/21.
 */
public interface RoleDao {

    RcRole selectById(long id);

    int insert(RcRole role);

    int update(RcRole role);

    int deleteById(long id);
}
