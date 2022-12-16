package com.ruoyi.place.mapper;

import java.util.List;
import com.ruoyi.place.domain.Coderesult;

/**
 * 扫码记录Mapper接口
 * 
 * @author lzy
 * @date 2022-12-04
 */
public interface CoderesultMapper 
{
    /**
     * 查询扫码记录
     * 
     * @param no 扫码记录主键
     * @return 扫码记录
     */
    public Coderesult selectCoderesultByNo(Long no);

    /**
     * 查询扫码记录列表
     * 
     * @param coderesult 扫码记录
     * @return 扫码记录集合
     */
    public List<Coderesult> selectCoderesultList(Coderesult coderesult);


    /**
     * 新增扫码记录
     * 
     * @param coderesult 扫码记录
     * @return 结果
     */
    public int insertCoderesult(Coderesult coderesult);

    /**
     * 修改扫码记录
     * 
     * @param coderesult 扫码记录
     * @return 结果
     */
    public int updateCoderesult(Coderesult coderesult);

    /**
     * 删除扫码记录
     * 
     * @param no 扫码记录主键
     * @return 结果
     */
    public int deleteCoderesultByNo(Long no);

    /**
     * 批量删除扫码记录
     * 
     * @param nos 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCoderesultByNos(String[] nos);
}
