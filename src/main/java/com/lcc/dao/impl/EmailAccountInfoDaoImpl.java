package com.lcc.dao.impl;


import java.util.Date;
import java.util.List;

import com.lcc.bean.entity.RcEmailAccountInfo;
import com.lcc.bean.entity.RcEmailAccountInfoExample;
import com.lcc.dao.EmailAccountInfoDao;
import com.lcc.mybatis.RcEmailAccountInfoMapper;
import com.lcc.util.Base64Util;
import com.lcc.util.DateUtil;
import com.lcc.util.base.Page;
import com.lcc.util.base.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class EmailAccountInfoDaoImpl implements EmailAccountInfoDao {

    @Autowired
    private RcEmailAccountInfoMapper mapper;

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RcEmailAccountInfo info) {
        String passwd = Base64Util.encrypt(info.getPasswd());
        info.setPasswd(passwd);
        Date date = new Date();
        info.setCreateTime(date);
        info.setUpdateTime(date);
        return mapper.insertSelective(info);
    }

    @Override
    public Page<RcEmailAccountInfo> listForPage(int pageCurrent, int pageSize, String premise, String datePremise) {
        RcEmailAccountInfoExample example = new RcEmailAccountInfoExample();
        example.setOrderByClause("id desc");
        RcEmailAccountInfoExample.Criteria criteria = example.createCriteria();
        if (StringUtils.hasText(premise)) {
            criteria.andFromUserLike(SqlUtil.like(premise));
        }
        if (StringUtils.hasText(datePremise)) {
            criteria.andCreateTimeBetween(DateUtil.parseDate(datePremise), DateUtil.addDate(DateUtil.parseDate(datePremise), 1));
        }
        int totalCount = mapper.countByExample(example);
        pageSize = SqlUtil.checkPageSize(pageSize);
        pageCurrent = SqlUtil.checkPageCurrent(totalCount, pageSize, pageCurrent);
        int totalPage = SqlUtil.countTotalPage(totalCount, pageSize);
        example.setLimitStart(SqlUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);

        List<RcEmailAccountInfo> list = mapper.selectByExample(example);
        Page<RcEmailAccountInfo> page = new Page<>(totalCount, totalPage, pageCurrent, pageSize, list);
        return page;
    }

    @Override
    public RcEmailAccountInfo selectById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(RcEmailAccountInfo info) {
        String passwd = Base64Util.encrypt(info.getPasswd());
        info.setPasswd(passwd);
        info.setUpdateTime(new Date());
        return mapper.updateByPrimaryKeySelective(info);
    }

    @Override
    public List<RcEmailAccountInfo> list() {
        RcEmailAccountInfoExample example = new RcEmailAccountInfoExample();
        example.setOrderByClause("id desc");
        return mapper.selectByExample(example);
    }
}
