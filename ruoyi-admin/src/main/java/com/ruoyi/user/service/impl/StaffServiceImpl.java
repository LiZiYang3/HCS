package com.ruoyi.user.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.user.mapper.StaffMapper;
import com.ruoyi.user.domain.Staff;
import com.ruoyi.user.service.IStaffService;
import com.ruoyi.common.core.text.Convert;

/**
 * 检测人员信息Service业务层处理
 * 
 * @author lzy
 * @date 2022-12-04
 */
@Service
public class StaffServiceImpl implements IStaffService 
{
    @Autowired
    private StaffMapper staffMapper;

    /**
     * 查询检测人员信息
     * 
     * @param no 检测人员信息主键
     * @return 检测人员信息
     */
    @Override
    public Staff selectStaffByNo(Long no)
    {
        return staffMapper.selectStaffByNo(no);
    }

    /**
     * 查询检测人员信息列表
     * 
     * @param staff 检测人员信息
     * @return 检测人员信息
     */
    @Override
    public List<Staff> selectStaffList(Staff staff)
    {
        return staffMapper.selectStaffList(staff);
    }

    /**
     * 新增检测人员信息
     * 
     * @param staff 检测人员信息
     * @return 结果
     */
    @Override
    public int insertStaff(Staff staff)
    {
        return staffMapper.insertStaff(staff);
    }

    /**
     * 修改检测人员信息
     * 
     * @param staff 检测人员信息
     * @return 结果
     */
    @Override
    public int updateStaff(Staff staff)
    {
        return staffMapper.updateStaff(staff);
    }

    /**
     * 批量删除检测人员信息
     * 
     * @param nos 需要删除的检测人员信息主键
     * @return 结果
     */
    @Override
    public int deleteStaffByNos(String nos)
    {
        return staffMapper.deleteStaffByNos(Convert.toStrArray(nos));
    }

    /**
     * 删除检测人员信息信息
     * 
     * @param no 检测人员信息主键
     * @return 结果
     */
    @Override
    public int deleteStaffByNo(Long no)
    {
        return staffMapper.deleteStaffByNo(no);
    }
}
