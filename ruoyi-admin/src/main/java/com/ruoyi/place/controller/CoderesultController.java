package com.ruoyi.place.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.place.domain.Coderesult;
import com.ruoyi.place.service.ICoderesultService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 扫码记录Controller
 * 
 * @author lzy
 * @date 2022-12-04
 */
@Controller
@RequestMapping("/place/coderesult")
public class CoderesultController extends BaseController
{
    private String prefix = "place/coderesult";

    @Autowired
    private ICoderesultService coderesultService;

    @RequiresPermissions("place:coderesult:view")
    @GetMapping()
    public String coderesult()
    {
        return prefix + "/coderesult";
    }

    /**
     * 查询扫码记录列表
     */
    @RequiresPermissions("place:coderesult:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Coderesult coderesult)
    {
        startPage();
        List<Coderesult> list = coderesultService.selectCoderesultList(coderesult);
        return getDataTable(list);
    }

    /**
     * 导出扫码记录列表
     */
    @RequiresPermissions("place:coderesult:export")
    @Log(title = "扫码记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Coderesult coderesult)
    {
        List<Coderesult> list = coderesultService.selectCoderesultList(coderesult);
        ExcelUtil<Coderesult> util = new ExcelUtil<Coderesult>(Coderesult.class);
        return util.exportExcel(list, "扫码记录数据");
    }

    /**
     * 新增扫码记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存扫码记录
     */
    @RequiresPermissions("place:coderesult:add")
    @Log(title = "扫码记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Coderesult coderesult)
    {
        return toAjax(coderesultService.insertCoderesult(coderesult));
    }

    /**
     * 修改扫码记录
     */
    @RequiresPermissions("place:coderesult:edit")
    @GetMapping("/edit/{no}")
    public String edit(@PathVariable("no") Long no, ModelMap mmap)
    {
        Coderesult coderesult = coderesultService.selectCoderesultByNo(no);
        mmap.put("coderesult", coderesult);
        return prefix + "/edit";
    }

    /**
     * 修改保存扫码记录
     */
    @RequiresPermissions("place:coderesult:edit")
    @Log(title = "扫码记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Coderesult coderesult)
    {
        return toAjax(coderesultService.updateCoderesult(coderesult));
    }

    /**
     * 删除扫码记录
     */
    @RequiresPermissions("place:coderesult:remove")
    @Log(title = "扫码记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(coderesultService.deleteCoderesultByNos(ids));
    }
}
