package com.ruoyi.user.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 市民信息对象 citizen
 * 
 * @author lzy
 * @date 2022-12-04
 */
public class Citizen extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long no;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phoneNumber;

    /** 健康码 */
    @Excel(name = "健康码")
    private String healthCode;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    public void setNo(Long no) 
    {
        this.no = no;
    }

    public Long getNo() 
    {
        return no;
    }
    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setHealthCode(String healthCode) 
    {
        this.healthCode = healthCode;
    }

    public String getHealthCode() 
    {
        return healthCode;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("no", getNo())
            .append("id", getId())
            .append("name", getName())
            .append("phoneNumber", getPhoneNumber())
            .append("healthCode", getHealthCode())
            .append("password", getPassword())
            .toString();
    }
}
