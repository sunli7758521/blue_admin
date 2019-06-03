package com.ruoyi.integral.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.base.BaseEntity;

/**
 * 〈一句话功能简述〉<br>
 * 〈Excel导入积分榜辅助类〉
 *
 * @author zhaoyan
 * @create 2019/1/17
 * @since 1.0.0
 */
public class IntegralAppExcel extends BaseEntity {

    /**
     * 序号
     */
    @Excel(name = "序号")
    private String number;
    /**
     * 用户名
     */
    @Excel(name = "用户名")
    private String userName;
    /**
     * 部门名称
     */
    @Excel(name = "部门名称")
    private String depName;
    /**
     * 部门名称
     */
    @Excel(name = "职位")
    private String postName;
    /**
     * A品德总积分
     */
    @Excel(name = "A品德总积分")
    private String ainte;
    /**
     * 	B业绩总积分
     */
    @Excel(name = "B业绩总积分")
    private String binte;
    /**
     * C行为总积分
     */
    @Excel(name = "C行为总积分")
    private String cinte;
    /**
     * 管理奖扣总积分
     */
    @Excel(name = "管理奖扣总积分")
    private String maInte;
    /**
     * 自由奖扣总分
     */
    @Excel(name = "自由奖扣总分")
    private String freeInte;
    /**
     * 爱心点赞总分
     */
    @Excel(name = "爱心点赞总分")
    private String loveInte;
    /**
     * 积分支票总分
     */
    @Excel(name = "积分支票总分")
    private String checkInte;
    /**
     * 悬赏任务总分
     */
    @Excel(name = "悬赏任务总分")
    private String orInte;
    /**
     * 水平考核总分
     */
    @Excel(name = "水平考核总分")
    private String assessmentInte ;
    /**
     * 基础积分
     */
    @Excel(name = "基础积分")
    private String basInte;
    /**
     * 扣除积分
     */
    @Excel(name = "扣除积分")
    private String minusInte;
    /**
     * 总分
     */
    @Excel(name = "总分")
    private String count;
    /**
     * 排名
     */
    @Excel(name = "排名")
    private String ranking;

    @Excel(name = "商城总积分")
    private  String jifen;

    public String getJifen() {
        return jifen;
    }

    public void setJifen(String jifen) {
        this.jifen = jifen;
    }

    /**
     * 积分类型
     */
    private String typeId;
    public String getNumber() {
        return number;
    }

    public String getAssessmentInte() {
        return assessmentInte;
    }

    public void setAssessmentInte(String assessmentInte) {
        this.assessmentInte = assessmentInte;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getAinte() {
        return ainte;
    }

    public void setAinte(String ainte) {
        this.ainte = ainte;
    }

    public String getBinte() {
        return binte;
    }

    public void setBinte(String binte) {
        this.binte = binte;
    }

    public String getCinte() {
        return cinte;
    }

    public void setCinte(String cinte) {
        this.cinte = cinte;
    }

    public String getMaInte() {
        return maInte;
    }

    public void setMaInte(String maInte) {
        this.maInte = maInte;
    }

    public String getFreeInte() {
        return freeInte;
    }

    public void setFreeInte(String freeInte) {
        this.freeInte = freeInte;
    }

    public String getLoveInte() {
        return loveInte;
    }

    public void setLoveInte(String loveInte) {
        this.loveInte = loveInte;
    }

    public String getCheckInte() {
        return checkInte;
    }

    public void setCheckInte(String checkInte) {
        this.checkInte = checkInte;
    }

    public String getOrInte() {
        return orInte;
    }

    public void setOrInte(String orInte) {
        this.orInte = orInte;
    }

    public String getBasInte() {
        return basInte;
    }

    public void setBasInte(String basInte) {
        this.basInte = basInte;
    }

    public String getMinusInte() {
        return minusInte;
    }

    public void setMinusInte(String minusInte) {
        this.minusInte = minusInte;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
