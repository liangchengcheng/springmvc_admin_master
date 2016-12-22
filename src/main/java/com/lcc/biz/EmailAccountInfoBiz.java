package com.lcc.biz;


import java.util.List;

import com.lcc.bean.Result;
import com.lcc.bean.entity.RcDataDictionaryList;
import com.lcc.bean.entity.RcEmailAccountInfo;
import com.lcc.service.DataDictionaryListService;
import com.lcc.service.EmailAccountInfoService;
import com.lcc.util.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * 邮件账号逻辑功能
 */
@Component
public class EmailAccountInfoBiz {

    @Autowired
    private EmailAccountInfoService emailAccountInfoService;

    @Autowired
    private DataDictionaryListService dictionaryListService;

    /**
     * 分页查询
     *
     * @param pageCurrent
     * @param pageSize
     * @return
     */
    public Result<Page<RcEmailAccountInfo>> listForPage(int pageCurrent, int pageSize, String premise, String datePremise) {
        return emailAccountInfoService.listForPage(pageCurrent, pageSize,premise,datePremise);
    }

    /**
     * 添加
     */
    public Result<RcEmailAccountInfo> save(RcEmailAccountInfo info) {
        return emailAccountInfoService.save(info);
    }

    /**
     * 根据id删除
     */
    public Result<RcEmailAccountInfo> delete(Long id) {
        return emailAccountInfoService.delete(id);
    }

    /**
     * 根据id查询
     */
    public Result<RcEmailAccountInfo> query(Long id) {
        return emailAccountInfoService.query(id);
    }

    /**
     * 更新
     */
    public Result<RcEmailAccountInfo> update(RcEmailAccountInfo info) {
        return emailAccountInfoService.update(info);
    }

    /**
     * 获取下拉选项
     */
    public Result<List<RcDataDictionaryList>> listByFieldCode(String fieldCode) {
        return dictionaryListService.listByFieldCode(fieldCode);
    }

}
