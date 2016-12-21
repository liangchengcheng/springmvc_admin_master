package com.lcc.dao.impl;

import java.util.Date;
import java.util.List;

import com.lcc.bean.entity.RcEmailInfo;
import com.lcc.bean.entity.RcEmailInfoExample;
import com.lcc.dao.EmailInfoDao;
import com.lcc.mybatis.RcEmailInfoMapper;
import com.lcc.util.DateUtil;
import com.lcc.util.base.Page;
import com.lcc.util.base.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class EmailInfoDaoImpl implements EmailInfoDao {

    @Autowired
    private RcEmailInfoMapper mapper;

    @Override
    public int insert(RcEmailInfo rcEmailInfo) {
        rcEmailInfo.setStatusId("1");
        rcEmailInfo.setCreateTime(new Date());
        rcEmailInfo.setUpdateTime(new Date());
        return mapper.insert(rcEmailInfo);
    }

    @Override
    public Page<RcEmailInfo> listForPage(int pageCurrent, int pageSize, String premise, String datePremise) {
        RcEmailInfoExample example = new RcEmailInfoExample();
        example.setOrderByClause(" id desc ");

        RcEmailInfoExample.Criteria criteria = example.createCriteria();
        if(StringUtils.hasText(premise)){
            criteria.andToUserLike(SqlUtil.like(premise));
        }
        if(StringUtils.hasText(datePremise)){
            criteria.andCreateTimeBetween(DateUtil.parseDate(datePremise), DateUtil.addDate(DateUtil.parseDate(datePremise), 1));
        }

        int count = mapper.countByExample(example);
        pageSize = SqlUtil.checkPageSize(pageSize);
        pageCurrent = SqlUtil.checkPageCurrent(count, pageSize, pageCurrent);
        int totalPage = SqlUtil.countTotalPage(count, pageSize);

        example.setLimitStart(SqlUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);


        List<RcEmailInfo> list = mapper.selectByExample(example);
        return new Page<RcEmailInfo>(count, totalPage, pageCurrent, pageSize, list);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public RcEmailInfo selectById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

}