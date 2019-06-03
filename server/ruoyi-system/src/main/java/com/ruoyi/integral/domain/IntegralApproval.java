package com.ruoyi.integral.domain;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 审批管理表 integral_approval
 * 
 * @author sunli
 * @date 2018-10-25
 */
public class IntegralApproval extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 审批主键 */
	private Integer approvalId;
	/** 审批编号 */
	@Excel(name = "审批编号")
	private String approvalNum;
	/** 审批标题 */
	@Excel(name = "审批标题")
	private String approvalTitle;
	/** 审批内容 */
	@Excel(name = "审批内容")
	private String approvalContent;
	/** 关联用户id */
	private Integer userId;
	/** 员工姓名 */
	@Excel(name = "获得积分员工")
	private String userName;
	/** 员工头像 */
	private String userImg;
	/** 申请人电话也是唯一标识 */
	private Long userPhone;
	/** 所属部门 */
	@Excel(name = "所属部门")
	private String userDept;
	/** 部门id */
	private Integer userDeptId;
	/** 职位id */
	private Integer userPostId;
	/** 员工职位 */
	@Excel(name = "员工职位")
	private String userPost;
	/** 审请人姓名 */
	private Long tiJiaoId;
	/** 审请人姓名 */
	@Excel(name = "提交申请员工")
	private String tiJiaoName;
	/** 申请积分 */
	private String tiJiaoNameImg;
	/** 积分类型 */
	private Integer integralTypeId;
	/** 积分类型 */
	@Excel(name = "积分类型")
	private String jilx;
	private Integer typeId;
	/** 申请积分 */
	@Excel(name = "申请积分")
	private Integer sqIntegral;
	/** 申请时间 */
	@Excel(name = "申请时间")
	private String sqDate;
	private Date sqTime;

	/** 审批时间 */
	@Excel(name = "审批时间")
	private String spDate;
	private Date spTime;
	/** 审批转态(0,审批中 1审批通过，2审批不通过，3撤销审批 ) */
	@Excel(name = "审批转态")
	private String spzt;
	private Integer status;
	/** 扣除积分类型 */
	@Excel(name = "扣除积分")
	private Integer kIntegral;

	/** 审批备注 */
	private String spRemark;
	/** 申请时间 */
	private Date approvalTime;
	/** 上传图片1 */
	private String approvalImg1;
	/** 申请项的id */
	private String approvalImg2;
	/** 上传图片3 */
	private String approvalImg3;
	/** 上传图片4 */
	private String approvalImg4;
	/** 上传图片5 */
	private String approvalImg5;
	/** 0.可以申诉，1不可以申诉 */
	private String approvalImg6;
	/** 二次申诉理由 */
	private String approvalImg7;
	/** 日常，抢单，挑战 任务 id */
	private String approvalImg8;
	/** 审批不通过原因 */
	private String approvalImg9;
	/** 基础积分  */
	private String remark;

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
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

	public void setApprovalId(Integer approvalId) 
	{
		this.approvalId = approvalId;
	}

	public Integer getApprovalId() 
	{
		return approvalId;
	}
	public void setApprovalNum(String approvalNum) 
	{
		this.approvalNum = approvalNum;
	}

	public String getApprovalNum() 
	{
		return approvalNum;
	}
	public void setApprovalTitle(String approvalTitle) 
	{
		this.approvalTitle = approvalTitle;
	}

	public String getApprovalTitle() 
	{
		return approvalTitle;
	}
	public void setApprovalContent(String approvalContent) 
	{
		this.approvalContent = approvalContent;
	}

	public String getApprovalContent() 
	{
		return approvalContent;
	}
	public void setUserId(Integer userId) 
	{
		this.userId = userId;
	}

	public Integer getUserId() 
	{
		return userId;
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
	public void setUserDeptId(Integer userDeptId) 
	{
		this.userDeptId = userDeptId;
	}

	public Integer getUserDeptId() 
	{
		return userDeptId;
	}
	public void setUserPostId(Integer userPostId) 
	{
		this.userPostId = userPostId;
	}

	public Integer getUserPostId() 
	{
		return userPostId;
	}
	public void setUserPost(String userPost) 
	{
		this.userPost = userPost;
	}

	public String getUserPost() 
	{
		return userPost;
	}

	public Long getTiJiaoId() {
		return tiJiaoId;
	}

	public void setTiJiaoId(Long tiJiaoId) {
		this.tiJiaoId = tiJiaoId;
	}

	public void setTiJiaoName(String tiJiaoName)
	{
		this.tiJiaoName = tiJiaoName;
	}

	public String getTiJiaoNameImg() {
		return tiJiaoNameImg;
	}

	public void setTiJiaoNameImg(String tiJiaoNameImg) {
		this.tiJiaoNameImg = tiJiaoNameImg;
	}

	public String getTiJiaoName()
	{
		return tiJiaoName;
	}
	public void setIntegralTypeId(Integer integralTypeId)
	{
		this.integralTypeId = integralTypeId;
	}

	public Integer getIntegralTypeId() 
	{
		return integralTypeId;
	}
	public void setSqTime(Date sqTime) 
	{
		this.sqTime = sqTime;
	}

	public Date getSqTime() 
	{
		return sqTime;
	}
	public void setSpTime(Date spTime) 
	{
		this.spTime = spTime;
	}

	public Date getSpTime() 
	{
		return spTime;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setSqIntegral(Integer sqIntegral) 
	{
		this.sqIntegral = sqIntegral;
	}

	public Integer getSqIntegral() 
	{
		return sqIntegral;
	}
	public void setSpRemark(String spRemark) 
	{
		this.spRemark = spRemark;
	}

	public String getSpRemark() 
	{
		return spRemark;
	}
	public void setApprovalTime(Date approvalTime) 
	{
		this.approvalTime = approvalTime;
	}

	public Date getApprovalTime() 
	{
		return approvalTime;
	}
	public void setApprovalImg1(String approvalImg1) 
	{
		this.approvalImg1 = approvalImg1;
	}

	public String getApprovalImg1() 
	{
		return approvalImg1;
	}
	public void setApprovalImg2(String approvalImg2) 
	{
		this.approvalImg2 = approvalImg2;
	}

	public String getApprovalImg2() 
	{
		return approvalImg2;
	}
	public void setApprovalImg3(String approvalImg3) 
	{
		this.approvalImg3 = approvalImg3;
	}

	public String getApprovalImg3() 
	{
		return approvalImg3;
	}
	public void setApprovalImg4(String approvalImg4) 
	{
		this.approvalImg4 = approvalImg4;
	}

	public String getApprovalImg4() 
	{
		return approvalImg4;
	}
	public void setApprovalImg5(String approvalImg5) 
	{
		this.approvalImg5 = approvalImg5;
	}

	public String getApprovalImg5() 
	{
		return approvalImg5;
	}
	public void setApprovalImg6(String approvalImg6) 
	{
		this.approvalImg6 = approvalImg6;
	}

	public String getApprovalImg6() 
	{
		return approvalImg6;
	}
	public void setApprovalImg7(String approvalImg7) 
	{
		this.approvalImg7 = approvalImg7;
	}

	public String getApprovalImg7() 
	{
		return approvalImg7;
	}
	public void setApprovalImg8(String approvalImg8) 
	{
		this.approvalImg8 = approvalImg8;
	}

	public String getApprovalImg8() 
	{
		return approvalImg8;
	}
	public void setApprovalImg9(String approvalImg9) 
	{
		this.approvalImg9 = approvalImg9;
	}

	public String getApprovalImg9() 
	{
		return approvalImg9;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}

	public String getJilx() {
		return jilx;
	}

	public void setJilx(String jilx) {
		this.jilx = jilx;
	}

	public String getSqDate() {
		return sqDate;
	}

	public void setSqDate(String sqDate) {
		this.sqDate = sqDate;
	}

	public String getSpDate() {
		return spDate;
	}

	public void setSpDate(String spDate) {
		this.spDate = spDate;
	}

	public String getSpzt() {
		return spzt;
	}

	public void setSpzt(String spzt) {
		this.spzt = spzt;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("approvalId", getApprovalId())
            .append("approvalNum", getApprovalNum())
            .append("approvalTitle", getApprovalTitle())
            .append("approvalContent", getApprovalContent())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("userImg", getUserImg())
            .append("userPhone", getUserPhone())
            .append("userDept", getUserDept())
            .append("userDeptId", getUserDeptId())
            .append("userPostId", getUserPostId())
            .append("userPost", getUserPost())
            .append("tiJiaoName", getTiJiaoName())
            .append("tiJiaoNameImg", getTiJiaoNameImg())
            .append("integralTypeId", getIntegralTypeId())
            .append("sqTime", getSqTime())
            .append("spTime", getSpTime())
            .append("status", getStatus())
            .append("sqIntegral", getSqIntegral())
            .append("spRemark", getSpRemark())
            .append("approvalTime", getApprovalTime())
            .append("approvalImg1", getApprovalImg1())
            .append("approvalImg2", getApprovalImg2())
            .append("approvalImg3", getApprovalImg3())
            .append("approvalImg4", getApprovalImg4())
            .append("approvalImg5", getApprovalImg5())
            .append("approvalImg6", getApprovalImg6())
            .append("approvalImg7", getApprovalImg7())
            .append("approvalImg8", getApprovalImg8())
            .append("approvalImg9", getApprovalImg9())
            .append("remark", getRemark())
			.append("kIntegral", getkIntegral())
            .toString();
    }
}
