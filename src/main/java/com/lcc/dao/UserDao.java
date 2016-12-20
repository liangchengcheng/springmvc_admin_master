package com.lcc.dao;

import com.lcc.bean.entity.RcUser;

/**
 * Created by lcc on 2016/12/21.
 */
public interface UserDao {

    RcUser selectUser(String userno, String password);

    RcUser selectByUserNo(String userno);

    int insert(RcUser user);

    int update(RcUser user);

    int deleteById(Long id);
}
