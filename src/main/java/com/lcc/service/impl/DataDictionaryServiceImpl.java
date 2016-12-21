package com.lcc.service.impl;

import com.lcc.bean.Result;
import com.lcc.bean.entity.RcDataDictionary;
import com.lcc.dao.DataDictionaryDao;
import com.lcc.service.DataDictionaryService;
import com.lcc.util.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 数据字典
 */
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

    @Autowired
    private DataDictionaryDao dao;

    @Override
    public Result<RcDataDictionary> save(RcDataDictionary rcDataDictionary) {
        Result<RcDataDictionary> result = new Result<RcDataDictionary>();
        // 校验字段
        if (!StringUtils.hasText(rcDataDictionary.getFieldName())) {
            result.setErrMsg("fieldname不能为空");
            return result;
        }
        if (!StringUtils.hasText(rcDataDictionary.getFieldCode())) {
            result.setErrMsg("fieldcode不能为空");
            return result;
        }
        if (StringUtils.isEmpty(rcDataDictionary.getSort())) {
            result.setErrMsg("sort不能为空");
            return result;
        }
        if (dao.selectByFieldCode(rcDataDictionary.getFieldCode()) != null) {
            result.setErrMsg("FieldCode已经存在");
            return result;
        }
        if (dao.insert(rcDataDictionary) > 0) {
            result.setStatus(true);
            result.setErrCode(0);
        }
        return result;

    }

    @Override
    public Result<Page<RcDataDictionary>> listForPage(int pageCurrent, int pageSize, String premise, String datePremise) {
        Result<Page<RcDataDictionary>> result = new Result<Page<RcDataDictionary>>();
        if (pageCurrent < 1) {
            result.setErrMsg("参数pageCurrent有误,pageCurrent=" + pageCurrent);
            return result;
        }
        if (pageSize < 1) {
            result.setErrMsg("参数pageSize有误,pageSize=" + pageSize);
            return result;
        }
        Page<RcDataDictionary> resultData = dao.listForPage(pageCurrent, pageSize, premise, datePremise);
        result.setResultData(resultData);
        result.setStatus(true);
        result.setErrCode(0);
        return result;
    }

    @Override
    public Result<RcDataDictionary> query(Long id) {
        Result<RcDataDictionary> result = new Result<RcDataDictionary>();
        if (id < 1) {
            result.setErrMsg("此操作的id：" + id + "为无效id");
            return result;
        }
        RcDataDictionary resultData = dao.selectById(id);
        result.setStatus(true);
        result.setErrCode(0);
        result.setResultData(resultData);
        return result;
    }

    @Override
    public Result<String> delete(Long id) {
        Result<String> result = new Result<String>();
        if (id < 1) {
            result.setErrMsg("此操作的id：" + id + "为无效id");
            return result;
        }
        if (dao.deleteById(id) > 0) {
            result.setStatus(true);
            result.setErrCode(0);
        }
        return result;
    }

    @Override
    public Result<RcDataDictionary> update(RcDataDictionary rcDataDictionary) {
        Result<RcDataDictionary> result = new Result<RcDataDictionary>();
        if (!StringUtils.hasText(rcDataDictionary.getFieldName())) {
            result.setErrMsg("fieldname不能为空");
            return result;
        }
        if (!StringUtils.hasText(rcDataDictionary.getFieldCode())) {
            result.setErrMsg("fieldcode不能为空");
            return result;
        }
        if (StringUtils.isEmpty(rcDataDictionary.getSort())) {
            result.setErrMsg("sort不能为空");
            return result;
        }
        if (dao.updateById(rcDataDictionary) > 0) {
            result.setStatus(true);
            result.setErrCode(0);
        }
        return result;
    }
}
