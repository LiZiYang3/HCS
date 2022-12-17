package com.ruoyi.detection.service.impl;

import java.util.List;
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
}
