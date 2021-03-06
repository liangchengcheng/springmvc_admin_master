package com.lcc.mybatis;

import java.util.List;
import com.lcc.bean.entity.RcUser;
import com.lcc.bean.entity.RcUserExample;
import com.lcc.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface RcUserMapper {
    int countByExample(RcUserExample example);

    int deleteByExample(RcUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RcUser record);

    int insertSelective(RcUser record);

    List<RcUser> selectByExample(RcUserExample example);

    RcUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RcUser record, @Param("example") RcUserExample example);

    int updateByExample(@Param("record") RcUser record, @Param("example") RcUserExample example);

    int updateByPrimaryKeySelective(RcUser record);

    int updateByPrimaryKey(RcUser record);
}