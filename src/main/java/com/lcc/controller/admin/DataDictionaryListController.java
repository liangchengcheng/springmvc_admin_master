package com.lcc.controller.admin;

import com.lcc.bean.Result;
import com.lcc.bean.entity.RcDataDictionaryList;
import com.lcc.biz.DataDictionaryListBiz;
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

/**
 * 数据字典明细Controller
 */
@Controller
@RequestMapping(value = "/admin/dataDictionaryList", method = RequestMethod.POST)
public class DataDictionaryListController extends BaseController {

    @Autowired
    private DataDictionaryListBiz biz;

    /**
     * 查询列表
     */
    @RequestMapping(value = LIST, method = RequestMethod.GET)
    public void list(@RequestParam(value = "id", defaultValue = "-1") Long id, @RequestParam(value = "fieldCode") String fieldCode, ModelMap modelMap) {
        modelMap.put("id", id);
        modelMap.put("fieldCode", fieldCode);
    }

    /**
     * 分页查询
     */
    @ResponseBody
    @RequestMapping(value = PAGE)
    public PageBean<RcDataDictionaryList> queryForList(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize, @RequestParam(value = "fieldCode") String fieldCode, @RequestParam(value = "date", required = false) String date, @RequestParam(value = "search", required = false) String search) {
        Result<Page<RcDataDictionaryList>> result = biz.listForPage((start / pageSize) + 1, pageSize, fieldCode, search, date);
        if (result.isStatus()) {
            return new PageBean<RcDataDictionaryList>(result.getResultData());
        }
        return new PageBean<RcDataDictionaryList>();
    }

    /**
     * 添加
     */
    @RequestMapping(value = ADD, method = RequestMethod.GET)
    public void add(@RequestParam(value = "id", defaultValue = "-1") Long id, @RequestParam(value = "fieldCode") String fieldCode, ModelMap modelMap) {
        modelMap.put("id", id);
        modelMap.put("fieldCode", fieldCode);
    }

    /**
     * 保存
     */
    @RequestMapping(value = SAVE)
    public String save(@ModelAttribute("dListVo") RcDataDictionaryList dList, @RequestParam(name = "dId") Long dId) {
        Result<RcDataDictionaryList> result = biz.save(dList);
        if (result.isStatus()) {
            return redirect("/admin/dataDictionaryList/list?id={0}&fieldCode={1}", dId, dList.getFieldCode());
        }
        return redirect("/admin/dataDictionaryList/list?id={0}&fieldCode={1}", dId, dList.getFieldCode());
    }

    /**
     * 删除
     */
    @RequestMapping(value = DELETE, method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") Long id, @RequestParam(value = "dId") Long dId, @RequestParam(value = "fieldCode") String fieldCode) {
        Result<String> result = biz.delete(id);
        if (result.isStatus()) {
            return redirect("/admin/dataDictionaryList/list?id={0}&fieldCode={1}", dId, fieldCode);
        }
        return redirect("/admin/dataDictionaryList/list?id={0}&fieldCode={1}", dId, fieldCode);
    }

    /**
     * 查看
     */
    @RequestMapping(value = VIEW, method = RequestMethod.GET)
    public void view(@RequestParam(value = "id", required = false) Long id, ModelMap modelMap) {
        Result<RcDataDictionaryList> result = biz.query(id);
        if (result.isStatus()) {
            modelMap.put("dictionaryList", result.getResultData());
        }
    }

    /**
     * 编辑
     */
    @RequestMapping(value = EDIT, method = RequestMethod.GET)
    public void edit(@RequestParam(value = "id", defaultValue = "-1") Long id, @RequestParam(value = "dId") Long dId, ModelMap modelMap) {
        Result<RcDataDictionaryList> result = biz.query(id);
        modelMap.put("id", dId);
        if (result.isStatus()) {
            modelMap.put("dictionaryList", result.getResultData());
        }
    }

    /**
     * 更新
     */
    @RequestMapping(value = UPDATE)
    public String update(@ModelAttribute RcDataDictionaryList dList, @RequestParam(value = "dId") Long dId) {
        biz.update(dList);
        return redirect("/admin/dataDictionaryList/list?id={0}&fieldCode={1}", dId, dList.getFieldCode());
    }
}
