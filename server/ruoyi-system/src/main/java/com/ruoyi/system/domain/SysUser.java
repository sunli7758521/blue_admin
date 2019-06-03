package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 用户对象 sys_user
 * 
 * @author ruoyi
 */
public class SysUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    @Excel(name = "用户序号")
    private Long userId;

    /** 部门ID */
    private Long deptId;

    /** 部门父ID */
    private Long parentId;

    /** 登录名称 */
    @Excel(name = "登录名称")
    private String loginName;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String userName;

    /** 用户邮箱 */
    @Excel(name = "用户邮箱")
    private String email;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phonenumber;

    /** 用户性别 */
    @Excel(name = "用户性别")
    private String sex;

    /** 用户头像 */
    private String avatar;

    /** 密码 */
    private String password;

    /** 盐加密 */
    private String salt;

    /** 帐号状态（0正常 1停用）0在职 1离职 */
    @Excel(name = "帐号状态")
    private String status;

    /** 删除标志（0代表存在 2代表删除）0参与积分 2不参与积分 */
    private String delFlag;

    /** 最后登陆IP */
    @Excel(name = "最后登陆IP")
    private String loginIp;

    /** 最后登陆时间 */
    @Excel(name = "最后登陆时间")
    private Date loginDate;

    /** 部门对象 */
    private SysDept dept;

    private List<SysRole> roles;

    /** 角色组 */
    private Long[] roleIds;

    /** 岗位组 */
    private Long[] postIds;

    /** 积分申诉   0 默认不是最高申诉人  1.是最高申诉人   */
    private String integralComplainant;

    /** 基础积分 */
    private Integer jiChuIntegral;

    /** 表扬积分 */
    private Integer biaoIntegral;

    /** 爱心积分 */
    private Integer loveIntegral;

    /** 是否参加积分 */
    private  Integer integralStatus;

    /** 是否参加积分 */
    private String roleName;

    /** 是不是审批人(1.是审批人 0.不是审批人) */
    private  Integer isApprover;
    /** postId  */
    private String postId;

    /** 申请类型的ids  */
    private String  applyIds;

    /** 职位名称  */
    private String postName;

    /** 管理奖扣*/
    private  Integer  manAward;

    public Integer getManAward() {
        return manAward;
    }

    public void setManAward(Integer manAward) {
        this.manAward = manAward;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getApplyIds() {
        return applyIds;
    }

    public void setApplyIds(String applyIds) {
        this.applyIds = applyIds;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public Integer getIsApprover() {
        return isApprover;
    }

    public void setIsApprover(Integer isApprover) {
        this.isApprover = isApprover;
    }

    public Integer getIntegralStatus() {
        return integralStatus;
    }

    public void setIntegralStatus(Integer integralStatus) {
        this.integralStatus = integralStatus;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getIntegralComplainant() {
        return integralComplainant;
    }

    public void setIntegralComplainant(String integralComplainant) {
        this.integralComplainant = integralComplainant;
    }

    public Integer getJiChuIntegral() {
        return jiChuIntegral;
    }

    public void setJiChuIntegral(Integer jiChuIntegral) {
        this.jiChuIntegral = jiChuIntegral;
    }

    public Integer getBiaoIntegral() {
        return biaoIntegral;
    }

    public void setBiaoIntegral(Integer biaoIntegral) {
        this.biaoIntegral = biaoIntegral;
    }

    public Integer getLoveIntegral() {
        return loveIntegral;
    }

    public void setLoveIntegral(Integer loveIntegral) {
        this.loveIntegral = loveIntegral;
    }



    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public boolean isAdmin()
    {
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }

    public Long getDeptId()
    {
        return deptId;
    }

    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getParentId()
    {
        return parentId;
    }

    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    public String getLoginName()
    {
        return loginName;
    }

    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getSalt()
    {
        return salt;
    }

    public void setSalt(String salt)
    {
        this.salt = salt;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getLoginIp()
    {
        return loginIp;
    }

    public void setLoginIp(String loginIp)
    {
        this.loginIp = loginIp;
    }

    public Date getLoginDate()
    {
        return loginDate;
    }

    public void setLoginDate(Date loginDate)
    {
        this.loginDate = loginDate;
    }

    public SysDept getDept()
    {
        return dept;
    }

    public void setDept(SysDept dept)
    {
        this.dept = dept;
    }

    public List<SysRole> getRoles()
    {
        return roles;
    }

    public void setRoles(List<SysRole> roles)
    {
        this.roles = roles;
    }

    public Long[] getRoleIds()
    {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds)
    {
        this.roleIds = roleIds;
    }

    public Long[] getPostIds()
    {
        return postIds;
    }

    public void setPostIds(Long[] postIds)
    {
        this.postIds = postIds;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("loginName", getLoginName())
            .append("userName", getUserName())
            .append("email", getEmail())
            .append("phonenumber", getPhonenumber())
            .append("sex", getSex())
            .append("avatar", getAvatar())
            .append("password", getPassword())
            .append("salt", getSalt())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("loginIp", getLoginIp())
            .append("loginDate", getLoginDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("integralComplainant", getIntegralComplainant())
            .append("jiChuIntegral", getJiChuIntegral())
            .append("biaoIntegral", getBiaoIntegral())
            .append("loveIntegral", getLoveIntegral())
            .append("integralStatus", getIntegralStatus())
            .append("isApprover",getIsApprover())
            .append("applyIds",getApplyIds())
            .append("manAward",getManAward())
            .toString();
    }
}
