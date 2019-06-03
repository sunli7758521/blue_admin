package com.ruoyi.level.domain;

import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

import java.util.Date;

/**
 * 水平考核表 level_ass
 * 
 * @author sunli
 * @date 2019-03-14
 */
public class LevelAss extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Integer levelId;
	/** 考核名称 */
	private String assName;
	/** 部门ids */
	private String deptIds;
	/** 类型id */
	private Integer typeId;
	/** 0 使用中  1 禁用 */
	private String state;
	/** 备注 */
	private String remark;
	/** 部门对象*/
	private SysDept sysDept;
   /** 用户对象  */
	private SysUser sysuser;

	/** 申请方式*/
    private String shenQingFangShi;

	/** 创建时间 */
	private Date carateTime;
     /** 用户登录获取的id   */
	private Integer userId;

	/** 添加考核的个数*/
	private  Integer numberid;

	public Integer getNumberid() {
		return numberid;
	}

	public void setNumberid(Integer numberid) {
		this.numberid = numberid;
	}

	public SysUser getSysuser() {
		return sysuser;
	}

	public void setSysuser(SysUser sysuser) {
		this.sysuser = sysuser;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCarateTime() {
		return carateTime;
	}

	public void setCarateTime(Date carateTime) {
		this.carateTime = carateTime;
	}

	public String getShenQingFangShi() {
        return shenQingFangShi;
    }

    public void setShenQingFangShi(String shenQingFangShi) {
        this.shenQingFangShi = shenQingFangShi;
    }

    public void setSysDept(SysDept sysDept) {
		this.sysDept = sysDept;
	}

	public SysDept getSysDept() {
		return sysDept;
	}

	public void setLevelId(Integer levelId)
	{
		this.levelId = levelId;
	}

	public Integer getLevelId() 
	{
		return levelId;
	}
	public void setAssName(String assName) 
	{
		this.assName = assName;
	}

	public String getAssName() 
	{
		return assName;
	}
	public void setDeptIds(String deptIds) 
	{
		this.deptIds = deptIds;
	}

	public String getDeptIds() 
	{
		return deptIds;
	}
	public void setTypeId(Integer typeId) 
	{
		this.typeId = typeId;
	}

	public Integer getTypeId() 
	{
		return typeId;
	}
	public void setState(String state) 
	{
		this.state = state;
	}

	public String getState() 
	{
		return state;
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
            .append("levelId", getLevelId())
            .append("assName", getAssName())
            .append("deptIds", getDeptIds())
            .append("typeId", getTypeId())
            .append("state", getState())
            .append("remark", getRemark())
				.append("sysDept", getSysDept())
                .append("shenQingFangShi", getShenQingFangShi())
				.append("carateTime", getCarateTime())
				.append("userId", getUserId())
				.append("sysuser", getSysuser())
				.append("numberid", getNumberid())
            .toString();
    }
}
