package com.ruoyi.place.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 扫码记录对象 coderesult
 * 
 * @author lzy
 * @date 2022-12-04
 */
public class Coderesult extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long no;

    /** 场所码编号 */
    @Excel(name = "场所码编号")
    private String pid;

    /** 扫码时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "扫码时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 市民身份证号 */
    @Excel(name = "市民身份证号")
    private String id;

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
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("no", getNo())
            .append("pid", getPid())
            .append("time", getTime())
            .append("id", getId())
            .toString();
    }
}
