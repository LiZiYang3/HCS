package com.ruoyi.place.controller;

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
import com.ruoyi.place.domain.Place;
import com.ruoyi.place.service.IPlaceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 场所码信息Controller
 * 
 * @author lzy
 * @date 2022-12-04
 */
@Controller
@RequestMapping("/place/placecode")
public class PlaceController extends BaseController
{
    private String prefix = "place/placecode";

    @Autowired
    private IPlaceService placeService;

    @RequiresPermissions("place:placecode:view")
    @GetMapping()
    public String placecode()
    {
        return prefix + "/placecode";
    }

    /**
     * 查询场所码信息列表
     */
    @RequiresPermissions("place:placecode:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Place place)
    {
        startPage();
        List<Place> list = placeService.selectPlaceList(place);
        return getDataTable(list);
    }

    /**
     * 导出场所码信息列表
     */
    @RequiresPermissions("place:placecode:export")
    @Log(title = "场所码信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Place place)
    {
        List<Place> list = placeService.selectPlaceList(place);
        ExcelUtil<Place> util = new ExcelUtil<Place>(Place.class);
        return util.exportExcel(list, "场所码信息数据");
    }

    /**
     * 新增场所码信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存场所码信息
     */
    @RequiresPermissions("place:placecode:add")
    @Log(title = "场所码信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Place place)
    {
        return toAjax(placeService.insertPlace(place));
    }

    /**
     * 修改场所码信息
     */
    @RequiresPermissions("place:placecode:edit")
    @GetMapping("/edit/{no}")
    public String edit(@PathVariable("no") Long no, ModelMap mmap)
    {
        Place place = placeService.selectPlaceByNo(no);
        mmap.put("place", place);
        return prefix + "/edit";
    }

    /**
     * 修改保存场所码信息
     */
    @RequiresPermissions("place:placecode:edit")
    @Log(title = "场所码信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Place place)
    {
        return toAjax(placeService.updatePlace(place));
    }

    /**
     * 删除场所码信息
     */
    @RequiresPermissions("place:placecode:remove")
    @Log(title = "场所码信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(placeService.deletePlaceByNos(ids));
    }

    /**
     * 统计场所风险等级
     */
    @RequiresPermissions("place:placecode:eCharts")
    @GetMapping("/eCharts")
    public String statistics(ModelMap mmap)
    {
        return prefix + "/eCharts";
    }
    //
    @RequiresPermissions("place:placecode:eCharts")
    @Log(title = "场所风险等级统计", businessType = BusinessType.INSERT)
    @PostMapping("/eCharts")
    @ResponseBody
    public ArrayList<Map<String, String>> statisticsData()
    {
        ArrayList<Map<String, String>> list = placeService.getPlaceRisk();
        return list;
    }
}
