package com.lcc.mybatis;

import java.util.List;

import com.lcc.bean.entity.RcEmailAccountInfo;
import com.lcc.bean.entity.RcEmailAccountInfoExample;
import com.lcc.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface RcEmailAccountInfoMapper {
    int countByExample(RcEmailAccountInfoExample example);

    int deleteByExample(RcEmailAccountInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RcEmailAccountInfo record);

    int insertSelective(RcEmailAccountInfo record);

    List<RcEmailAccountInfo> selectByExample(RcEmailAccountInfoExample example);

    RcEmailAccountInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RcEmailAccountInfo record, @Param("example") RcEmailAccountInfoExample example);

    int updateByExample(@Param("record") RcEmailAccountInfo record, @Param("example") RcEmailAccountInfoExample example);

    int updateByPrimaryKeySelective(RcEmailAccountInfo record);

    int updateByPrimaryKey(RcEmailAccountInfo record);
}
