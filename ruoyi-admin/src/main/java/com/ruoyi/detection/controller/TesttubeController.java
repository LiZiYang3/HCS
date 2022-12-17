package com.ruoyi.detection.controller;

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
import com.ruoyi.detection.domain.Testtube;
import com.ruoyi.detection.service.ITesttubeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 试管信息Controller
 * 
 * @author lzy
 * @date 2022-12-17
 */
@Controller
@RequestMapping("/detection/testtube")
public class TesttubeController extends BaseController
{
    private String prefix = "detection/testtube";

    @Autowired
    private ITesttubeService testtubeService;

    @RequiresPermissions("detection:testtube:view")
    @GetMapping()
    public String testtube()
    {
        return prefix + "/testtube";
    }

    /**
     * 查询试管信息列表
     */
    @RequiresPermissions("detection:testtube:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Testtube testtube)
    {
        startPage();
        List<Testtube> list = testtubeService.selectTesttubeList(testtube);
        return getDataTable(list);
    }

    /**
     * 导出试管信息列表
     */
    @RequiresPermissions("detection:testtube:export")
    @Log(title = "试管信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Testtube testtube)
    {
        List<Testtube> list = testtubeService.selectTesttubeList(testtube);
        ExcelUtil<Testtube> util = new ExcelUtil<Testtube>(Testtube.class);
        return util.exportExcel(list, "试管信息数据");
    }

    /**
     * 新增试管信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存试管信息
     */
    @RequiresPermissions("detection:testtube:add")
    @Log(title = "试管信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Testtube testtube)
    {
        return toAjax(testtubeService.insertTesttube(testtube));
    }

    /**
     * 修改试管信息
     */
    @RequiresPermissions("detection:testtube:edit")
    @GetMapping("/edit/{no}")
    public String edit(@PathVariable("no") Long no, ModelMap mmap)
    {
        Testtube testtube = testtubeService.selectTesttubeByNo(no);
        mmap.put("testtube", testtube);
        return prefix + "/edit";
    }

    /**
     * 修改保存试管信息
     */
    @RequiresPermissions("detection:testtube:edit")
    @Log(title = "试管信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Testtube testtube)
    {
        return toAjax(testtubeService.updateTesttube(testtube));
    }

    /**
     * 删除试管信息
     */
    @RequiresPermissions("detection:testtube:remove")
    @Log(title = "试管信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(testtubeService.deleteTesttubeByNos(ids));
    }
}