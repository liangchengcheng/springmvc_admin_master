package com.lcc.mybatis;

import java.util.List;

import com.lcc.bean.entity.RcRolePermissions;
import com.lcc.bean.entity.RcRolePermissionsExample;
import com.lcc.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface RcRolePermissionsMapper {
    int countByExample(RcRolePermissionsExample example);

    int deleteByExample(RcRolePermissionsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RcRolePermissions record);

    int insertSelective(RcRolePermissions record);

    List<RcRolePermissions> selectByExample(RcRolePermissionsExample example);

    RcRolePermissions selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RcRolePermissions record, @Param("example") RcRolePermissionsExample example);

    int updateByExample(@Param("record") RcRolePermissions record, @Param("example") RcRolePermissionsExample example);

    int updateByPrimaryKeySelective(RcRolePermissions record);

    int updateByPrimaryKey(RcRolePermissions record);
}