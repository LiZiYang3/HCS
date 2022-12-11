package com.ruoyi.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ruoyi.user.domain.Citizen;

/**
 * 市民信息Service接口
 * 
 * @author lzy
 * @date 2022-12-04
 */
public interface ICitizenService 
{
    /**
     * 查询市民信息
     * 
     * @param no 市民信息主键
     * @return 市民信息
     */
    public Citizen selectCitizenByNo(Long no);

    /**
     * 查询市民信息列表
     * 
     * @param citizen 市民信息
     * @return 市民信息集合
     */
    public List<Citizen> selectCitizenList(Citizen citizen);

    /**
     * 新增市民信息
     * 
     * @param citizen 市民信息
     * @return 结果
     */
    public int insertCitizen(Citizen citizen);

    /**
     * 修改市民信息
     * 
     * @param citizen 市民信息
     * @return 结果
     */
    public int updateCitizen(Citizen citizen);

    /**
     * 批量删除市民信息
     * 
     * @param nos 需要删除的市民信息主键集合
     * @return 结果
     */
    public int deleteCitizenByNos(String nos);

    /**
     * 删除市民信息信息
     * 
     * @param no 市民信息主键
     * @return 结果
     */
    public int deleteCitizenByNo(Long no);

    public ArrayList<Map<String, String>> getCitizenCodeColor();
}
