package com.ruoyi.detection.mapper;

import java.util.List;
import com.ruoyi.detection.domain.Testtube;

/**
 * 试管信息Mapper接口
 * 
 * @author lzy
 * @date 2022-12-04
 */
public interface TesttubeMapper 
{
    /**
     * 查询试管信息
     * 
     * @param no 试管信息主键
     * @return 试管信息
     */
    public Testtube selectTesttubeByNo(Long no);

    /**
     * 查询试管信息列表
     * 
     * @param testtube 试管信息
     * @return 试管信息集合
     */
    public List<Testtube> selectTesttubeList(Testtube testtube);

    /**
     * 新增试管信息
     * 
     * @param testtube 试管信息
     * @return 结果
     */
    public int insertTesttube(Testtube testtube);

    /**
     * 修改试管信息
     * 
     * @param testtube 试管信息
     * @return 结果
     */
    public int updateTesttube(Testtube testtube);

    /**
     * 删除试管信息
     * 
     * @param no 试管信息主键
     * @return 结果
     */
    public int deleteTesttubeByNo(Long no);

    /**
     * 批量删除试管信息
     * 
     * @param nos 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTesttubeByNos(String[] nos);
}
