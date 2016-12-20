package com.lcc.dao;

import com.lcc.bean.entity.RcEmailInfo;
import com.lcc.util.base.Page;

/**
 * Created by lcc on 2016/12/21.
 */
public interface EmailInfoDao {

    /**
     * 添加记录
     */
    int insert(RcEmailInfo rcEmailInfo);

    /**
     * 分页查询
     */
    Page<RcEmailInfo> listForPage(int pageCurrent, int pageSize, String premise, String datePremise);

    /**
     * 根据id删除
     */
    int deleteById(Long id);

    /**
     * 根据id查询
     */
    RcEmailInfo selectById(Long id);
}
