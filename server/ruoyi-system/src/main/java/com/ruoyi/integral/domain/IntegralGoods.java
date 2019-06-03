package com.ruoyi.integral.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 商品管理表 integral_goods
 * 
 * @author sunli
 * @date 2018-10-30
 */
public class IntegralGoods extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 主键 */
	private Integer goodId;
	/** 商品名称 */
	private String goodName;
	/** 商品封面*/
	private String goodImg;
	/** 商品库存 */
	private Integer goodKc;
	/** 已兑换数量 */
	private Integer ydhNum;
	/** 兑换积分 */
	private Integer dhIntegral;
	/** 兑换转态(0,兑换中  1停止兑换) */
	private Integer status;

	private String state;
	/** 商品轮播图 */
	private String goodLbImg;
	/** 商品详情 */
	private String goodDetails;
	/** 上传时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;
	/** 备注 */
	private String remark;
	/** 商品总数量 */
	private String goodCount;

	public String getGoodImg() {
		return goodImg;
	}

	public void setGoodImg(String goodImg) {
		this.goodImg = goodImg;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGoodCount() {
		return goodCount;
	}

	public void setGoodCount(String goodCount) {
		this.goodCount = goodCount;
	}
	public void setGoodId(Integer goodId)
	{
		this.goodId = goodId;
	}

	public Integer getGoodId() 
	{
		return goodId;
	}
	public void setGoodName(String goodName) 
	{
		this.goodName = goodName;
	}

	public String getGoodName() 
	{
		return goodName;
	}
	public void setGoodKc(Integer goodKc) 
	{
		this.goodKc = goodKc;
	}

	public Integer getGoodKc() 
	{
		return goodKc;
	}
	public void setYdhNum(Integer ydhNum) 
	{
		this.ydhNum = ydhNum;
	}

	public Integer getYdhNum() 
	{
		return ydhNum;
	}
	public void setDhIntegral(Integer dhIntegral) 
	{
		this.dhIntegral = dhIntegral;
	}

	public Integer getDhIntegral() 
	{
		return dhIntegral;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setGoodLbImg(String goodLbImg) 
	{
		this.goodLbImg = goodLbImg;
	}

	public String getGoodLbImg() 
	{
		return goodLbImg;
	}
	public void setGoodDetails(String goodDetails) 
	{
		this.goodDetails = goodDetails;
	}

	public String getGoodDetails() 
	{
		return goodDetails;
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
            .append("goodId", getGoodId())
            .append("goodName", getGoodName())
            .append("goodKc", getGoodKc())
            .append("ydhNum", getYdhNum())
            .append("dhIntegral", getDhIntegral())
            .append("status", getStatus())
            .append("goodLbImg", getGoodLbImg())
            .append("goodDetails", getGoodDetails())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
			.append("goodCount", getGoodCount())
			.append("goodImg", getGoodImg())
            .toString();
    }
}
