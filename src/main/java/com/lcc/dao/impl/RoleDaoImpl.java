package com.lcc.dao.impl;

import java.util.Date;

import com.lcc.bean.entity.RcRole;
import com.lcc.dao.RoleDao;
import com.lcc.mybatis.RcRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private RcRoleMapper mapper;

    @Override
    public RcRole selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(RcRole rcRole) {
        Date date = new Date();
        rcRole.setCreateTime(date);
        rcRole.setUpdateTime(date);
        return mapper.insertSelective(rcRole);
    }

    @Override
    public int update(RcRole rcRole) {
        rcRole.setUpdateTime(new Date());
        return mapper.updateByPrimaryKeySelective(rcRole);
    }

    @Override
    public int deleteById(long id) {
        return mapper.deleteByPrimaryKey(id);
    }

}
