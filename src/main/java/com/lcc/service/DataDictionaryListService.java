package com.lcc.service;

import com.lcc.bean.Result;
import com.lcc.bean.entity.RcDataDictionaryList;
import com.lcc.util.base.Page;

import java.util.List;

/**
 * 数据字典明细服务功能
 * Created by lcc on 2016/12/21.
 */
public interface DataDictionaryListService {

    /**
     * 分页查询
     */
    Result<Page<RcDataDictionaryList>> listForPage(int pageCurrent, int pageSize, String fieldCode, String premise, String datePremise);

    /**
     * 添加记录
     */
    Result<RcDataDictionaryList> save(RcDataDictionaryList dList);

    /**
     * 根据id删除
     */
    Result<String> delete(Long id);

    /**
     * 删除
     */
    Result<String> deleteByFieldCode(String fieldCode);

    /**
     * 根据fieldCode查询
     */
    Result<List<RcDataDictionaryList>> listByFieldCode(String fieldCode);

    /**
     * 根据id查询
     */
    Result<RcDataDictionaryList> query(Long id);

    /**
     * 更新
     */
    Result<RcDataDictionaryList> update(RcDataDictionaryList dList);

    /**
     * 根据fieldCode更新
     */
    Result<String> updateByFieldCode(String fieldCodePremise,String fieldCode);
}
