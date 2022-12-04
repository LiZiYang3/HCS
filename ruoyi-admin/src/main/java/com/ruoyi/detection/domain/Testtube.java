package com.ruoyi.detection.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 试管信息对象 testtube
 * 
 * @author lzy
 * @date 2022-12-04
 */
public class Testtube extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long no;

    /** 试管编号 */
    @Excel(name = "试管编号")
    private String tid;

    /** 检测人员身份证号 */
    @Excel(name = "检测人员身份证号")
    private String sid;

    /** 试管创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "试管创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 检测结果 */
    @Excel(name = "检测结果")
    private String result;

    /** 检测机构 */
    @Excel(name = "检测机构")
    private String organization;

    /** 最多检测人数 */
    @Excel(name = "最多检测人数")
    private Integer maxNum;

    public void setNo(Long no) 
    {
        this.no = no;
    }

    public Long getNo() 
    {
        return no;
    }
    public void setTid(String tid) 
    {
        this.tid = tid;
    }

    public String getTid() 
    {
        return tid;
    }
    public void setSid(String sid) 
    {
        this.sid = sid;
    }

    public String getSid() 
    {
        return sid;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setResult(String result) 
    {
        this.result = result;
    }

    public String getResult() 
    {
        return result;
    }
    public void setOrganization(String organization) 
    {
        this.organization = organization;
    }

    public String getOrganization() 
    {
        return organization;
    }
    public void setMaxNum(Integer maxNum) 
    {
        this.maxNum = maxNum;
    }

    public Integer getMaxNum() 
    {
        return maxNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("no", getNo())
            .append("tid", getTid())
            .append("sid", getSid())
            .append("time", getTime())
            .append("result", getResult())
            .append("organization", getOrganization())
            .append("maxNum", getMaxNum())
            .toString();
    }
}
