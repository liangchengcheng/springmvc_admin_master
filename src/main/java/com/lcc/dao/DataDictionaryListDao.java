package com.lcc.dao;

import com.lcc.bean.entity.RcDataDictionaryList;
import com.lcc.util.base.Page;

import java.util.List;

/**
 * Created by lcc on 2016/12/21.
 */
public interface DataDictionaryListDao {
    /**
     * 功能：根据条件删除
     */
    int deleteByFieldCode(String FieldCode);

    /**
     * 功能：根据id删除
     */
    int deleteById(Long id);

    /**
     * 功能：添加
     */
    int insert(RcDataDictionaryList dList);


    /**
     * 分页查询
     */
    Page<RcDataDictionaryList> listForPage(int pageCurrent, int pageSize, String fieldCode, String premise, String datePremise);

    /**
     * 功能：根据id查询
     */
    RcDataDictionaryList selectById(Long id);

    /**
     * 功能：更新
     */
    int updateById(RcDataDictionaryList dList);

    /**
     * 根据fieldCode查询
     */
    List<RcDataDictionaryList> listByFieldCode(String fieldCode);

    /**
     * 根据fieldCode更新
     */
    int updateByFieldCode(String fieldCodePremise,String fieldCode);
}
