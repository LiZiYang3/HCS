package com.ruoyi.detection.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.detection.mapper.TesttubeMapper;
import com.ruoyi.detection.domain.Testtube;
import com.ruoyi.detection.service.ITesttubeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 试管信息Service业务层处理
 *
 * @author lzy
 * @date 2022-12-17
 */
@Service
public class TesttubeServiceImpl implements ITesttubeService
{
    @Autowired
    private TesttubeMapper testtubeMapper;

    /**
     * 查询试管信息
     *
     * @param no 试管信息主键
     * @return 试管信息
     */
    @Override
    public Testtube selectTesttubeByNo(Long no)
    {
        return testtubeMapper.selectTesttubeByNo(no);
    }

    /**
     * 查询试管信息列表
     *
     * @param testtube 试管信息
     * @return 试管信息
     */
    @Override
    public List<Testtube> selectTesttubeList(Testtube testtube)
    {
        return testtubeMapper.selectTesttubeList(testtube);
    }

    /**
     * 新增试管信息
     *
     * @param testtube 试管信息
     * @return 结果
     */
    @Override
    public int insertTesttube(Testtube testtube)
    {
        return testtubeMapper.insertTesttube(testtube);
    }

    /**
     * 修改试管信息
     *
     * @param testtube 试管信息
     * @return 结果
     */
    @Override
    public int updateTesttube(Testtube testtube)
    {
        return testtubeMapper.updateTesttube(testtube);
    }

    /**
     * 批量删除试管信息
     *
     * @param nos 需要删除的试管信息主键
     * @return 结果
     */
    @Override
    public int deleteTesttubeByNos(String nos)
    {
        return testtubeMapper.deleteTesttubeByNos(Convert.toStrArray(nos));
    }

    /**
     * 删除试管信息信息
     *
     * @param no 试管信息主键
     * @return 结果
     */
    @Override
    public int deleteTesttubeByNo(Long no)
    {
        return testtubeMapper.deleteTesttubeByNo(no);
    }

    //统计
    @Override
    public ArrayList<Map<String, String>> getDetectionResult() {
        ArrayList<Map<String,String>> list = new ArrayList<>();
        Integer low_count_0 = 0;
        Integer high_count_1 = 0;
        List<Testtube> testtubes = testtubeMapper.selectTesttubeList(new Testtube());
        for (Testtube item:testtubes) {
            if ( "0".equals(item.getResult()) ) {
                low_count_0 = low_count_0 + 1;
            }else if("1".equals(item.getResult())){
                high_count_1 = high_count_1 + 1;
            }
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("name","阴性");
        map.put("value",low_count_0.toString());
        list.add(map);
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("name","阳性");
        map1.put("value",high_count_1.toString());
        list.add(map1);
        return list;
    }
}
