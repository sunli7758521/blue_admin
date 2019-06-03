package com.ruoyi.integral.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

/**
 * 广告图片表 gg_table
 * 
 * @author sunli
 * @date 2018-11-06
 */
public class GgTable extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 广告id */
	private Integer gId;
	/** 广告名称 */
	private String gName;
	/** 广告图片 */
	private String gImgs;
	/** 备注 */
	private String remark;

	public Integer getgId() {
		return gId;
	}

	public void setgId(Integer gId) {
		this.gId = gId;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public String getgImgs() {
		return gImgs;
	}

	public void setgImgs(String gImgs) {
		this.gImgs = gImgs;
	}

	@Override
	public String getRemark() {
		return remark;
	}

	@Override
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("gId", getgId())
            .append("gName", getgName())
            .append("gImgs", getgImgs())
            .append("remark", getRemark())
            .toString();
    }
}
