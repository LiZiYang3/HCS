package com.ruoyi.user.mapper;

import java.util.List;
import com.ruoyi.user.domain.Staff;

/**
 * 检测人员信息Mapper接口
 * 
 * @author lzy
 * @date 2022-12-04
 */
public interface StaffMapper 
{
    /**
     * 查询检测人员信息
     * 
     * @param no 检测人员信息主键
     * @return 检测人员信息
     */
    public Staff selectStaffByNo(Long no);

    /**
     * 查询检测人员信息列表
     * 
     * @param staff 检测人员信息
     * @return 检测人员信息集合
     */
    public List<Staff> selectStaffList(Staff staff);

    /**
     * 新增检测人员信息
     * 
     * @param staff 检测人员信息
     * @return 结果
     */
    public int insertStaff(Staff staff);

    /**
     * 修改检测人员信息
     * 
     * @param staff 检测人员信息
     * @return 结果
     */
    public int updateStaff(Staff staff);

    /**
     * 删除检测人员信息
     * 
     * @param no 检测人员信息主键
     * @return 结果
     */
    public int deleteStaffByNo(Long no);

    /**
     * 批量删除检测人员信息
     * 
     * @param nos 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStaffByNos(String[] nos);
}
