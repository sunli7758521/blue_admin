package com.ruoyi.integral.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 审批流程人员设置表 integral_splc
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
public class IntegralSplc extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 审批流程 主键 */
	private Integer lcId;
	/** 审批流程名称 */
	private String spName;
	/** 部门关联的id */
	private Integer deptId;
	/** 创建时间 */
	private Date creatTime;
	/** 更新时间 */
	private Date updateTime;
	/** 备注 */
	private String remark;

	public void setLcId(Integer lcId) 
	{
		this.lcId = lcId;
	}

	public Integer getLcId() 
	{
		return lcId;
	}
	public void setSpName(String spName) 
	{
		this.spName = spName;
	}

	public String getSpName() 
	{
		return spName;
	}
	public void setDeptId(Integer deptId) 
	{
		this.deptId = deptId;
	}

	public Integer getDeptId() 
	{
		return deptId;
	}
	public void setCreatTime(Date creatTime) 
	{
		this.creatTime = creatTime;
	}

	public Date getCreatTime() 
	{
		return creatTime;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("lcId", getLcId())
            .append("spName", getSpName())
            .append("deptId", getDeptId())
            .append("creatTime", getCreatTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
