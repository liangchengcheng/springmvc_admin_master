package com.lcc.service;

import com.lcc.bean.Result;
import com.lcc.bean.entity.RcUser;

/**
 * 用户Service
 *
 */
public interface UserService {

    Result<RcUser> login(String userno, String password);

    Result<RcUser> queryByUserNo(String userno);

    Result<Integer> insert(RcUser rcUser);

    Result<Integer> update(RcUser rcUser);

    Result<Integer> delete(long id);
}