package com.lcc.biz;


import com.lcc.bean.Result;
import com.lcc.bean.entity.RcDataDictionary;
import com.lcc.service.DataDictionaryListService;
import com.lcc.service.DataDictionaryService;
import com.lcc.util.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 数据字典逻辑业务类
 */
@Component
public class DataDictionaryBiz {

    @Autowired
    private DataDictionaryService dictionaryService;

    @Autowired
    private DataDictionaryListService dictionaryListService;

    /**
     * 分页查询
     */
    public Result<Page<RcDataDictionary>> listForPage(int pageCurrent, int pageSize, String premise, String datePremise) {
        return dictionaryService.listForPage(pageCurrent, pageSize, premise, datePremise);
    }

    /**
     * 添加
     */
    public Result<RcDataDictionary> save(RcDataDictionary rcDataDictionary) {
        return dictionaryService.save(rcDataDictionary);
    }

    /**
     * 删除
     */
    @Transactional
    public Result<String> delete(Long id, String fieldCode) {
        if (dictionaryListService.deleteByFieldCode(fieldCode).isStatus()) {
            return dictionaryService.delete(id);
        }
        return null;
    }

    /**
     * 根据id查询
     */
    public Result<RcDataDictionary> query(Long id) {
        return dictionaryService.query(id);
    }

    /**
     * 更新
     */
    @Transactional
    public Result<RcDataDictionary> update(RcDataDictionary dictionary, String oldFieldCode) {
        Result<RcDataDictionary> result = dictionaryService.update(dictionary);
        if (result.isStatus()) {
            if (!oldFieldCode.equals(dictionary.getFieldCode())) {
                dictionaryListService.updateByFieldCode(oldFieldCode, dictionary.getFieldCode());
            }
        }
        return result;
    }
}
