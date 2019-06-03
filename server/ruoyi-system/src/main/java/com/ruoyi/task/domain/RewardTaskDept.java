package com.ruoyi.task.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 任务标题部门表 reward_task_dept
 * 
 * @author sunli
 * @date 2018-12-31
 */
public class RewardTaskDept extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Integer rtdId;
	/** 任务列表主键 */
	private Integer rtId;
	/** 部门主键 */
	private Integer dId;
	/** 创建时间 */
	private Date createDate;

	public void setRtdId(Integer rtdId) 
	{
		this.rtdId = rtdId;
	}

	public Integer getRtdId() 
	{
		return rtdId;
	}
	public void setRtId(Integer rtId) 
	{
		this.rtId = rtId;
	}

	public Integer getRtId() 
	{
		return rtId;
	}
	public void setDId(Integer dId) 
	{
		this.dId = dId;
	}

	public Integer getDId() 
	{
		return dId;
	}
	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}

	public Date getCreateDate() 
	{
		return createDate;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("rtdId", getRtdId())
            .append("rtId", getRtId())
            .append("dId", getDId())
            .append("createDate", getCreateDate())
            .toString();
    }
}
