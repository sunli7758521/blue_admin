package com.ruoyi.task.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 悬赏任务表 reward_task
 * 
 * @author sunli
 * @date 2018-12-24
 */
public class RewardTask extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer rtId;
	/** 任务标题 */
	private String title;
	/** 任务内容 */
	private String content;
	/** 任务类型 */
	private Integer taskTypeId;
	/** 积分类型 */
	private Integer integralTypeId;
	/** 可申请方式 0 抢单任务.1 挑战仅限一次 2.每日一一次 */
	private String appWay;
	/** 任务积分数量 */
	private Integer taskIntegral;
	/** 开始时间 *//*
	private Date startTime;
	*//** 结束时间 *//*
	private Date endTime;*/

	/** 开始时间 */
	private String startTime;
	/** 结束时间 */
	private String endTime;
	/** 抢单人数 */
	private Integer peopleNum;
	/** 完成执行顺序 */
	private String sort;
	/** 使用状态 0 使用中 1 停用 */
	private String status;
	/** 创建时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;
	/** 部门ids */
	private String deptId;
	/** 备注 */
	private String remark;
	/** 发布任务的 用户id */
	private Integer releaseUserId;
	/** 角色id */
	private String roleIds;

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}



	public Integer getReleaseUserId() {
		return releaseUserId;
	}

	public void setReleaseUserId(Integer releaseUserId) {
		this.releaseUserId = releaseUserId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setRtId(Integer rtId)
	{
		this.rtId = rtId;
	}

	public Integer getRtId() 
	{
		return rtId;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}
	public void setTaskTypeId(Integer taskTypeId) 
	{
		this.taskTypeId = taskTypeId;
	}

	public Integer getTaskTypeId() 
	{
		return taskTypeId;
	}
	public void setIntegralTypeId(Integer integralTypeId) 
	{
		this.integralTypeId = integralTypeId;
	}

	public Integer getIntegralTypeId() 
	{
		return integralTypeId;
	}
	public void setAppWay(String appWay) 
	{
		this.appWay = appWay;
	}

	public String getAppWay() 
	{
		return appWay;
	}
	public void setTaskIntegral(Integer taskIntegral) 
	{
		this.taskIntegral = taskIntegral;
	}

	public Integer getTaskIntegral() 
	{
		return taskIntegral;
	}

	public void setPeopleNum(Integer peopleNum)
	{
		this.peopleNum = peopleNum;
	}

	public Integer getPeopleNum() 
	{
		return peopleNum;
	}
	public void setSort(String sort) 
	{
		this.sort = sort;
	}

	public String getSort() 
	{
		return sort;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setDeptId(String deptId) 
	{
		this.deptId = deptId;
	}

	public String getDeptId() 
	{
		return deptId;
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
            .append("rtId", getRtId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("taskTypeId", getTaskTypeId())
            .append("integralTypeId", getIntegralTypeId())
            .append("appWay", getAppWay())
            .append("taskIntegral", getTaskIntegral())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("peopleNum", getPeopleNum())
            .append("sort", getSort())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deptId", getDeptId())
            .append("remark", getRemark())
			.append("releaseUserId", getReleaseUserId())
			.append("roleIds", getRoleIds())
            .toString();
    }
}
