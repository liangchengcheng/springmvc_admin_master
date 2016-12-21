package com.lcc.mybatis;

import java.util.List;

import com.lcc.bean.entity.RcPermission;
import com.lcc.bean.entity.RcPermissionExample;
import com.lcc.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface RcPermissionMapper {
    int countByExample(RcPermissionExample example);

    int deleteByExample(RcPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RcPermission record);

    int insertSelective(RcPermission record);

    List<RcPermission> selectByExample(RcPermissionExample example);

    RcPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RcPermission record, @Param("example") RcPermissionExample example);

    int updateByExample(@Param("record") RcPermission record, @Param("example") RcPermissionExample example);

    int updateByPrimaryKeySelective(RcPermission record);

    int updateByPrimaryKey(RcPermission record);
}