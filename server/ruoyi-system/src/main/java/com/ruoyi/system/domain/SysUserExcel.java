package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.base.BaseEntity;

/**
 * @author sun li
 * @Date 2019/5/31 10:33
 * @Description
 */
public class SysUserExcel extends BaseEntity {
    /**
     * 序号
     */
    @Excel(name = "序号")
    private String number;

    /**
     * 登录用户名
     */
    @Excel(name = "登录用户名")
    private String userName;

    /**
     * 用户名称
     */
    @Excel(name = "用户名称")
    private String userName2;

    /**
     * 部门名称
     */
    @Excel(name = "部门名称")
    private String depName;

    /**
     *角色名称
     */
    @Excel(name = "角色名称")
    private String roleName;

    /**
     *职位名称
     */
    @Excel(name = "职位名称")
    private String postName;

    /**
     *手机号
     */
    @Excel(name = "手机号")
    private String Phone;



    /**
     *基础积分
     */
    @Excel(name = "基础积分")
    private String basInte;

    /**
     *积分支票
     */
    @Excel(name = "积分支票")
    private String basInte1;

    /**
     *爱心积分
     */
    @Excel(name = "爱心积分")
    private String LovePoints;

    /**
     *是否参与积分排名
     */
    @Excel(name = "是否参与积分排名")
    private String delflag;

    /**
     *是不是审批人
     */
    @Excel(name = "是不是审批人")
    private String Approver;

    /**
     *是不是最高申诉人
     */
    @Excel(name = "是不是最高申诉人")
    private String integralComplainant;

    /**
     *状态
     */
    @Excel(name = "状态")
    private String status;


    public String getNumber() {
        return number;
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

    public String getUserName2() {
        return userName2;
    }

    public void setUserName2(String userName2) {
        this.userName2 = userName2;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getApprover() {
        return Approver;
    }

    public void setApprover(String approver) {
        Approver = approver;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getIntegralComplainant() {
        return integralComplainant;
    }

    public void setIntegralComplainant(String integralComplainant) {
        this.integralComplainant = integralComplainant;
    }

    public String getBasInte() {
        return basInte;
    }

    public void setBasInte(String basInte) {
        this.basInte = basInte;
    }

    public String getBasInte1() {
        return basInte1;
    }

    public void setBasInte1(String basInte1) {
        this.basInte1 = basInte1;
    }

    public String getLovePoints() {
        return LovePoints;
    }

    public void setLovePoints(String lovePoints) {
        LovePoints = lovePoints;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }
}
