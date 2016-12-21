package com.lcc.dao.impl;

import java.util.Date;
import java.util.List;

import com.lcc.bean.entity.RcUserRole;
import com.lcc.bean.entity.RcUserRoleExample;
import com.lcc.dao.UserRoleDao;
import com.lcc.mybatis.RcUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {

    @Autowired
    private RcUserRoleMapper mapper;

    @Override
    public List<RcUserRole> selectByUserId(long id) {
        RcUserRoleExample example = new RcUserRoleExample();
        RcUserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(id);
        return mapper.selectByExample(example);
    }

    @Override
    public int insert(RcUserRole rcUserRole) {
        Date date = new Date();
        rcUserRole.setCreateTime(date);
        rcUserRole.setUpdateTime(date);
        return mapper.insertSelective(rcUserRole);
    }

    @Override
    public int update(RcUserRole rcUserRole) {
        rcUserRole.setUpdateTime(new Date());
        return mapper.updateByPrimaryKeySelective(rcUserRole);
    }

    @Override
    public int delectByRcUserRole(RcUserRole rcUserRole) {
        RcUserRoleExample example = new RcUserRoleExample();
        RcUserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(rcUserRole.getUserId());
        criteria.andRolesIdEqualTo(rcUserRole.getRolesId());
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteById(long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public RcUserRole selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public RcUserRole selectByUserRole(RcUserRole rcUserRole) {
        RcUserRoleExample example = new RcUserRoleExample();
        RcUserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(rcUserRole.getUserId());
        criteria.andRolesIdEqualTo(rcUserRole.getRolesId());
        List<RcUserRole> resultList = mapper.selectByExample(example);
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }

}
