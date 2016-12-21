package com.lcc.mybatis;

import java.util.List;
import com.lcc.bean.entity.RcUserRole;
import com.lcc.bean.entity.RcUserRoleExample;
import com.lcc.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface RcUserRoleMapper {
    int countByExample(RcUserRoleExample example);

    int deleteByExample(RcUserRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RcUserRole record);

    int insertSelective(RcUserRole record);

    List<RcUserRole> selectByExample(RcUserRoleExample example);

    RcUserRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RcUserRole record, @Param("example") RcUserRoleExample example);

    int updateByExample(@Param("record") RcUserRole record, @Param("example") RcUserRoleExample example);

    int updateByPrimaryKeySelective(RcUserRole record);

    int updateByPrimaryKey(RcUserRole record);
}