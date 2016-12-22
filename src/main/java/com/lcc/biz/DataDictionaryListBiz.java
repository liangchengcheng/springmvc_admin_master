package com.lcc.biz;

import com.lcc.bean.Result;
import com.lcc.bean.entity.RcDataDictionaryList;
import com.lcc.service.DataDictionaryListService;
import com.lcc.util.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * 数据字典明细逻辑功能
 */
@Component
public class DataDictionaryListBiz {

    @Autowired
    private DataDictionaryListService dictionaryListService;

    /**
     * 分页查询
     */
    public Result<Page<RcDataDictionaryList>> listForPage(int pageCurrent, int pageSize, String fieldCode, String premise, String datePremise) {
        return dictionaryListService.listForPage(pageCurrent, pageSize, fieldCode,premise,datePremise);
    }

    /**
     * 根据id删除
     */
    public Result<String> delete(Long id) {
        return dictionaryListService.delete(id);
    }

    /**
     * 添加
     */
    public Result<RcDataDictionaryList> save(RcDataDictionaryList dList) {
        return dictionaryListService.save(dList);
    }

    /**
     * 根据id获取
     */
    public Result<RcDataDictionaryList> query(Long id) {
        return dictionaryListService.query(id);
    }

    /**
     * 更新
     */
    public Result<RcDataDictionaryList> update(RcDataDictionaryList dList) {
        return dictionaryListService.update(dList);
    }

}
