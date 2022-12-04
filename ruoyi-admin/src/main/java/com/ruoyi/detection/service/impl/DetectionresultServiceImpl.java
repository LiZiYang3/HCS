package com.ruoyi.detection.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.detection.mapper.DetectionresultMapper;
import com.ruoyi.detection.domain.Detectionresult;
import com.ruoyi.detection.service.IDetectionresultService;
import com.ruoyi.common.core.text.Convert;

/**
 * 检测结果Service业务层处理
 * 
 * @author lzy
 * @date 2022-12-04
 */
@Service
public class DetectionresultServiceImpl implements IDetectionresultService 
{
    @Autowired
    private DetectionresultMapper detectionresultMapper;

    /**
     * 查询检测结果
     * 
     * @param no 检测结果主键
     * @return 检测结果
     */
    @Override
    public Detectionresult selectDetectionresultByNo(Long no)
    {
        return detectionresultMapper.selectDetectionresultByNo(no);
    }

    /**
     * 查询检测结果列表
     * 
     * @param detectionresult 检测结果
     * @return 检测结果
     */
    @Override
    public List<Detectionresult> selectDetectionresultList(Detectionresult detectionresult)
    {
        return detectionresultMapper.selectDetectionresultList(detectionresult);
    }

    /**
     * 新增检测结果
     * 
     * @param detectionresult 检测结果
     * @return 结果
     */
    @Override
    public int insertDetectionresult(Detectionresult detectionresult)
    {
        return detectionresultMapper.insertDetectionresult(detectionresult);
    }

    /**
     * 修改检测结果
     * 
     * @param detectionresult 检测结果
     * @return 结果
     */
    @Override
    public int updateDetectionresult(Detectionresult detectionresult)
    {
        return detectionresultMapper.updateDetectionresult(detectionresult);
    }

    /**
     * 批量删除检测结果
     * 
     * @param nos 需要删除的检测结果主键
     * @return 结果
     */
    @Override
    public int deleteDetectionresultByNos(String nos)
    {
        return detectionresultMapper.deleteDetectionresultByNos(Convert.toStrArray(nos));
    }

    /**
     * 删除检测结果信息
     * 
     * @param no 检测结果主键
     * @return 结果
     */
    @Override
    public int deleteDetectionresultByNo(Long no)
    {
        return detectionresultMapper.deleteDetectionresultByNo(no);
    }
}
