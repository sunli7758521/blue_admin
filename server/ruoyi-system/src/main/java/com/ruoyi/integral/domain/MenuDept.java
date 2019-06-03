package com.ruoyi.integral.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 积分项关联部门表 menu_dept
 * 
 * @author sunli
 * @date 2019-05-20
 */
public class MenuDept extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 积分项关联部门id */
	private Long menuDeptId;
	/** 积分项id */
	private Long menuId;
	/** 部门id */
	private Long deptId;
	/** 部门 ids */
	private String deptIds;

	public String getDeptIds() {
		return deptIds;
	}

	public void setDeptIds(String deptIds) {
		this.deptIds = deptIds;
	}

	public void setMenuDeptId(Long menuDeptId) 
	{
		this.menuDeptId = menuDeptId;
	}

	public Long getMenuDeptId() 
	{
		return menuDeptId;
	}
	public void setMenuId(Long menuId) 
	{
		this.menuId = menuId;
	}

	public Long getMenuId() 
	{
		return menuId;
	}
	public void setDeptId(Long deptId) 
	{
		this.deptId = deptId;
	}

	public Long getDeptId() 
	{
		return deptId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("menuDeptId", getMenuDeptId())
            .append("menuId", getMenuId())
            .append("deptId", getDeptId())
            .toString();
    }
}
