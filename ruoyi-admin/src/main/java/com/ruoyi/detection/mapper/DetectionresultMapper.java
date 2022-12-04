package com.ruoyi.detection.mapper;

import java.util.List;
import com.ruoyi.detection.domain.Detectionresult;

/**
 * 检测结果Mapper接口
 * 
 * @author lzy
 * @date 2022-12-04
 */
public interface DetectionresultMapper 
{
    /**
     * 查询检测结果
     * 
     * @param no 检测结果主键
     * @return 检测结果
     */
    public Detectionresult selectDetectionresultByNo(Long no);

    /**
     * 查询检测结果列表
     * 
     * @param detectionresult 检测结果
     * @return 检测结果集合
     */
    public List<Detectionresult> selectDetectionresultList(Detectionresult detectionresult);

    /**
     * 新增检测结果
     * 
     * @param detectionresult 检测结果
     * @return 结果
     */
    public int insertDetectionresult(Detectionresult detectionresult);

    /**
     * 修改检测结果
     * 
     * @param detectionresult 检测结果
     * @return 结果
     */
    public int updateDetectionresult(Detectionresult detectionresult);

    /**
     * 删除检测结果
     * 
     * @param no 检测结果主键
     * @return 结果
     */
    public int deleteDetectionresultByNo(Long no);

    /**
     * 批量删除检测结果
     * 
     * @param nos 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDetectionresultByNos(String[] nos);
}
