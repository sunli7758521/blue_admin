package com.ruoyi.task.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 任务标题员工表 reward_task_user
 * 
 * @author sunli
 * @date 2018-12-31
 */
public class RewardTaskUser extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Integer rtuId;
	/** 任务标题主键 */
	private Integer rtId;
	/** 用户主键 */
	private Integer userId;
	/** 状态  0.抢单中，1.已完成，2.未抢单 */
	private String state;
	/** 创建时间 */
	private Date createDate;

	public void setRtuId(Integer rtuId) 
	{
		this.rtuId = rtuId;
	}

	public Integer getRtuId() 
	{
		return rtuId;
	}
	public void setRtId(Integer rtId) 
	{
		this.rtId = rtId;
	}

	public Integer getRtId() 
	{
		return rtId;
	}
	public void setUserId(Integer userId) 
	{
		this.userId = userId;
	}

	public Integer getUserId() 
	{
		return userId;
	}
	public void setState(String state) 
	{
		this.state = state;
	}

	public String getState() 
	{
		return state;
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
            .append("rtuId", getRtuId())
            .append("rtId", getRtId())
            .append("userId", getUserId())
            .append("state", getState())
            .append("createDate", getCreateDate())
            .toString();
    }
}
