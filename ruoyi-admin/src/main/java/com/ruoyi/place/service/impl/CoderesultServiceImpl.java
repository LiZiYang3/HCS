package com.ruoyi.place.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.place.mapper.CoderesultMapper;
import com.ruoyi.place.domain.Coderesult;
import com.ruoyi.place.service.ICoderesultService;
import com.ruoyi.common.core.text.Convert;

/**
 * 扫码记录Service业务层处理
 * 
 * @author lzy
 * @date 2022-12-04
 */
@Service
public class CoderesultServiceImpl implements ICoderesultService 
{
    @Autowired
    private CoderesultMapper coderesultMapper;

    /**
     * 查询扫码记录
     * 
     * @param no 扫码记录主键
     * @return 扫码记录
     */
    @Override
    public Coderesult selectCoderesultByNo(Long no)
    {
        return coderesultMapper.selectCoderesultByNo(no);
    }

    /**
     * 查询扫码记录列表
     * 
     * @param coderesult 扫码记录
     * @return 扫码记录
     */
    @Override
    public List<Coderesult> selectCoderesultList(Coderesult coderesult)
    {
        return coderesultMapper.selectCoderesultList(coderesult);
    }

    /**
     * 新增扫码记录
     * 
     * @param coderesult 扫码记录
     * @return 结果
     */
    @Override
    public int insertCoderesult(Coderesult coderesult)
    {
        return coderesultMapper.insertCoderesult(coderesult);
    }

    /**
     * 修改扫码记录
     * 
     * @param coderesult 扫码记录
     * @return 结果
     */
    @Override
    public int updateCoderesult(Coderesult coderesult)
    {
        return coderesultMapper.updateCoderesult(coderesult);
    }

    /**
     * 批量删除扫码记录
     * 
     * @param nos 需要删除的扫码记录主键
     * @return 结果
     */
    @Override
    public int deleteCoderesultByNos(String nos)
    {
        return coderesultMapper.deleteCoderesultByNos(Convert.toStrArray(nos));
    }

    /**
     * 删除扫码记录信息
     * 
     * @param no 扫码记录主键
     * @return 结果
     */
    @Override
    public int deleteCoderesultByNo(Long no)
    {
        return coderesultMapper.deleteCoderesultByNo(no);
    }
}
