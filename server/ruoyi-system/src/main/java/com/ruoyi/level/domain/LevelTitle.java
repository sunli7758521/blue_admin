package com.ruoyi.level.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;

import java.util.Date;

/**
 * 水平考核题目表 level_title
 * 
 * @author sunli
 * @date 2019-03-14
 */
public class LevelTitle extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Integer tId;
	/** 题目名称 */
	private String tName;
	/** 积分奖励 */
	private Long tIntegral;
	/** 答案a */
	private String tA;
	/** 答案b */
	private String tB;
	/** 答案c */
	private String tC;
	/** 答案d */
	private String tD;
	/** 正确答案 */
	private String tEnd;



	/** 考核题 id*/
	private String 	levelId;
	/** 创建时间 */
	private Date catabTime;

	public Date getCatabTime() {
		return catabTime;
	}

	public void setCatabTime(Date catabTime) {
		this.catabTime = catabTime;
	}

	public Integer gettId() {
		return tId;
	}

	public void settId(Integer tId) {
		this.tId = tId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public Long gettIntegral() {
		return tIntegral;
	}

	public void settIntegral(Long tIntegral) {
		this.tIntegral = tIntegral;
	}

	public String gettA() {
		return tA;
	}

	public void settA(String tA) {
		this.tA = tA;
	}

	public String gettB() {
		return tB;
	}

	public void settB(String tB) {
		this.tB = tB;
	}

	public String gettC() {
		return tC;
	}

	public void settC(String tC) {
		this.tC = tC;
	}

	public String gettD() {
		return tD;
	}

	public void settD(String tD) {
		this.tD = tD;
	}

	public String gettEnd() {
		return tEnd;
	}

	public void settEnd(String tEnd) {
		this.tEnd = tEnd;
	}

	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tId", gettId())
            .append("tName", gettName())
            .append("tIntegral", gettIntegral())
            .append("tA", gettA())
            .append("tB", gettB())
            .append("tC", gettC())
            .append("tD", gettD())
            .append("tEnd", gettEnd())
				.append("levelId", getLevelId())
				.append("catabTime", getCatabTime())
            .toString();
    }
}
