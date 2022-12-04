package com.ruoyi.user.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.user.mapper.CitizenMapper;
import com.ruoyi.user.domain.Citizen;
import com.ruoyi.user.service.ICitizenService;
import com.ruoyi.common.core.text.Convert;

/**
 * 市民信息Service业务层处理
 * 
 * @author lzy
 * @date 2022-12-04
 */
@Service
public class CitizenServiceImpl implements ICitizenService 
{
    @Autowired
    private CitizenMapper citizenMapper;

    /**
     * 查询市民信息
     * 
     * @param no 市民信息主键
     * @return 市民信息
     */
    @Override
    public Citizen selectCitizenByNo(Long no)
    {
        return citizenMapper.selectCitizenByNo(no);
    }

    /**
     * 查询市民信息列表
     * 
     * @param citizen 市民信息
     * @return 市民信息
     */
    @Override
    public List<Citizen> selectCitizenList(Citizen citizen)
    {
        return citizenMapper.selectCitizenList(citizen);
    }

    /**
     * 新增市民信息
     * 
     * @param citizen 市民信息
     * @return 结果
     */
    @Override
    public int insertCitizen(Citizen citizen)
    {
        return citizenMapper.insertCitizen(citizen);
    }

    /**
     * 修改市民信息
     * 
     * @param citizen 市民信息
     * @return 结果
     */
    @Override
    public int updateCitizen(Citizen citizen)
    {
        return citizenMapper.updateCitizen(citizen);
    }

    /**
     * 批量删除市民信息
     * 
     * @param nos 需要删除的市民信息主键
     * @return 结果
     */
    @Override
    public int deleteCitizenByNos(String nos)
    {
        return citizenMapper.deleteCitizenByNos(Convert.toStrArray(nos));
    }

    /**
     * 删除市民信息信息
     * 
     * @param no 市民信息主键
     * @return 结果
     */
    @Override
    public int deleteCitizenByNo(Long no)
    {
        return citizenMapper.deleteCitizenByNo(no);
    }
}
