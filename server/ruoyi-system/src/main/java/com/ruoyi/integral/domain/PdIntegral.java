package com.ruoyi.integral.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 品德A积分管理表 pd_integral
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
public class PdIntegral extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 行为积分主键 */
	private Integer behaviorId;
	/** 类别 */
	private String behaviorCategory;
	/** 行为标题 */
	private String behaviorTitle;
	/** 行为内容 */
	private String behaviorContent;
	/** 申请方式 */
	private String shenQingFangShi;
	/** 类型 */
	private Integer typeId;
	/** 最多奖励 */
	private String zuiDuoIntegral;
	/** 最少奖励积分 */
	private String zuiShaoIntegral;
	/** 积分分级 */
	private Integer integralFenJi;
	/** 已完成次数 */
	private Integer yiWanChengCiShu;
	/** 使用转态 0,使用中  1.停用 */
	private Integer status;
	/** 创建时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;
	/** 备注 */
	private String remark;

	/** 餐单类型名称 */
	private String menuType;
	/** 餐单类型id */
	private String menuId;

	/** 职位名称 */
	private String postName;
	/** 部门名称 */
	private String deptName;
	/** 关联部门主键 */
	private Integer deptId;
	/** 职位主键 */
	private Integer postId;

	/** 部门的ids */
	private String deptIds;

	public String getDeptIds() {
		return deptIds;
	}

	public void setDeptIds(String deptIds) {
		this.deptIds = deptIds;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}




	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public void setBehaviorId(Integer behaviorId)
	{
		this.behaviorId = behaviorId;
	}

	public Integer getBehaviorId() 
	{
		return behaviorId;
	}
	public void setBehaviorCategory(String behaviorCategory) 
	{
		this.behaviorCategory = behaviorCategory;
	}

	public String getBehaviorCategory() 
	{
		return behaviorCategory;
	}
	public void setBehaviorTitle(String behaviorTitle) 
	{
		this.behaviorTitle = behaviorTitle;
	}

	public String getBehaviorTitle() 
	{
		return behaviorTitle;
	}
	public void setBehaviorContent(String behaviorContent) 
	{
		this.behaviorContent = behaviorContent;
	}

	public String getBehaviorContent() 
	{
		return behaviorContent;
	}
	public void setShenQingFangShi(String shenQingFangShi) 
	{
		this.shenQingFangShi = shenQingFangShi;
	}

	public String getShenQingFangShi() 
	{
		return shenQingFangShi;
	}
	public void setTypeId(Integer typeId) 
	{
		this.typeId = typeId;
	}

	public Integer getTypeId() 
	{
		return typeId;
	}
	public void setZuiDuoIntegral(String zuiDuoIntegral) 
	{
		this.zuiDuoIntegral = zuiDuoIntegral;
	}

	public String getZuiDuoIntegral() 
	{
		return zuiDuoIntegral;
	}
	public void setZuiShaoIntegral(String zuiShaoIntegral) 
	{
		this.zuiShaoIntegral = zuiShaoIntegral;
	}

	public String getZuiShaoIntegral() 
	{
		return zuiShaoIntegral;
	}
	public void setIntegralFenJi(Integer integralFenJi) 
	{
		this.integralFenJi = integralFenJi;
	}

	public Integer getIntegralFenJi() 
	{
		return integralFenJi;
	}
	public void setYiWanChengCiShu(Integer yiWanChengCiShu) 
	{
		this.yiWanChengCiShu = yiWanChengCiShu;
	}

	public Integer getYiWanChengCiShu() 
	{
		return yiWanChengCiShu;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("behaviorId", getBehaviorId())
            .append("behaviorCategory", getBehaviorCategory())
            .append("behaviorTitle", getBehaviorTitle())
            .append("behaviorContent", getBehaviorContent())
            .append("shenQingFangShi", getShenQingFangShi())
            .append("typeId", getTypeId())
            .append("zuiDuoIntegral", getZuiDuoIntegral())
            .append("zuiShaoIntegral", getZuiShaoIntegral())
            .append("integralFenJi", getIntegralFenJi())
            .append("yiWanChengCiShu", getYiWanChengCiShu())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
			.append("menuId", getMenuId())
			.append("deptName", getDeptName())
			.append("postName", getPostName())
			.append("postId", getPostId())
			.append("deptId", getDeptId())
            .toString();
    }
}
