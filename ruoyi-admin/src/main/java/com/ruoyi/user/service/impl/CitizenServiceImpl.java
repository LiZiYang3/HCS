package com.ruoyi.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //统计
    @Override
    public ArrayList<Map<String, String>> getCitizenCodeColor() {
        ArrayList<Map<String,String>> list = new ArrayList<>();
        Integer green_count_0 = 0;
        Integer yellow_count_1 = 0;
        Integer red_count_2 = 0;


        List<Citizen> citizens = citizenMapper.selectCitizenList(new Citizen());
        for (Citizen user : citizens) {
            if ( "0".equals(user.getHealthCode()) ) {
                green_count_0 = green_count_0 + 1;
            }else if("1".equals(user.getHealthCode())){
                yellow_count_1 = yellow_count_1 + 1;
            }else{
                red_count_2 = red_count_2 + 1;
            }
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("name","绿");
        map.put("value",green_count_0.toString());
        list.add(map);
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("name","黄");
        map1.put("value",yellow_count_1.toString());
        list.add(map1);
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("name","红");
        map2.put("value",red_count_2.toString());
        list.add(map2);

        return list;
    }
}
