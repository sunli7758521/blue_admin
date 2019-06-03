package com.ruoyi.integral.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 积分奖扣表 integral_jk
 * 
 * @author sunli
 * @date 2018-10-25
 */
public class IntegralJk extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Integer jkId;
	/** 奖扣编号 */
	private String jkNum;
	/** 奖扣标题 */
	private String jkTitle;
	/** 奖扣员工姓名 */
	private String jkName;
	/** 奖扣人员姓名 */
	private String jkPhone;
	/** 奖励员工部门 */
	private Integer deptId;
	/** 奖励人员所属部门 */
	private String deptName;
	/** 奖扣员工头像 */
	private String jkImg;
	/** 奖励积分 */
	private Integer jIntegral;
	/** 扣除积分 */
	private Integer kIntegral;
	/** 奖扣时间 */
	private Date jkTime;
	/** 积分奖扣描述 */
	private String jkDescribe;
	/** 状态 */
	private Integer status;
	/** 描述 */
	private String remark;
	/** 奖励类型 */
	private Integer typeId;
	/** 奖励员工ids*/
	private String ids;

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Integer getjIntegral() {
		return jIntegral;
	}

	public void setjIntegral(Integer jIntegral) {
		this.jIntegral = jIntegral;
	}

	public Integer getkIntegral() {
		return kIntegral;
	}

	public void setkIntegral(Integer kIntegral) {
		this.kIntegral = kIntegral;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getJkId()
	{
		return jkId;
	}
	public void setJkNum(String jkNum) 
	{
		this.jkNum = jkNum;
	}

	public String getJkNum() 
	{
		return jkNum;
	}
	public void setJkTitle(String jkTitle) 
	{
		this.jkTitle = jkTitle;
	}

	public String getJkTitle() 
	{
		return jkTitle;
	}
	public void setJkName(String jkName) 
	{
		this.jkName = jkName;
	}

	public String getJkName() 
	{
		return jkName;
	}
	public void setJkPhone(String jkPhone) 
	{
		this.jkPhone = jkPhone;
	}

	public String getJkPhone() 
	{
		return jkPhone;
	}
	public void setDeptId(Integer deptId) 
	{
		this.deptId = deptId;
	}

	public Integer getDeptId() 
	{
		return deptId;
	}
	public void setDeptName(String deptName) 
	{
		this.deptName = deptName;
	}

	public String getDeptName() 
	{
		return deptName;
	}
	public void setJkImg(String jkImg) 
	{
		this.jkImg = jkImg;
	}

	public String getJkImg() 
	{
		return jkImg;
	}

	public void setJkTime(Date jkTime) 
	{
		this.jkTime = jkTime;
	}

	public Date getJkTime() 
	{
		return jkTime;
	}
	public void setJkDescribe(String jkDescribe) 
	{
		this.jkDescribe = jkDescribe;
	}

	public String getJkDescribe() 
	{
		return jkDescribe;
	}
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
            .append("jkId", getJkId())
            .append("jkNum", getJkNum())
            .append("jkTitle", getJkTitle())
            .append("jkName", getJkName())
            .append("jkPhone", getJkPhone())
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .append("jkImg", getJkImg())
            .append("jIntegral", getjIntegral())
            .append("kIntegral", getkIntegral())
            .append("jkTime", getJkTime())
            .append("jkDescribe", getJkDescribe())
            .append("status", getStatus())
            .append("remark", getRemark())
			.append("typeId", getTypeId())
            .toString();
    }
}
