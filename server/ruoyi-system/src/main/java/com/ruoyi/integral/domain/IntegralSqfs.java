package com.ruoyi.integral.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 积分申请方式表 integral_sqfs
 * 
 * @author sunli
 * @date 2018-11-01
 */
public class IntegralSqfs extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 申请方式 */
	private Integer sqfsId;
	/** 申请方式名称 */
	private String sqName;

	public void setSqfsId(Integer sqfsId) 
	{
		this.sqfsId = sqfsId;
	}

	public Integer getSqfsId() 
	{
		return sqfsId;
	}
	public void setSqName(String sqName) 
	{
		this.sqName = sqName;
	}

	public String getSqName() 
	{
		return sqName;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sqfsId", getSqfsId())
            .append("sqName", getSqName())
            .toString();
    }
}
