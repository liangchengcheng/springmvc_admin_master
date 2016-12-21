package com.lcc.dao.impl;


import java.util.Date;
import java.util.List;

import com.lcc.bean.entity.RcDataDictionary;
import com.lcc.bean.entity.RcDataDictionaryExample;
import com.lcc.dao.DataDictionaryDao;
import com.lcc.mybatis.RcDataDictionaryMapper;
import com.lcc.util.DateUtil;
import com.lcc.util.base.Page;
import com.lcc.util.base.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;


@Repository
public class DataDictionaryDaoImpl implements DataDictionaryDao {

    @Autowired
    private RcDataDictionaryMapper mapper;

    @Override
    public int insert(RcDataDictionary rcDataDictionary) {
        rcDataDictionary.setStatusId("1");
        rcDataDictionary.setCreateTime(new Date());
        rcDataDictionary.setUpdateTime(new Date());
        return mapper.insertSelective(rcDataDictionary);
    }

    @Override
    public Page<RcDataDictionary> listForPage(int pageCurrent, int pageSize, String premise, String datePremise) {
        RcDataDictionaryExample example = new RcDataDictionaryExample();
        example.setOrderByClause("sort asc");

        RcDataDictionaryExample.Criteria criteria = example.createCriteria();
        if (StringUtils.hasText(premise)) {
            criteria.andFieldNameLike(SqlUtil.like(premise));
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

        List<RcDataDictionary> list = mapper.selectByExample(example);
        Page<RcDataDictionary> page = new Page<>(totalCount, totalPage, pageCurrent, pageSize, list);
        return page;
    }

    @Override
    public RcDataDictionary selectById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateById(RcDataDictionary dictionary) {
        dictionary.setUpdateTime(new Date());
        return mapper.updateByPrimaryKeySelective(dictionary);
    }

    @Override
    public RcDataDictionary selectByFieldCode(String FieldCode) {
        RcDataDictionaryExample example = new RcDataDictionaryExample();
        RcDataDictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andFieldCodeEqualTo(FieldCode);
        List<RcDataDictionary> resultList = mapper.selectByExample(example);
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }
}
