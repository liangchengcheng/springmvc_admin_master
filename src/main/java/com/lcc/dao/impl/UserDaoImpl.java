package com.lcc.dao.impl;


import java.util.Date;
import java.util.List;

import com.lcc.bean.entity.RcUser;
import com.lcc.bean.entity.RcUserExample;
import com.lcc.dao.UserDao;
import com.lcc.mybatis.RcUserMapper;
import com.lcc.util.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private RcUserMapper mapper;

    @Override
    public RcUser selectUser(String userno, String password) {
        RcUserExample example = new RcUserExample();
        RcUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNoEqualTo(userno);
        criteria.andPasswordEqualTo(Base64Util.encrypt(password));
        List<RcUser> result = mapper.selectByExample(example);
        if (result.size() > 0) {
            RcUser user = result.get(0);
            user.setPassword(password);
            return user;
        }
        return null;
    }

    @Override
    public RcUser selectByUserNo(String userno) {
        RcUserExample example = new RcUserExample();
        RcUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNoEqualTo(userno);
        List<RcUser> result = mapper.selectByExample(example);
        if (result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public int insert(RcUser rcUser) {
        Date date = new Date();
        String password = Base64Util.encrypt(rcUser.getPassword());
        rcUser.setPassword(password);
        rcUser.setCreateTime(date);
        rcUser.setUpdateTime(date);
        return mapper.insertSelective(rcUser);
    }

    @Override
    public int update(RcUser rcUser) {
        rcUser.setUpdateTime(new Date());
        return mapper.updateByPrimaryKeySelective(rcUser);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

}
