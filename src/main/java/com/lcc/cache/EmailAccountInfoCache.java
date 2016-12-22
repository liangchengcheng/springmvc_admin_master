package com.lcc.cache;


import java.util.List;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.PostConstruct;

import com.lcc.bean.Result;
import com.lcc.bean.entity.RcEmailAccountInfo;
import com.lcc.service.EmailAccountInfoService;
import com.lcc.util.base.CachedImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmailAccountInfoCache extends CachedImpl<String, RcEmailAccountInfo> {

    @Autowired
    private EmailAccountInfoService emailAccountInfoService;

    private final static Long INITIALDELAY = 300L;
    private final static Long PERIOD = 300L;

    @PostConstruct
    public void init() {
        super.init(INITIALDELAY, PERIOD);
    }

    @Override
    public void reloadFromDb(ConcurrentMap<String, RcEmailAccountInfo> cached) {
        Result<List<RcEmailAccountInfo>> result = emailAccountInfoService.list();
        if (result.isStatus()) {
            for (RcEmailAccountInfo bean : result.getResultData()) {
                cached.putIfAbsent(String.valueOf(bean.getId()), bean);
            }
        }
    }

}
