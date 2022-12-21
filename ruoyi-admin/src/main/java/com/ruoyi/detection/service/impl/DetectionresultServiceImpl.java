package com.ruoyi.detection.service.impl;

import java.util.*;

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
 * @date 2022-12-13
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

    //统计
    @Override
    public ArrayList<Map<String, String>> getDetectionResult() {
        ArrayList<Map<String,String>> list = new ArrayList<>();
        Integer yin_count_0 = 0;
        Integer yang_count_1 = 0;
        List<Detectionresult> detectionresults = detectionresultMapper.selectDetectionresultList(new Detectionresult());
        for (Detectionresult item : detectionresults) {
            if ( "0".equals(item.getResult()) ) {
                yin_count_0 += 1;
            }else if ( "1".equals(item.getResult()) ){
                yang_count_1 += 1;
            }
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("name","阴性");
        map.put("value",yin_count_0.toString());
        list.add(map);
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("name","阳性");
        map1.put("value",yang_count_1.toString());
        list.add(map1);
        return list;
    }

    //统计
    @Override
    public List<Integer> getMonthlyDetectionResult() {
        int len = 12;
        List<Integer> list = new ArrayList<Integer>(len);
        for (int i = 0; i < len; i++) {
            list.add(0);
        }
        Calendar ca = Calendar.getInstance();
        List<Detectionresult> detectionresults = detectionresultMapper.selectDetectionresultList(new Detectionresult());
        for (Detectionresult item:detectionresults) {
            if ( !"".equals(item.getId())) {
                ca.setTime(item.getTime());
                int idx = ca.get(Calendar.MONTH);
                int cur = list.get(idx);
                list.set(idx, 1 + cur);
            }
        }
        return list;
    }
}
