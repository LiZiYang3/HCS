package com.ruoyi.detection.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 检测结果对象 detectionresult
 * 
 * @author lzy
 * @date 2022-12-04
 */
public class Detectionresult extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long no;

    /** 试管编号 */
    @Excel(name = "试管编号")
    private String tid;

    /** 市民身份证号 */
    @Excel(name = "市民身份证号")
    private String id;

    /** 检测结果 */
    @Excel(name = "检测结果")
    private String result;

    /** 检测时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "检测时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

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
    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setResult(String result) 
    {
        this.result = result;
    }

    public String getResult() 
    {
        return result;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("no", getNo())
            .append("tid", getTid())
            .append("id", getId())
            .append("result", getResult())
            .append("time", getTime())
            .toString();
    }
}
