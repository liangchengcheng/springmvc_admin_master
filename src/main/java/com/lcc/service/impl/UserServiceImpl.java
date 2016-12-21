package com.lcc.service.impl;

import com.lcc.bean.Result;
import com.lcc.bean.entity.RcUser;
import com.lcc.dao.UserDao;
import com.lcc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    @Override
    public Result<RcUser> login(String userno, String password) {
        Result<RcUser> result = new Result<>();
        if (!StringUtils.hasText(userno)) {
            result.setErrMsg("账号不能为空");
            return result;
        }

        if (!StringUtils.hasText(password)) {
            result.setErrMsg("密码不能为空");
            return result;
        }

        RcUser user = dao.selectUser(userno, password);
        if (user != null) {
            result.setErrCode(0);
            result.setStatus(true);
            result.setResultData(user);
        }
        return result;
    }

    @Override
    public Result<RcUser> queryByUserNo(String userno) {
        Result<RcUser> result = new Result<RcUser>();
        if (!StringUtils.hasText(userno)) {
            result.setErrMsg("账号不能为空");
            return result;
        }

        RcUser user = dao.selectByUserNo(userno);
        if (user != null) {
            result.setErrCode(0);
            result.setStatus(true);
            result.setResultData(user);
        }
        return result;
    }

    @Override
    public Result<Integer> insert(RcUser rcUser) {
        Result<Integer> result = new Result<Integer>();
        if (!StringUtils.hasText(rcUser.getUserNo())) {
            result.setErrMsg("账号不能为空");
        }
        if (!StringUtils.hasText(rcUser.getPassword())) {
            result.setErrMsg("密码不能为空");
        }

        int resultNum = dao.insert(rcUser);
        if (resultNum > 0 ){
            result.setErrCode(0);
            result.setStatus(true);
        }
        return result;
    }

    @Override
    public Result<Integer> update(RcUser rcUser) {
        Result<Integer> result = new Result<Integer>();
        int resultNum = dao.update(rcUser);
        if (resultNum > 0) {
            result.setErrCode(0);
            result.setStatus(true);
        }
        return result;
    }

    @Override
    public Result<Integer> delete(long id) {
        Result<Integer> result = new Result<Integer>();
        if (id < 0) {
            result.setErrMsg("此id无效");
            return result;
        }
        int resultNum = dao.deleteById(id);
        if (resultNum > 0) {
            result.setErrCode(0);
            result.setStatus(true);
        }
        return result;
    }
}
