package com.ruoyi.integral.domain;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 积分日志表 integral_log
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
public class IntegralLog extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 积分日志 */
	private Integer logId;
	/** 审批编号 */
	@Excel(name = "审批编号")
	private String approvalNum;
	/** 关联用户id */
	private Integer userId;
	/** 积分表的主键 */
	private Integer integralId;
	/** 员工手机号 */
	@Excel(name = "员工手机号")
	private Long userPhone;
	/** 员工姓名 */
	@Excel(name = "员工姓名")
	private String userName;
	/** 员工头像 */
	private String userImg;
	/** 员工部门 */
	@Excel(name = "员工部门")
	private String userDept;
	/** 员工职位 */
	@Excel(name = "员工职位")
	private String userPost;
	/** 申请积分项目标题 */
	@Excel(name = "申请积分项目标题")
	private String integralTitle;
	/** 积分内容 */
	@Excel(name = "积分内容")
	private String integralContent;
	/** 变动积分(所为刚才加的积分) */
	@Excel(name = "加积分")
	private Integer bianIntegral;
	/** 积分类型 */
	private Integer typeId;
	/** 获取积分时间 */
	@Excel(name = "获取积分时间")
	private String getTime;
	/** 转态 （0正常    1.撤销刚才所加的积分） */
	private Integer status;
	/** 备注 扣除积分 */

	private String remark;

	/** 扣除积分类型 */
	@Excel(name = "扣除积分")
	private Integer kIntegral;
	/** 积分类型名称*/
	@Excel(name = "积分类型名称")
	private String typeName;

	public String getGetTime() {
		return getTime;
	}

	public void setGetTime(String getTime) {
		this.getTime = getTime;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(Long userPhone) {
		this.userPhone = userPhone;
	}

	public Integer getkIntegral() {
		return kIntegral;
	}

	public void setkIntegral(Integer kIntegral) {
		this.kIntegral = kIntegral;
	}

	public void setLogId(Integer logId) 
	{
		this.logId = logId;
	}

	public Integer getLogId() 
	{
		return logId;
	}
	public void setApprovalNum(String approvalNum) 
	{
		this.approvalNum = approvalNum;
	}

	public String getApprovalNum() 
	{
		return approvalNum;
	}
	public void setUserId(Integer userId) 
	{
		this.userId = userId;
	}

	public Integer getUserId() 
	{
		return userId;
	}
	public void setIntegralId(Integer integralId) 
	{
		this.integralId = integralId;
	}

	public Integer getIntegralId() 
	{
		return integralId;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserName() 
	{
		return userName;
	}
	public void setUserImg(String userImg) 
	{
		this.userImg = userImg;
	}

	public String getUserImg() 
	{
		return userImg;
	}
	public void setUserDept(String userDept) 
	{
		this.userDept = userDept;
	}

	public String getUserDept() 
	{
		return userDept;
	}
	public void setUserPost(String userPost) 
	{
		this.userPost = userPost;
	}

	public String getUserPost() 
	{
		return userPost;
	}
	public void setIntegralTitle(String integralTitle) 
	{
		this.integralTitle = integralTitle;
	}

	public String getIntegralTitle() 
	{
		return integralTitle;
	}
	public void setIntegralContent(String integralContent) 
	{
		this.integralContent = integralContent;
	}

	public String getIntegralContent() 
	{
		return integralContent;
	}
	public void setBianIntegral(Integer bianIntegral) 
	{
		this.bianIntegral = bianIntegral;
	}

	public Integer getBianIntegral() 
	{
		return bianIntegral;
	}
	public void setTypeId(Integer typeId) 
	{
		this.typeId = typeId;
	}

	public Integer getTypeId() 
	{
		return typeId;
	}
//	public void setGetTime(Date getTime)
//	{
//		this.getTime = getTime;
//	}
//
//	public Date getGetTime()
//	{
//		return getTime;
//	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
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
            .append("logId", getLogId())
            .append("approvalNum", getApprovalNum())
            .append("userId", getUserId())
            .append("integralId", getIntegralId())
            .append("userPhone", getUserPhone())
            .append("userName", getUserName())
            .append("userImg", getUserImg())
            .append("userDept", getUserDept())
            .append("userPost", getUserPost())
            .append("integralTitle", getIntegralTitle())
            .append("integralContent", getIntegralContent())
            .append("bianIntegral", getBianIntegral())
            .append("typeId", getTypeId())
            .append("getTime", getGetTime())
            .append("status", getStatus())
            .append("remark", getRemark())
			.append("kIntegral", getkIntegral())
            .toString();
    }
}
