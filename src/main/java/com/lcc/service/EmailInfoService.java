package com.lcc.service;

import com.lcc.bean.Result;
import com.lcc.bean.entity.RcEmailAccountInfo;
import com.lcc.bean.entity.RcEmailInfo;
import com.lcc.util.base.Page;

/**
 * Created by lcc on 2016/12/21.
 */
public interface EmailInfoService {

    /**
     * 分页获取
     */
    Result<Page<RcEmailInfo>> listForPage(int pageCurrent, int pageSize , String premise, String datePremise);

    /**
     * 根据id删除
     */
    Result<RcEmailInfo> delete(Long id);

    /**
     * 根据id查询
     */
    Result<RcEmailInfo> query(Long id);

    /**
     * 发送邮件
     */
    Result<RcEmailInfo> sendMail(RcEmailAccountInfo accountInfo, RcEmailInfo rcEmailInfo);
}
