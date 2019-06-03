package com.ruoyi.work.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 工作台应用管理表 gzd
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
public class Gzd extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 工作台主键 */
	private Integer gztId;
	/** 应用图标 */
	private String yyImg;
	/** 应用标题 */
	private String yyTitle;
	/** 应用管理 */
	private String yyType;
	/** 状态,（0使用中 1 停用  2开启抽奖，3管理愿望分 4爱心个数） */
	private String status;
	/** 创建时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;
	/** 备注 */
	private String remark;
	/** 图标在工作台对应的位置*/
	private String sort;
	/**抽奖状态*/
	private String lotteryStatus;

	public void setGztId(Integer gztId) 
	{
		this.gztId = gztId;
	}

	public Integer getGztId() 
	{
		return gztId;
	}
	public void setYyImg(String yyImg) 
	{
		this.yyImg = yyImg;
	}

	public String getYyImg() 
	{
		return yyImg;
	}
	public void setYyTitle(String yyTitle) 
	{
		this.yyTitle = yyTitle;
	}

	public String getYyTitle() 
	{
		return yyTitle;
	}
	public void setYyType(String yyType) 
	{
		this.yyType = yyType;
	}

	public String getYyType() 
	{
		return yyType;
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
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getLotteryStatus() {
		return lotteryStatus;
	}

	public void setLotteryStatus(String lotteryStatus) {
		this.lotteryStatus = lotteryStatus;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("gztId", getGztId())
            .append("yyImg", getYyImg())
            .append("yyTitle", getYyTitle())
            .append("yyType", getYyType())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
			.append("sort", getSort())
			.append("lotteryStatus", getLotteryStatus())
            .toString();
    }

}
