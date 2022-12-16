package com.ruoyi.detection.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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
 * @date 2022-12-13
 */
@Controller
@RequestMapping("/detection/detectionresult")
public class DetectionresultController extends BaseController
{
    private String prefix = "detection/detectionresult";

    @Autowired
    private IDetectionresultService detectionresultService;

    @GetMapping()
    public String detectionresult()
    {
        return prefix + "/detectionresult";
    }

    /**
     * 查询检测结果列表
     */

    @RequestMapping("/list")
    @ResponseBody
    public TableDataInfo list(Detectionresult detectionresult)
    {
        startPage();
        List<Detectionresult> list = detectionresultService.selectDetectionresultList(detectionresult);
        return getDataTable(list);
    }

    @RequestMapping("/searchDetectionRecord")
    @ResponseBody
    public List<Detectionresult> searchDetectionRecord(@RequestParam(value="id") String id)
    {
        Detectionresult detectionresult = new Detectionresult();
        detectionresult.setId(id);
        return detectionresultService.selectDetectionresultList(detectionresult);
    }

    @RequestMapping("/searchDetectionRecord1")
    @ResponseBody
    public List<Detectionresult> searchDetectionRecord1()
    {
        Detectionresult detectionresult = new Detectionresult();
        return detectionresultService.selectDetectionresultList(detectionresult);
    }

    @GetMapping("/searchDetectionRecord2")
    @ResponseBody
    public List<Detectionresult> searchDetectionRecord2(@RequestParam String id)
    {
        Detectionresult detectionresult = new Detectionresult();
        detectionresult.setId(id);

        System.out.println(id);
        return detectionresultService.selectDetectionresultList(detectionresult);
    }

    @GetMapping("/searchDetectionRecord3")
    @ResponseBody
    public List<Detectionresult> searchDetectionRecord3(@RequestParam String result)
    {
        Detectionresult detectionresult = new Detectionresult();
        detectionresult.setResult(result);

        System.out.println(result);
        return detectionresultService.selectDetectionresultList(detectionresult);
    }

    @GetMapping("/addDetectionRecord")
    @ResponseBody
    public AjaxResult addDetectionRecord(@RequestParam String id, @RequestParam String sid, @RequestParam String result)
    {
        Detectionresult detectionresult = new Detectionresult();
        detectionresult.setId(id);
        detectionresult.setSid(sid);
        detectionresult.setResult(result);
        return toAjax(detectionresultService.insertDetectionresult(detectionresult));
    }

    /*@GetMapping("/searchDetectionRecord2")
    public List<Detectionresult> searchDetectionRecord2(@RequestParam String result)
    {
        Detectionresult detectionresult = new Detectionresult();
        detectionresult.setResult(result);

        System.out.println(result);
        return detectionresultService.selectDetectionresultList(detectionresult);
    }*/

    /**
     * 导出检测结果列表
     */

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

    @Log(title = "检测结果", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    //Detectionresult(id,sid,time,rusult);
    public AjaxResult addSave(Detectionresult detectionresult)
    {
        return toAjax(detectionresultService.insertDetectionresult(detectionresult));
    }

    /**
     * 修改检测结果
     */

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

    @Log(title = "检测结果", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(detectionresultService.deleteDetectionresultByNos(ids));
    }

    /**
     * 统计核酸检测结果
     */

    @GetMapping("/eCharts")
    public String statistics(ModelMap mmap)
    {
        return prefix + "/eCharts";
    }


    //

    @PostMapping("/eCharts")
    @ResponseBody
    public ArrayList<Map<String, String>> statisticsData()
    {
        return detectionresultService.getDetectionResult();
    }

    /**
     * 统计核酸检测月份分布
     */

    @GetMapping("/eCharts1")
    public String statistics1(ModelMap mmap)
    {
        return prefix + "/eCharts1";
    }


    //

    @Log(title = "检测结果统计", businessType = BusinessType.INSERT)
    @PostMapping("/eCharts1")
    @ResponseBody
    public List<Integer> statisticsData1()
    {
        return detectionresultService.getMonthlyDetectionResult();
    }
}
