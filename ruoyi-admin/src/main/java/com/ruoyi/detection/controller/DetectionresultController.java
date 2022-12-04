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
import com.ruoyi.detection.domain.Detectionresult;
import com.ruoyi.detection.service.IDetectionresultService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 检测结果Controller
 * 
 * @author lzy
 * @date 2022-12-04
 */
@Controller
@RequestMapping("/detection/detectionresult")
public class DetectionresultController extends BaseController
{
    private String prefix = "detection/detectionresult";

    @Autowired
    private IDetectionresultService detectionresultService;

    @RequiresPermissions("detection:detectionresult:view")
    @GetMapping()
    public String detectionresult()
    {
        return prefix + "/detectionresult";
    }

    /**
     * 查询检测结果列表
     */
    @RequiresPermissions("detection:detectionresult:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Detectionresult detectionresult)
    {
        startPage();
        List<Detectionresult> list = detectionresultService.selectDetectionresultList(detectionresult);
        return getDataTable(list);
    }

    /**
     * 导出检测结果列表
     */
    @RequiresPermissions("detection:detectionresult:export")
    @Log(title = "检测结果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Detectionresult detectionresult)
    {
        List<Detectionresult> list = detectionresultService.selectDetectionresultList(detectionresult);
        ExcelUtil<Detectionresult> util = new ExcelUtil<Detectionresult>(Detectionresult.class);
        return util.exportExcel(list, "检测结果数据");
    }

    /**
     * 新增检测结果
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存检测结果
     */
    @RequiresPermissions("detection:detectionresult:add")
    @Log(title = "检测结果", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Detectionresult detectionresult)
    {
        return toAjax(detectionresultService.insertDetectionresult(detectionresult));
    }

    /**
     * 修改检测结果
     */
    @RequiresPermissions("detection:detectionresult:edit")
    @GetMapping("/edit/{no}")
    public String edit(@PathVariable("no") Long no, ModelMap mmap)
    {
        Detectionresult detectionresult = detectionresultService.selectDetectionresultByNo(no);
        mmap.put("detectionresult", detectionresult);
        return prefix + "/edit";
    }

    /**
     * 修改保存检测结果
     */
    @RequiresPermissions("detection:detectionresult:edit")
    @Log(title = "检测结果", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Detectionresult detectionresult)
    {
        return toAjax(detectionresultService.updateDetectionresult(detectionresult));
    }

    /**
     * 删除检测结果
     */
    @RequiresPermissions("detection:detectionresult:remove")
    @Log(title = "检测结果", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(detectionresultService.deleteDetectionresultByNos(ids));
    }
}
