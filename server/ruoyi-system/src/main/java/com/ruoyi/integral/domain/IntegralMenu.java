package com.ruoyi.integral.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 *  积分菜单管理表 integral_menu
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
public class IntegralMenu extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 菜单主键 */
	private Integer menuId;
	/** 行为类别 */
	private String typeName;
	/** 行为类别 */
	private Integer typeId;
	/** 子类别个数 */
	private Integer typeCount;
	/** 状态 0正常  1禁用 */
	private Integer status;
	/** 创建时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;
	/** 备注 */
	private String remark;
	/** 关联部门主键 */
	private Integer deptId;
	/** 职位主键 */
	private Integer postId;

    /** 父部门ID */
    private Long parentId;
    /** 祖级列表 */
    private String ancestors;
    /** 显示顺序 */
    private String orderNum;

	/** 显示A子项目个数 */
	private Integer countA;
	/** 显示A子项目个数 */
	private Integer countB;
	/** 显示A子项目个数 */
	private Integer countC;
	/** 显示A子项目个数 */
	private Integer count;
	/** 父名称 */
	private String parentName;

	/** 部门ids */
	private String deptIds;

	public String getDeptIds() {
		return deptIds;
	}

	public void setDeptIds(String deptIds) {
		this.deptIds = deptIds;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCountA() {
		return countA;
	}

	public void setCountA(Integer countA) {
		this.countA = countA;
	}

	public Integer getCountB() {
		return countB;
	}

	public void setCountB(Integer countB) {
		this.countB = countB;
	}

	public Integer getCountC() {
		return countC;
	}

	public void setCountC(Integer countC) {
		this.countC = countC;
	}

	public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getAncestors() {
        return ancestors;
    }

    public void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    /** 职位名称 */
	private String postName;
	/** 部门名称 */
	private String deptName;

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

	public void setMenuId(Integer menuId)
	{
		this.menuId = menuId;
	}

	public Integer getMenuId() 
	{
		return menuId;
	}
	public void setTypeName(String typeName) 
	{
		this.typeName = typeName;
	}

	public String getTypeName() 
	{
		return typeName;
	}
	public void setTypeId(Integer typeId) 
	{
		this.typeId = typeId;
	}

	public Integer getTypeId() 
	{
		return typeId;
	}
	public void setTypeCount(Integer typeCount) 
	{
		this.typeCount = typeCount;
	}

	public Integer getTypeCount() 
	{
		return typeCount;
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
            .append("menuId", getMenuId())
            .append("typeName", getTypeName())
            .append("typeId", getTypeId())
            .append("typeCount", getTypeCount())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
			.append("postId", getPostId())
			.append("deptId", getDeptId())
            .append("parentId", getParentId())
            .append("ancestors", getAncestors())
            .append("orderNum", getOrderNum())
            .toString();
    }
}
