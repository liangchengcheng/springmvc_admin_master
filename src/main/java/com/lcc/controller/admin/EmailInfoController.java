package com.lcc.controller.admin;

/**
 * Created by lcc on 2016/12/24.
 */

import com.lcc.bean.Result;
import com.lcc.bean.entity.RcEmailInfo;
import com.lcc.biz.EmailInfoBiz;
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

/**
 * email 功能
 */
@Controller
@RequestMapping(value = "/admin/emailInfo", method = RequestMethod.POST)
public class EmailInfoController extends BaseController {

    @Autowired
    private EmailInfoBiz biz;

    @RequestMapping(value = LIST, method = RequestMethod.GET)
    public void list(@RequestParam(value = "pageCurrent", defaultValue = "1")
                             int pageCurrent, @RequestParam(value = "pageSize", defaultValue = "20")
                             int pageSize, ModelMap modelMap) {

    }

    /**
     * 添加
     */
    @RequestMapping(value = ADD, method = RequestMethod.GET)
    public void add(ModelMap modelMap) {
    }

    @ResponseBody
    @RequestMapping(value = PAGE)
    public PageBean<RcEmailInfo> queryForList(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize, @RequestParam(value="date",required=false)String  date, @RequestParam(value="search",required=false)String search) {
        int pageCurrent = (start/pageSize)+1;
        Result<Page<RcEmailInfo>> result = biz.listForPage(pageCurrent, pageSize,search,date);
        return new PageBean<RcEmailInfo>(result.getResultData());
    }

    /**
     * 发送邮件
     */
    @RequestMapping(value = "/send")
    public String send(@ModelAttribute RcEmailInfo rcEmailInfo) {
        Result<RcEmailInfo> result = biz.sendMail(rcEmailInfo);
        if(result.isStatus()){
            return redirect("/admin/emailInfo/list");
        }
        return "admin/emailInfo/list";

    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") Long id) {
        Result<RcEmailInfo> result = biz.delete(id);
        if(result.isStatus()){
            return redirect("/admin/emailInfo/list");
        }
        return "admin/emailInfo/list";
    }

    /**
     * 查看
     */
    @RequestMapping(value = VIEW, method = RequestMethod.GET)
    public void view(@RequestParam(value = "id") Long id, ModelMap modelMap) {
        Result<RcEmailInfo> result = biz.query(id);
        if(result.isStatus()){
            modelMap.put("info", result.getResultData());
        }
    }

}
