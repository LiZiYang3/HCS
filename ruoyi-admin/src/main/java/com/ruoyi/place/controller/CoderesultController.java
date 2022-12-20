package com.ruoyi.place.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruoyi.detection.domain.Detectionresult;
import com.ruoyi.place.domain.Place;
import com.ruoyi.place.service.IPlaceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    private IPlaceService placeService;


    @GetMapping()
    public String coderesult()
    {
        return prefix + "/coderesult";
    }

    /**
     * 查询扫码记录列表
     */

    @RequestMapping("/list")
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

    @Log(title = "扫码记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(coderesultService.deleteCoderesultByNos(ids));
    }

    /**
     * 统计场所码扫描情况
     */

    @GetMapping("/eCharts")
    public String statistics(ModelMap mmap)
    {
        return prefix + "/eCharts";
    }


    @Log(title = "场所码扫描情况统计", businessType = BusinessType.INSERT)
    @PostMapping("/eCharts")
    @ResponseBody
    public List<Integer> statisticsData()
    {
        List<Integer> list = coderesultService.getMonthlyPlaceScanRecordIncrement();
        return list;
    }

    @GetMapping("/searchCodeResult")
    @ResponseBody
    public List<Coderesult> searchCodeResult(@RequestParam String id)
    {
        Coderesult coderesult = new Coderesult();
        coderesult.setId(id);
        System.out.println(id);
        return coderesultService.selectCoderesultList(coderesult);
    }

    @RequestMapping("/searchCodeResultWithName")
    @ResponseBody
    public List<Coderesult> searchCodeResultWithName(@RequestParam String id)
    {
        Coderesult coderesult = new Coderesult();
        coderesult.setId(id);

        return coderesultService.selectCoderesultListWithPlaceName(coderesult);
    }

    @GetMapping("/addCodeResult")
    @ResponseBody
    public AjaxResult addCodeResult(@RequestParam String id, @RequestParam String pid)
    {
        Coderesult coderesult = new Coderesult();
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        coderesult.setId(id);
        coderesult.setPid(pid);
        coderesult.setTime(date);
        return toAjax(coderesultService.insertCoderesult(coderesult));
    }
}
