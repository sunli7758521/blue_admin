package com.ruoyi.task.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 任务类型表 task_type
 * 
 * @author sunli
 * @date 2018-12-24
 */
public class TaskType extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Integer taskId;
	/** 任务类型名称 */
	private String taskName;

	public void setTaskId(Integer taskId) 
	{
		this.taskId = taskId;
	}

	public Integer getTaskId() 
	{
		return taskId;
	}
	public void setTaskName(String taskName) 
	{
		this.taskName = taskName;
	}

	public String getTaskName() 
	{
		return taskName;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("taskId", getTaskId())
            .append("taskName", getTaskName())
            .toString();
    }
}
