package com.ruoyi.place.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 场所码信息对象 place
 * 
 * @author lzy
 * @date 2022-12-04
 */
public class Place extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long no;

    /** 场所编号 */
    @Excel(name = "场所编号")
    private String pid;

    /** 场所名称 */
    @Excel(name = "场所名称")
    private String placeName;

    /** 风险等级 */
    @Excel(name = "风险等级")
    private String riskGrade;

    /** 场所码URL */
    @Excel(name = "场所码URL")
    private String placeCodeURL;

    /** 扫码人数 */
    @Excel(name = "扫码人数")
    private Integer personNumber;

    public void setNo(Long no) 
    {
        this.no = no;
    }

    public Long getNo() 
    {
        return no;
    }
    public void setPid(String pid) 
    {
        this.pid = pid;
    }

    public String getPid() 
    {
        return pid;
    }
    public void setPlaceName(String placeName) 
    {
        this.placeName = placeName;
    }

    public String getPlaceName() 
    {
        return placeName;
    }
    public void setRiskGrade(String riskGrade) 
    {
        this.riskGrade = riskGrade;
    }

    public String getRiskGrade() 
    {
        return riskGrade;
    }
    public void setPlaceCodeURL(String placeCodeURL) 
    {
        this.placeCodeURL = placeCodeURL;
    }

    public String getPlaceCodeURL() 
    {
        return placeCodeURL;
    }
    public void setPersonNumber(Integer personNumber) 
    {
        this.personNumber = personNumber;
    }

    public Integer getPersonNumber() 
    {
        return personNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("no", getNo())
            .append("pid", getPid())
            .append("placeName", getPlaceName())
            .append("riskGrade", getRiskGrade())
            .append("placeCodeURL", getPlaceCodeURL())
            .append("personNumber", getPersonNumber())
            .toString();
    }
}
