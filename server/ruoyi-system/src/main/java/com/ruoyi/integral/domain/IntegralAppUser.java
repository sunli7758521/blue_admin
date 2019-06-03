package com.ruoyi.integral.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 积分项申请方式 关联 用户表 integral_app_user
 * 
 * @author sunli
 * @date 2019-05-29
 */
public class IntegralAppUser extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 积分项关联用户 申请方式 主键 */
	private Long userMenuId;
	/** 用户主键 */
	private Long userId;
	/**  */
	private Long menuId;
	/** 申请方式(0.一天  1一周 2.一月 3.一年) */
	private String appType;
	/** 创建时间 */
	private Date createTime;

	public void setUserMenuId(Long userMenuId) 
	{
		this.userMenuId = userMenuId;
	}

	public Long getUserMenuId() 
	{
		return userMenuId;
	}
	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getUserId() 
	{
		return userId;
	}
	public void setMenuId(Long menuId) 
	{
		this.menuId = menuId;
	}

	public Long getMenuId() 
	{
		return menuId;
	}
	public void setAppType(String appType) 
	{
		this.appType = appType;
	}

	public String getAppType() 
	{
		return appType;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userMenuId", getUserMenuId())
            .append("userId", getUserId())
            .append("menuId", getMenuId())
            .append("appType", getAppType())
            .append("createTime", getCreateTime())
            .toString();
    }
}
