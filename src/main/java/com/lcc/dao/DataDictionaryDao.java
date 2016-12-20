package com.lcc.dao;

import com.lcc.bean.entity.RcDataDictionary;
import com.lcc.util.base.Page;

/**
 * 数据字典数据交换功能
 * Created by lcc on 2016/12/21.
 */
public interface DataDictionaryDao {
    /**
     * 添加
     */
    int insert(RcDataDictionary rcDataDictionary);

    /**
     * 分页查询
     */
    Page<RcDataDictionary> listForPage(int pageCurrent, int pageSize, String premise, String datePremise);

    /**
     * 根据id查询
     */
    RcDataDictionary selectById(Long id);

    /**
     * 根据id删除
     */
    int deleteById(Long id);

    /**
     * 更新
     */
    int updateById(RcDataDictionary dictionary);

    /**
     * 根据FieldCode查询
     */
    RcDataDictionary selectByFieldCode(String FieldCode);
}
