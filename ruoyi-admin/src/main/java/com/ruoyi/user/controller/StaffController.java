package com.ruoyi.user.controller;

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
import com.ruoyi.user.domain.Staff;
import com.ruoyi.user.service.IStaffService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 检测人员信息Controller
 * 
 * @author lzy
 * @date 2022-12-04
 */
@Controller
@RequestMapping("/user/staff")
public class StaffController extends BaseController
{
    private String prefix = "user/staff";

    @Autowired
    private IStaffService staffService;


    @GetMapping()
    public String staff()
    {
        return prefix + "/staff";
    }

    /**
     * 查询检测人员信息列表
     */

    @RequestMapping("/list")
    @ResponseBody
    public TableDataInfo list(Staff staff)
    {
        startPage();
        List<Staff> list = staffService.selectStaffList(staff);
        return getDataTable(list);
    }

    /**
     * 导出检测人员信息列表
     */

    @Log(title = "检测人员信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Staff staff)
    {
        List<Staff> list = staffService.selectStaffList(staff);
        ExcelUtil<Staff> util = new ExcelUtil<Staff>(Staff.class);
        return util.exportExcel(list, "检测人员信息数据");
    }

    /**
     * 新增检测人员信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存检测人员信息
     */

    @Log(title = "检测人员信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Staff staff)
    {
        return toAjax(staffService.insertStaff(staff));
    }

    /**
     * 修改检测人员信息
     */

    @GetMapping("/edit/{no}")
    public String edit(@PathVariable("no") Long no, ModelMap mmap)
    {
        Staff staff = staffService.selectStaffByNo(no);
        mmap.put("staff", staff);
        return prefix + "/edit";
    }

    /**
     * 修改保存检测人员信息
     */

    @Log(title = "检测人员信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Staff staff)
    {
        return toAjax(staffService.updateStaff(staff));
    }

    /**
     * 删除检测人员信息
     */

    @Log(title = "检测人员信息", businessType = BusinessType.DELETE)
    @RequestMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(staffService.deleteStaffByNos(ids));
    }
}
