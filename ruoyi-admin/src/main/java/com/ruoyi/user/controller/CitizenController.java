package com.ruoyi.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.ruoyi.user.domain.Citizen;
import com.ruoyi.user.service.ICitizenService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 市民信息Controller
 * 
 * @author lzy
 * @date 2022-12-04
 */
@Controller
@RequestMapping("/user/citizen")
public class CitizenController extends BaseController
{
    private String prefix = "user/citizen";

    @Autowired
    private ICitizenService citizenService;

    @RequiresPermissions("user:citizen:view")
    @GetMapping()
    public String citizen()
    {
        return prefix + "/citizen";
    }

    /**
     * 查询市民信息列表
     */
    @RequiresPermissions("user:citizen:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Citizen citizen)
    {
        startPage();
        List<Citizen> list = citizenService.selectCitizenList(citizen);
        return getDataTable(list);
    }

    /**
     * 导出市民信息列表
     */
    @RequiresPermissions("user:citizen:export")
    @Log(title = "市民信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Citizen citizen)
    {
        List<Citizen> list = citizenService.selectCitizenList(citizen);
        ExcelUtil<Citizen> util = new ExcelUtil<Citizen>(Citizen.class);
        return util.exportExcel(list, "市民信息数据");
    }

    /**
     * 新增市民信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存市民信息
     */
    @RequiresPermissions("user:citizen:add")
    @Log(title = "市民信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Citizen citizen)
    {
        return toAjax(citizenService.insertCitizen(citizen));
    }

    /**
     * 修改市民信息
     */
    @RequiresPermissions("user:citizen:edit")
    @GetMapping("/edit/{no}")
    public String edit(@PathVariable("no") Long no, ModelMap mmap)
    {
        Citizen citizen = citizenService.selectCitizenByNo(no);
        mmap.put("citizen", citizen);
        return prefix + "/edit";
    }

    /**
     * 修改保存市民信息
     */
    @RequiresPermissions("user:citizen:edit")
    @Log(title = "市民信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Citizen citizen)
    {
        return toAjax(citizenService.updateCitizen(citizen));
    }

    /**
     * 删除市民信息
     */
    @RequiresPermissions("user:citizen:remove")
    @Log(title = "市民信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(citizenService.deleteCitizenByNos(ids));
    }

    /**
     * 统计市民健康码
     */
    @RequiresPermissions("user:citizen:eCharts")
    @GetMapping("/eCharts")
    public String statistics(ModelMap mmap)
    {
        return prefix + "/eCharts";
    }
    //
    @RequiresPermissions("user:citizen:eCharts")
    @Log(title = "市民健康码统计", businessType = BusinessType.INSERT)
    @PostMapping("/eCharts")
    @ResponseBody
    public ArrayList<Map<String, String>> statisticsData()
    {
        ArrayList<Map<String, String>> list = citizenService.getCitizenCodeColor();
        return list;
    }
}

