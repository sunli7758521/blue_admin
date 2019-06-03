package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 用户登录记录表 user_login_log
 * 
 * @author sunli
 * @date 2019-05-21
 */
public class UserLoginLog extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 用户登录日志记录 主键 */
	private Long userLogId;
	/** 用户id */
	private Long userId;
	/** 用户登录时间 */
	private Date userLoginTime;
	/** 用户名称*/
	private String userName;
	/** 登录次数*/
	private Long loginNum;

	public Long getLoginNum() {
		return loginNum;
	}

	public void setLoginNum(Long loginNum) {
		this.loginNum = loginNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserLogId(Long userLogId)
	{
		this.userLogId = userLogId;
	}

	public Long getUserLogId() 
	{
		return userLogId;
	}
	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getUserId() 
	{
		return userId;
	}
	public void setUserLoginTime(Date userLoginTime) 
	{
		this.userLoginTime = userLoginTime;
	}

	public Date getUserLoginTime() 
	{
		return userLoginTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userLogId", getUserLogId())
            .append("userId", getUserId())
            .append("userLoginTime", getUserLoginTime())
            .toString();
    }
}
