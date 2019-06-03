package com.ruoyi.integral.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 抽奖实现表 integral_draw
 *
 * @author sunli
 * @date 2019-02-21
 */
public class IntegralDraw extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/**  */
	private Integer id;
	/** 奖品名称 */
	private String name;
	/** 奖品总数 */
	private Integer amount;
	/** 奖品图片地址 */
	private String goodsUrl;
	/** 权重 */
	private Integer weight;
	/** 状态 */
	private String status;
	/** 删除标志 */
	private String delFlag;
	/** 创建人 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 修改创建人 */
	private String updateBy;
	/** 修改时间 */
	private Date updateTime;
	/** 备注 */
	private String remark;

	/**  单个商品的积分值 */
	private Integer  Integralvalue;

	public Integer getIntegralvalue() {
		return Integralvalue;
	}

	public void setIntegralvalue(Integer integralvalue) {
		Integralvalue = integralvalue;
	}

	public String getGoodsUrl() {
		return goodsUrl;
	}

	public void setGoodsUrl(String goodsUrl) {
		this.goodsUrl = goodsUrl;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId()
	{
		return id;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}
	public void setAmount(Integer amount)
	{
		this.amount = amount;
	}

	public Integer getAmount()
	{
		return amount;
	}
	public void setWeight(Integer weight)
	{
		this.weight = weight;
	}

	public Integer getWeight()
	{
		return weight;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getStatus()
	{
		return status;
	}
	public void setDelFlag(String delFlag)
	{
		this.delFlag = delFlag;
	}

	public String getDelFlag()
	{
		return delFlag;
	}
	public void setCreateBy(String createBy)
	{
		this.createBy = createBy;
	}

	public String getCreateBy()
	{
		return createBy;
	}
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public Date getCreateTime()
	{
		return createTime;
	}
	public void setUpdateBy(String updateBy)
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy()
	{
		return updateBy;
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
				.append("id", getId())
				.append("name", getName())
				.append("amount", getAmount())
				.append("goodsUrl", getGoodsUrl())
				.append("weight", getWeight())
				.append("status", getStatus())
				.append("delFlag", getDelFlag())
				.append("createBy", getCreateBy())
				.append("createTime", getCreateTime())
				.append("updateBy", getUpdateBy())
				.append("updateTime", getUpdateTime())
				.append("remark", getRemark())
				.append("Integralvalue", getIntegralvalue())
				.toString();
	}
}
