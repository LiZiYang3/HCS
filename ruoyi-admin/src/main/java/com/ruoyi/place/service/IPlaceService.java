package com.ruoyi.place.service;

import java.util.List;
import com.ruoyi.place.domain.Place;

/**
 * 场所码信息Service接口
 * 
 * @author lzy
 * @date 2022-12-04
 */
public interface IPlaceService 
{
    /**
     * 查询场所码信息
     * 
     * @param no 场所码信息主键
     * @return 场所码信息
     */
    public Place selectPlaceByNo(Long no);

    /**
     * 查询场所码信息列表
     * 
     * @param place 场所码信息
     * @return 场所码信息集合
     */
    public List<Place> selectPlaceList(Place place);

    /**
     * 新增场所码信息
     * 
     * @param place 场所码信息
     * @return 结果
     */
    public int insertPlace(Place place);

    /**
     * 修改场所码信息
     * 
     * @param place 场所码信息
     * @return 结果
     */
    public int updatePlace(Place place);

    /**
     * 批量删除场所码信息
     * 
     * @param nos 需要删除的场所码信息主键集合
     * @return 结果
     */
    public int deletePlaceByNos(String nos);

    /**
     * 删除场所码信息信息
     * 
     * @param no 场所码信息主键
     * @return 结果
     */
    public int deletePlaceByNo(Long no);
}
