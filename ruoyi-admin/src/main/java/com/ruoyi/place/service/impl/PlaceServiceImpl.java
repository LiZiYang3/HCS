package com.ruoyi.place.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.place.mapper.PlaceMapper;
import com.ruoyi.place.domain.Place;
import com.ruoyi.place.service.IPlaceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 场所码信息Service业务层处理
 * 
 * @author lzy
 * @date 2022-12-04
 */
@Service
public class PlaceServiceImpl implements IPlaceService 
{
    @Autowired
    private PlaceMapper placeMapper;

    /**
     * 查询场所码信息
     * 
     * @param no 场所码信息主键
     * @return 场所码信息
     */
    @Override
    public Place selectPlaceByNo(Long no)
    {
        return placeMapper.selectPlaceByNo(no);
    }

    /**
     * 查询场所码信息列表
     * 
     * @param place 场所码信息
     * @return 场所码信息
     */
    @Override
    public List<Place> selectPlaceList(Place place)
    {
        return placeMapper.selectPlaceList(place);
    }

    /**
     * 新增场所码信息
     * 
     * @param place 场所码信息
     * @return 结果
     */
    @Override
    public int insertPlace(Place place)
    {
        return placeMapper.insertPlace(place);
    }

    /**
     * 修改场所码信息
     * 
     * @param place 场所码信息
     * @return 结果
     */
    @Override
    public int updatePlace(Place place)
    {
        return placeMapper.updatePlace(place);
    }

    /**
     * 批量删除场所码信息
     * 
     * @param nos 需要删除的场所码信息主键
     * @return 结果
     */
    @Override
    public int deletePlaceByNos(String nos)
    {
        return placeMapper.deletePlaceByNos(Convert.toStrArray(nos));
    }

    /**
     * 删除场所码信息信息
     * 
     * @param no 场所码信息主键
     * @return 结果
     */
    @Override
    public int deletePlaceByNo(Long no)
    {
        return placeMapper.deletePlaceByNo(no);
    }
}
