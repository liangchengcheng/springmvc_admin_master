package com.lcc.dao;

import com.lcc.bean.entity.RcEmailAccountInfo;
import com.lcc.util.base.Page;

import java.util.List;

/**
 * Created by lcc on 2016/12/21.
 */
public interface EmailAccountInfoDao {
    /**
     * 根据id删除
     */
    int deleteById(Long id);

    /**
     * 添加
     */
    int insert(RcEmailAccountInfo info);

    /**
     * 分页查询
     */
    Page<RcEmailAccountInfo> listForPage(int pageCurrent, int pageSize, String premise, String datePremise);

    /**
     * 根据id查询
     */
    RcEmailAccountInfo selectById(Long id);

    /**
     * 更新
     */
    int updateById(RcEmailAccountInfo info);

    List<RcEmailAccountInfo> list();
}
