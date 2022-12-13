package com.ruoyi.detection.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ruoyi.detection.domain.Detectionresult;

/**
 * 检测结果Service接口
 * 
 * @author lzy
 * @date 2022-12-13
 */
public interface IDetectionresultService 
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
     * 批量删除检测结果
     * 
     * @param nos 需要删除的检测结果主键集合
     * @return 结果
     */
    public int deleteDetectionresultByNos(String nos);

    /**
     * 删除检测结果信息
     * 
     * @param no 检测结果主键
     * @return 结果
     */
    public int deleteDetectionresultByNo(Long no);

    public ArrayList<Map<String, String>> getDetectionResult();
    public List<Integer> getMonthlyDetectionResult();

}
