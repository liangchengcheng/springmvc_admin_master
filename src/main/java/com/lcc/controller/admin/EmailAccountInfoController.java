package com.lcc.controller.admin;


import java.util.List;

import com.lcc.bean.Result;
import com.lcc.bean.entity.RcDataDictionaryList;
import com.lcc.bean.entity.RcEmailAccountInfo;
import com.lcc.biz.EmailAccountInfoBiz;
import com.lcc.util.base.BaseController;
import com.lcc.util.base.Page;
import com.lcc.util.base.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.lcc.util.base.BaseController.LIST;
import static com.lcc.util.base.BaseController.PAGE;

/**
 * 邮件账号controller
 * Created by lcc on 2016/12/24.
 */
@Controller
@RequestMapping(value = "/admin/emailAccountInfo", method = RequestMethod.POST)
public class EmailAccountInfoController extends BaseController {
    private static final String FIELDCODE = "host_code";

    @Autowired
    private EmailAccountInfoBiz biz;

    /**
     * 列表
     */
    @RequestMapping(value = LIST, method = RequestMethod.GET)
    public void list() {

    }

    /**
     * 分页查询
     */
    @ResponseBody
    @RequestMapping(value = PAGE)
    public PageBean<RcEmailAccountInfo> queryForPage(
            @RequestParam(value = "start", defaultValue = "1") int start,
            @RequestParam(value = "length", defaultValue = "10") int pageSize,
            @RequestParam(value = "date", required = false) String date,
            @RequestParam(value = "search", required = false) String search) {
        int pageCurrent = (start / pageSize) + 1;
        Result<Page<RcEmailAccountInfo>> result = biz.listForPage(pageCurrent, pageSize, search, date);
        return new PageBean<>(result.getResultData());
    }

    /**
     * 添加
     */
    @RequestMapping(value = ADD, method = RequestMethod.GET)
    public void add(ModelMap modelMap) {
        Result<List<RcDataDictionaryList>> result = biz.listByFieldCode(FIELDCODE);
        if (result.isStatus()) {
            modelMap.put("selectList", result.getResultData());
        }
    }

    /**
     * 保存
     */
    @RequestMapping(value = SAVE)
    public String insert(@ModelAttribute RcEmailAccountInfo info) {
        Result<RcEmailAccountInfo> result = biz.save(info);
        if (result.isStatus()) {
            return redirect("/admin/emailAccountInfo/list");
        }
        return "admin/emailAccountInfo/list";
    }

    /**
     * 删除
     */
    @RequestMapping(value = DELETE, method = RequestMethod.GET)
    public String delete(@RequestParam Long id) {
        Result<RcEmailAccountInfo> result = biz.delete(id);
        if (result.isStatus()) {
            return redirect("/admin/emailAccountInfo/list");
        }
        return "admin/emailAccountInfo/list";
    }

    /**
     * 查看
     */
    @RequestMapping(value = VIEW, method = RequestMethod.GET)
    public void view(@RequestParam Long id, ModelMap modelMap) {
        Result<RcEmailAccountInfo> result = biz.query(id);
        if (result.isStatus()) {
            modelMap.put("info", result.getResultData());
        }
    }

    /**
     * 编辑
     */
    @RequestMapping(value = EDIT, method = RequestMethod.GET)
    public void edit(@RequestParam Long id, ModelMap modelMap) {
        Result<List<RcDataDictionaryList>> dictionaryListResult = biz.listByFieldCode(FIELDCODE);
        Result<RcEmailAccountInfo> emailAccountResult = biz.query(id);
        if (dictionaryListResult.isStatus()) {
            modelMap.put("selectList", dictionaryListResult.getResultData());
        }
        if (emailAccountResult.isStatus()) {
            modelMap.put("info", emailAccountResult.getResultData());
        }
    }

    /**
     * 更新
     */
    @RequestMapping(value = UPDATE)
    public String update(@ModelAttribute RcEmailAccountInfo info) {
        Result<RcEmailAccountInfo> result = biz.update(info);
        if (result.isStatus()) {
            return redirect("/admin/emailAccountInfo/list");
        }
        return "admin/emailAccountInfo/list";
    }
}
