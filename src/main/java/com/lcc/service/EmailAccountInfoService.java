package com.lcc.service;

import com.lcc.bean.Result;
import com.lcc.bean.entity.RcEmailAccountInfo;
import com.lcc.util.base.Page;

import java.util.List;

/**
 * 邮件账号服务功能
 * Created by lcc on 2016/12/21.
 */
public interface EmailAccountInfoService {

    /**
     * 分页查询
     */
    Result<Page<RcEmailAccountInfo>> listForPage(int pageCurrent, int pageSize, String premise, String datePremise);

    /**
     * 根据id查询
     */
    Result<RcEmailAccountInfo> query(Long id);

    /**
     * 添加
     */
    Result<RcEmailAccountInfo> save(RcEmailAccountInfo info);

    /**
     * 根据id删除
     */
    Result<RcEmailAccountInfo> delete(Long id);

    /**
     * 更新
     */
    Result<RcEmailAccountInfo> update(RcEmailAccountInfo info);

    Result<List<RcEmailAccountInfo>> list();
}
