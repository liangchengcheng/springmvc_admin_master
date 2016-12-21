package com.lcc.service;

import com.lcc.bean.Result;
import com.lcc.bean.entity.RcDataDictionary;
import com.lcc.util.base.Page;

/**
 * 数据字典业务功能
 * Created by lcc on 2016/12/21.
 */
public interface DataDictionaryService {

    /**
     * 添加
     */
    Result<RcDataDictionary> save(RcDataDictionary rcDataDictionary);

    /**
     * 分页查询
     */
    Result<Page<RcDataDictionary>> listForPage(int pageCurrent, int pageSize, String premise, String datePremise);

    /**
     * 根据id查询
     */
    Result<RcDataDictionary> query(Long id);

    /**
     * 根据id进行删除
     */
    Result<String> delete(Long id);

    /**
     * 更新
     */
    Result<RcDataDictionary> update(RcDataDictionary dictionary);
}
