package com.lcc.dao.impl;


import java.util.Date;
import java.util.List;

import com.lcc.bean.entity.RcRolePermissions;
import com.lcc.bean.entity.RcRolePermissionsExample;
import com.lcc.dao.RolePermissionsDao;
import com.lcc.mybatis.RcRolePermissionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RolePermissionsDaoImpl implements RolePermissionsDao {

    @Autowired
    private RcRolePermissionsMapper mapper;

    @Override
    public List<RcRolePermissions> selectByRoleId(long id) {
        RcRolePermissionsExample example = new RcRolePermissionsExample();
        RcRolePermissionsExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(id);
        return mapper.selectByExample(example);
    }

    @Override
    public int insert(RcRolePermissions rcRolePermissions) {
        Date date = new Date();
        rcRolePermissions.setCreateTime(date);
        rcRolePermissions.setUpdateTime(date);
        return mapper.insertSelective(rcRolePermissions);
    }

    @Override
    public int update(RcRolePermissions rcRolePermissions) {
        rcRolePermissions.setUpdateTime(new Date());
        return mapper.updateByPrimaryKeySelective(rcRolePermissions);
    }

    @Override
    public int delectByRolePermissions(RcRolePermissions rcRolePermissions) {
        RcRolePermissionsExample example = new RcRolePermissionsExample();
        RcRolePermissionsExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(rcRolePermissions.getRoleId());
        criteria.andPermissionIdEqualTo(rcRolePermissions.getPermissionId());
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public RcRolePermissions selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }

}
