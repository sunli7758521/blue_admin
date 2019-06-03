package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.SysUserPost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户 业务层
 * 
 * @author ruoyi
 */
public interface ISysUserService
{
    /**
     * 根据条件分页查询用户对象
     * 
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<SysUser> selectUserList(SysUser user);

    /**
     * 通过用户名查询用户
     * 
     * @param userName 用户名
     * @return 用户对象信息
     */
    public SysUser selectUserByLoginName(String userName);

    /**
     * 通过手机号码查询用户
     * 
     * @param phoneNumber 手机号码
     * @return 用户对象信息
     */
    public SysUser selectUserByPhoneNumber(String phoneNumber);

    /**
     * 通过邮箱查询用户
     * 
     * @param email 邮箱
     * @return 用户对象信息
     */
    public SysUser selectUserByEmail(String email);

    /**
     * 通过用户ID查询用户
     * 
     * @param userId 用户ID
     * @return 用户对象信息
     */
    public SysUser selectUserById(Long userId);

    /**
     * 通过用户ID删除用户
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public int deleteUserById(Long userId);

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteUserByIds(String ids) throws Exception;

    /**
     * 保存用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int insertUser(SysUser user,String managementIds);

    public int insertUser2(SysUser user);


    /**
     * 保存用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int updateUser(SysUser user,String managementIds);

    /**
     * 修改用户详细信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int updateUserInfo(SysUser user);

    /**
     * 修改用户密码信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int resetUserPwd(SysUser user);

    /**
     * 校验用户名称是否唯一
     * 
     * @param loginName 登录名称
     * @return 结果
     */
    public String checkLoginNameUnique(String loginName);

    /**
     * 校验手机号码是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    public String checkPhoneUnique(SysUser user);

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    public String checkEmailUnique(SysUser user);

    /**
     * 根据用户ID查询用户所属角色组
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public String selectUserRoleGroup(Long userId);

    /**
     * 根据用户ID查询用户所属岗位组
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public String selectUserPostGroup(Long userId);

    /**
     * 根据用户 userId 查询更新离职状态
     *
     * @param userId 用户 userId
     * @return 结果
     */
    int departureUser(Long userId,String status);

    /**
     * 根据用户 userId 查询更新是否要参与积分活动
     *
     * @param userId 用户id
     * @return 结果
     */
    int integralUser(Long userId,String integralStatus);
    /**
     *
     *  查询所用本部门员工
     */
    List<SysUser> selectDeptUser(String deptId);

    /**
     *  设置 普通审批人和高级审批人
     */
    int sysAppPel(Long userId, String isApprover);

    /**
     *  查询postId
     */
    List<SysUserPost> selectPostId(Long userId);

    /**
     * 根据用户、部门、职位名称 查询用户
     * @param userName
     * @param deptName
     * @param postName
     * @return
     */
    SysUser findByudpName(String userName,String deptName,String postName);

    /**
     *  设置 积分申诉人
     */
    int sysComplainant(Long userId, String integralComplainant);

    /**
     * 通过用户id 查询岗位主键
     * @param userId
     * @return
     */
    SysUserPost findSysUserPostByuserId(Long userId);

    /**
     * 批量保存或更新
     */

    void updateUserBatch(@Param("list") List<SysUser> list);

    /**
     *  统计所用用户
     */
    int selectCountUserNum();
}
