package com.lcc.dao.impl;


import java.util.Date;

import com.lcc.bean.entity.RcPermission;
import com.lcc.dao.PermissionDao;
import com.lcc.mybatis.RcPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PermissionDaoImpl implements PermissionDao {

    @Autowired
    private RcPermissionMapper mapper;

    @Override
    public RcPermission selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(RcPermission rcPermission) {
        Date date = new Date();
        rcPermission.setCreateTime(date);
        rcPermission.setUpdateTime(date);
        return mapper.insertSelective(rcPermission);
    }

    @Override
    public int update(RcPermission rcPermission) {
        rcPermission.setUpdateTime(new Date());
        return mapper.updateByPrimaryKeySelective(rcPermission);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

}
