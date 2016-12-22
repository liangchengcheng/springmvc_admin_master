package com.lcc.biz;


import java.util.List;
import java.util.Random;

import com.lcc.bean.Result;
import com.lcc.bean.entity.RcEmailAccountInfo;
import com.lcc.bean.entity.RcEmailInfo;
import com.lcc.cache.EmailAccountInfoCache;
import com.lcc.service.EmailInfoService;
import com.lcc.util.base.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailInfoBiz {

    @Autowired
    private EmailInfoService emailInfoService;

    @Autowired
    private EmailAccountInfoCache accountInfoCache;

    /**
     * 分页查询
     */
    public Result<Page<RcEmailInfo>> listForPage(int pageCurrent, int pageSize, String premise, String datePremise) {
        return emailInfoService.listForPage(pageCurrent, pageSize,premise,datePremise);
    }

    /**
     * 发送邮件
     */
    public Result<RcEmailInfo> sendMail(RcEmailInfo infoVo) {
        List<RcEmailAccountInfo> accountList = accountInfoCache.getList();
        Random random = new Random();
        int index = random.nextInt(accountList.size());
        RcEmailInfo rcEmailInfo = new RcEmailInfo();
        BeanUtils.copyProperties(infoVo, rcEmailInfo);
        return emailInfoService.sendMail(accountList.get(index), rcEmailInfo);
    }

    /**
     * 根据id进行删除
     */
    public Result<RcEmailInfo> delete(Long id) {
        return emailInfoService.delete(id);
    }

    /**
     * 根据id查询
     */
    public Result<RcEmailInfo> query(Long id) {
        return emailInfoService.query(id);
    }
}
