package com.ruoyi.integral.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 员工爱心点赞表 give_like
 *
 * @author sunli
 * @date 2018-12-24
 */
public class GiveLike extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 点赞表的主键 */
	private Integer dId;
	/** 用户id */
	private Integer userId;
	/**
	 * 点赞用户名
	 */
	private String userName;
	/**
	 *
	 */
	private String userImgPath;
	/** 受益人的id */
	private Integer benefitId;
	/**
	 * 收益用户名
	 */
	private String benUserName;
	/**
	 *
	 */
	private String benImgPath;
	/**
	 * 部门名称
	 */
	private String deptName;
	/** 受益时间 */
	private Date careateTime;
	/**爱心点赞  */
	private Integer loveIntegral;
	/** 总积分 */
	private Integer countIntefral;
	/**
	 * 职称名称
	 */
	private String postName;

	public void setDId(Integer dId)
	{
		this.dId = dId;
	}

	public Integer getDId()
	{
		return dId;
	}
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public Integer getUserId()
	{
		return userId;
	}
	public void setBenefitId(Integer benefitId)
	{
		this.benefitId = benefitId;
	}

	public Integer getBenefitId()
	{
		return benefitId;
	}
	public void setCareateTime(Date careateTime)
	{
		this.careateTime = careateTime;
	}

	public Date getCareateTime()
	{
		return careateTime;
	}
	public void setLoveIntegral(Integer loveIntegral)
	{
		this.loveIntegral = loveIntegral;
	}

	public Integer getLoveIntegral()
	{
		return loveIntegral;
	}
	public void setCountIntefral(Integer countIntefral)
	{
		this.countIntefral = countIntefral;
	}

	public Integer getCountIntefral()
	{
		return countIntefral;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserImgPath() {
		return userImgPath;
	}

	public void setUserImgPath(String userImgPath) {
		this.userImgPath = userImgPath;
	}

	public String getBenUserName() {
		return benUserName;
	}

	public void setBenUserName(String benUserName) {
		this.benUserName = benUserName;
	}

	public String getBenImgPath() {
		return benImgPath;
	}

	public void setBenImgPath(String benImgPath) {
		this.benImgPath = benImgPath;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("dId", getDId())
				.append("userId", getUserId())
				.append("benefitId", getBenefitId())
				.append("careateTime", getCareateTime())
				.append("loveIntegral", getLoveIntegral())
				.append("countIntefral", getCountIntefral())
				.toString();
	}
}
