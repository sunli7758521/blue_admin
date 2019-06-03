package com.ruoyi.system.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.constant.IntegralConstants;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.support.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.integral.domain.Integral;
import com.ruoyi.integral.domain.IntegralApproval;
import com.ruoyi.integral.mapper.IntegralMapper;
import com.ruoyi.integral.service.IIntegralApprovalService;
import com.ruoyi.integral.service.IIntegralService;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserDeptPostService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户 业务层处理
 * 
 * @author ruoyi
 */
@Service
public class SysUserServiceImpl implements ISysUserService
{
    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysPostMapper postMapper;

    @Autowired
    private SysUserPostMapper userPostMapper;

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Autowired
    private IntegralMapper integralMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserPostMapper sysUserPostMapper;

    @Autowired
    private SysUserDeptPostMapper sysUserDeptPostMapper;

    @Autowired
    private ISysUserDeptPostService sysUserDeptPostService;

    /** 注入积分  */
    @Autowired
    private IIntegralService iIntegralService;

    @Autowired
    private IIntegralApprovalService iIntegralApprovalService;

    @Autowired
    private ISysDeptService iSysDeptService;

    /**
     * 根据条件分页查询用户对象
     * 
     * @param user 用户信息
     * 
     * @return 用户信息集合信息
     */
    @Override
    @DataScope(tableAlias = "u")
    public List<SysUser> selectUserList(SysUser user)
    {

        List<SysUser> sysUserList = userMapper.selectUserList(user);
        for (SysUser sysUser : sysUserList) {
            SysUserRole  userRole=  userRoleMapper.selectByUserGetRoleId(sysUser.getUserId());
            if(userRole !=null){
                SysRole role =  sysRoleMapper.selectRoleById(userRole.getRoleId());
                sysUser.setRoleName(role.getRoleName());
            }
         List <SysUserPost> userPost = userPostMapper.selectUserByIdList(sysUser.getUserId());
            for(SysUserPost up : userPost){
                if(userPost !=null){
                    SysPost post =  postMapper.selectPostById(up.getPostId());
                    if(post !=null){
                        sysUser.setPostName(post.getPostName());
                    }
                }
            }

        }
        return sysUserList;
    }

    /**
     * 通过用户名查询用户
     * 
     * @param userName 用户名
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByLoginName(String userName)
    {
        return userMapper.selectUserByLoginName(userName);
    }

    /**
     * 通过手机号码查询用户
     * 
     * @param phoneNumber 用户名
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByPhoneNumber(String phoneNumber)
    {
        return userMapper.selectUserByPhoneNumber(phoneNumber);
    }

    /**
     * 通过邮箱查询用户
     * 
     * @param email 邮箱
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByEmail(String email)
    {
        return userMapper.selectUserByEmail(email);
    }

    /**
     * 通过用户ID查询用户
     * 
     * @param userId 用户ID
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserById(Long userId)
    {
        return userMapper.selectUserById(userId);
    }

    /**
     * 通过用户ID删除用户
     * 
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public int deleteUserById(Long userId)
    {
        // 删除用户与角色关联
        userRoleMapper.deleteUserRoleByUserId(userId);
        // 删除用户与岗位表
        userPostMapper.deleteUserPostByUserId(userId);
        return userMapper.deleteUserById(userId);
    }

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUserByIds(String ids) throws Exception
    {
        Long[] userIds = Convert.toLongArray(ids);
        for (Long userId : userIds)
        {
            if (SysUser.isAdmin(userId))
            {
                throw new Exception("不允许删除超级管理员用户");
            }
        }
        //跟据用户ids 删除 所关联的积分总表的id
        iIntegralService.deleteIntegralByUserIds(userIds);
        //删除角色
        sysRoleMapper.deleteRoleByUserId(userIds);
        // 删除职位
        sysUserPostMapper.deleteUserPostUserIds(userIds);

        return userMapper.deleteUserByIds(userIds);
    }

    /**
     * 新增保存用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */

    @Override
    public int insertUser2(SysUser user)
    {
       /* //添加员工不是审批人
        user.setIsApprover(Integer.parseInt(IntegralConstants.COMMON_APP));
        //默认参加积分排名
        user.setIntegralStatus(Integer.parseInt(IntegralConstants.USER_INTEGRAL_PAI_MING));*/
        // 新增用户信息
        int rows = userMapper.insertUser2(user);
     /*   // 新增用户岗位关联
        insertUserPost(user);
        // 新增用户与角色管理
        insertUserRole(user);
        //添加用户对应的积分数据
        addIntegral(user);
        //  addUserDeptPost(user,managementIds);
        // 添加审批表 基础积分
        //  insertApp(user);*/
        return rows;
    }

    @Override
    public int insertUser(SysUser user,String managementIds)
    {
        //添加员工不是审批人
        user.setIsApprover(Integer.parseInt(IntegralConstants.COMMON_APP));
        //默认参加积分排名
        user.setIntegralStatus(Integer.parseInt(IntegralConstants.USER_INTEGRAL_PAI_MING));
        // 新增用户信息
        int rows = userMapper.insertUser(user);
        // 新增用户岗位关联
        insertUserPost(user);
        // 新增用户与角色管理
        insertUserRole(user);
        //添加用户对应的积分数据
        addIntegral(user);
      //  addUserDeptPost(user,managementIds);
        // 添加审批表 基础积分
      //  insertApp(user);
        return rows;
    }
    // 添加审批表 基础积分
    private void insertApp(SysUser user) {
        IntegralApproval  ia = new IntegralApproval();
        // 添加积分审批基础积分
        ia.setRemark(user.getJiChuIntegral()+"");
        ia.setStatus(1);
        ia.setUserId(user.getUserId().intValue());
        ia.setUserName(user.getUserName());
        ia.setUserDeptId(user.getDeptId().intValue());
      SysDept sysDept =  iSysDeptService.selectDeptById(user.getDeptId());
        if(sysDept !=null){
            ia.setUserDept(sysDept.getDeptName());
        }
     SysUserPost userPost =   userPostMapper.selectUserById(user.getUserId());
       if(userPost !=null){
           ia.setUserPostId(userPost.getPostId().intValue());
       }
     SysPost post =   postMapper.selectPostById(userPost.getPostId());
       if(post !=null){
           ia.setUserPost(post.getPostName());
       }
       ia.setSqIntegral(0);
       ia.setIntegralTypeId(3);
       ia.setSpTime(DateUtils.getNowDate());
        iIntegralApprovalService.insertIntegralApproval(ia);
    }

    /** 添加用户所管理的部门*/
    private void addUserDeptPost(SysUser user, String managementIds) {
       String [] deptId = managementIds.split(",");
        for (String dId : deptId) {
            SysUserDeptPost ud = new SysUserDeptPost();
            ud.setUserId(user.getUserId().intValue());
            ud.setDeptId(user.getDeptId().intValue());
            ud.setCreateTime(DateUtils.getNowDate());
            sysUserDeptPostMapper.insertSysUserDeptPost(ud);
        }
    }

    /**
     * 添加用户对应的积分数据
     *
     * @param user 用户对象
     */
    private void addIntegral(SysUser user) {
        Integral integral = new Integral();
        integral.setCountIntegral(user.getJiChuIntegral());
        integral.setUserPhone(user.getPhonenumber());
        integral.setUserName(user.getUserName());
        integral.setUserId(user.getUserId().intValue());
        /** 添加积分商城上显示的总积分 */
        integral.setGoodCountIntegral(user.getJiChuIntegral());
        integral.setDeptId(user.getDeptId().intValue());
       SysUserPost userPost =  sysUserPostMapper.selectUserById(user.getUserId());
     if (userPost !=null){
         integral.setPostId(userPost.getPostId().intValue());
     }
     int row = integralMapper.insertIntegral(integral);
    }

    /**
     * 修改保存用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateUser(SysUser user,String managementIds)
    {
        Long userId = user.getUserId();
        // 删除用户与角色关联
        userRoleMapper.deleteUserRoleByUserId(userId);
        // 新增用户与角色管理
        insertUserRole(user);
        // 删除用户与岗位关联
        userPostMapper.deleteUserPostByUserId(userId);
        // 新增用户与岗位管理
        insertUserPost(user);
        //修改积分表的基础积分
        updateIntegralCount(user);
        // 修改用户所管理的部门
       // updateUserDepts(user.getUserId(),managementIds);
        return userMapper.updateUser(user);
    }
//    //修改用户所管理的部门
//    private void updateUserDepts(Long userId, String managementIds) {
//
//        if (!managementIds.equals("")) {
//            List<SysUserDeptPost>  list  =   sysUserDeptPostService.selectByUserId(userId);
//
//            if(list.size() == 0){
//                String[] deptIds =  managementIds.split(",");
//                for (String id : deptIds) {
//                    SysUserDeptPost ups = new SysUserDeptPost();
//                    ups.setUserId(userId.intValue());
//                    ups.setDeptId(Integer.parseInt(id));
//                    ups.setUpdateTime(DateUtils.getNowDate());
//                    sysUserDeptPostService.insertSysUserDeptPost(ups);
//                }
//            }else {
//                int up = sysUserDeptPostService.delectByUserId(userId);
//                String[] deptIds1 = managementIds.split(",");
//                for (String id : deptIds1) {
//                    SysUserDeptPost ups1 = new SysUserDeptPost();
//                    ups1.setUserId(userId.intValue());
//                    ups1.setDeptId(Integer.parseInt(id));
//                    ups1.setUpdateTime(DateUtils.getNowDate());
//                    sysUserDeptPostService.insertSysUserDeptPost(ups1);
//                }
//        }
//        }
//    }

    //修改积分表的基础积分
    private void updateIntegralCount(SysUser user) {
    Integral integral = integralMapper.selectByUserId(user.getUserId()+"");
        // 部门和职位 id
        SysUserPost userPost =   sysUserPostMapper.selectUserById(user.getUserId());
        if(userPost !=null){
            integral.setPostId(userPost.getPostId().intValue());
        }
        integral.setDeptId(user.getDeptId().intValue());

        integral.setCountIntegral(integral.getCountIntegral());
        integral.setGoodCountIntegral(integral.getGoodCountIntegral());
     int row = integralMapper.updateIntegral(integral);
    }

    /**
     * 修改用户个人详细信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int updateUserInfo(SysUser user)
    {
        return userMapper.updateUser(user);
    }

    /**
     * 修改用户密码
     * 
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int resetUserPwd(SysUser user)
    {
        return updateUserInfo(user);
    }

    /**
     * 新增用户角色信息
     * 
     * @param user 用户对象
     */
    public void insertUserRole(SysUser user)
    {
        // 新增用户与角色管理
        List<SysUserRole> list = new ArrayList<SysUserRole>();
        for (Long roleId : user.getRoleIds())
        {
            SysUserRole ur = new SysUserRole();
            ur.setUserId(user.getUserId());
            ur.setRoleId(roleId);
            list.add(ur);
        }
        if (list.size() > 0)
        {
            userRoleMapper.batchUserRole(list);
        }
    }

    /**
     * 新增用户岗位信息
     * 
     * @param user 用户对象
     */
    public void insertUserPost(SysUser user)
    {
        // 新增用户与岗位管理
        List<SysUserPost> list = new ArrayList<SysUserPost>();
        for (Long postId : user.getPostIds())
        {
            SysUserPost up = new SysUserPost();
            up.setUserId(user.getUserId());
            up.setPostId(postId);
            list.add(up);
        }
        if (list.size() > 0)
        {
            userPostMapper.batchUserPost(list);
        }
    }

    /**
     * 校验用户名称是否唯一
     * 
     * @param loginName 用户名
     * @return
     */
    @Override
    public String checkLoginNameUnique(String loginName)
    {
        int count = userMapper.checkLoginNameUnique(loginName);
        if (count > 0)
        {
            return UserConstants.USER_NAME_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }

    /**
     * 校验用户名称是否唯一
     *
     * @param phonenumber 用户名
     * @return
     */
    @Override
    public String checkPhoneUnique(SysUser user)
    {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUser info = userMapper.checkPhoneUnique(user.getPhonenumber());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
        {
            return UserConstants.USER_PHONE_NOT_UNIQUE;
        }
        return UserConstants.USER_PHONE_UNIQUE;
    }

    /**
     * 校验email是否唯一
     *
     * @param user 用户名
     * @return
     */
    @Override
    public String checkEmailUnique(SysUser user)
    {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUser info = userMapper.checkEmailUnique(user.getEmail());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
        {
            return UserConstants.USER_EMAIL_NOT_UNIQUE;
        }
        return UserConstants.USER_EMAIL_UNIQUE;
    }

    /**
     * 查询用户所属角色组
     * 
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public String selectUserRoleGroup(Long userId)
    {
        List<SysRole> list = roleMapper.selectRolesByUserId(userId);
        StringBuffer idsStr = new StringBuffer();
        for (SysRole role : list)
        {
            idsStr.append(role.getRoleName()).append(",");
        }
        if (StringUtils.isNotEmpty(idsStr.toString()))
        {
            return idsStr.substring(0, idsStr.length() - 1);
        }
        return idsStr.toString();
    }

    /**
     * 查询用户所属岗位组
     * 
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public String selectUserPostGroup(Long userId)
    {
        List<SysPost> list = postMapper.selectPostsByUserId(userId);
        StringBuffer idsStr = new StringBuffer();
        for (SysPost post : list)
        {
            idsStr.append(post.getPostName()).append(",");
        }
        if (StringUtils.isNotEmpty(idsStr.toString()))
        {
            return idsStr.substring(0, idsStr.length() - 1);
        }
        return idsStr.toString();
    }

    /**
     * 根据用户 userId查询更新状态
     *
     * @param userId 用户id
     * @return 结果
     */
    @Override
    public int departureUser(Long userId,String status) {
      SysUser user = userMapper.selectUserById(userId);
      /** 如果传来1 设为在职 0 */
      if(status.equals(IntegralConstants.NO_LI_ZHI)){
          user.setStatus(IntegralConstants.YES_LI_ZHI);
      }
        /** 如果传来0 设为在职 1 */
      if (status.equals(IntegralConstants.YES_LI_ZHI)){
          user.setStatus(IntegralConstants.NO_LI_ZHI);
      }
        return userMapper.updateUser(user);
    }

    /**
     * 根据用户 userId 查询更新是否要参与积分活动
     *
     * @param userId 用户id
     * @return 结果
     */
    @Override
    public int integralUser(Long userId,String integralStatus) {
        SysUser user = userMapper.selectUserById(userId);
            if(integralStatus.equals(IntegralConstants.USER_INTEGRAL_PAI_MING)){
                //设为不参与
                user.setIntegralStatus(2);
            }
            if(integralStatus.equals(IntegralConstants.USER_NOT_CAN_YU)){
                //设为参与
                user.setIntegralStatus(1);
            }
        return userMapper.updateUser(user);
    }

    /**
     *
     *  查询所用本部门员工
     */
    @Override
    public List<SysUser> selectDeptUser(String deptId) {
        return userMapper.selectDeptUser(deptId);
    }

    /**
     *  设置 普通审批人和高级审批人
     */
    @Override
    public int sysAppPel(Long userId, String isApprover) {
     SysUser sysUser =  userMapper.selectUserById(userId);
     /** 传过来是 1 改为普通审批人 */
     if(isApprover.equals(IntegralConstants.ADMIN_APP)){
         sysUser.setIsApprover(Integer.parseInt(IntegralConstants.ADMIN_APP));
     }
        /** 传过来是 2 改为高级审批人 */
     if (isApprover.equals(IntegralConstants.SUPER_APP)){
         sysUser.setIsApprover(Integer.parseInt(IntegralConstants.SUPER_APP));
     }
    /** 传过来是 3 改为普通人 */
    if (isApprover.equals(IntegralConstants.COMMON_APP)){
        sysUser.setIsApprover(Integer.parseInt(IntegralConstants.COMMON_APP));
    }
    /** 传过来是4  改为经理 */
    if (isApprover.equals(IntegralConstants.MANAGER_APP)){
        sysUser.setIsApprover(Integer.parseInt(IntegralConstants.MANAGER_APP));
    }
    /** 传过来是5  总经理级 */
    if (isApprover.equals(IntegralConstants.GENERALMANAGE_APP)){
        sysUser.setIsApprover(Integer.parseInt(IntegralConstants.GENERALMANAGE_APP));
    }
    /** 传过来是6  总监级 */
    if (isApprover.equals(IntegralConstants.DIRECTOR_APP)){
        sysUser.setIsApprover(Integer.parseInt(IntegralConstants.DIRECTOR_APP));
    }
    /** 传过来是7  主管级 */
    if (isApprover.equals(IntegralConstants.COMPETENT_LEVEL_APP)){
        sysUser.setIsApprover(Integer.parseInt(IntegralConstants.COMPETENT_LEVEL_APP));
    }
    /** 传过来是8  特殊 员工 */
    if (isApprover.equals(IntegralConstants.SPECIAL)){
        sysUser.setIsApprover(Integer.parseInt(IntegralConstants.SPECIAL));
    }
    /** 传过来是9  职能总监级 */
    if (isApprover.equals(IntegralConstants.FUNCTION)){
        sysUser.setIsApprover(Integer.parseInt(IntegralConstants.FUNCTION));
    }

        return userMapper.updateUser(sysUser);
    }

    @Override
    public List<SysUserPost> selectPostId(Long userId) {

        return sysUserPostMapper.selectUserByIdList(userId);
    }

    @Override
    public SysUser findByudpName(String userName, String deptName, String postName) {
        return this.userMapper.findByudpName(userName,deptName,postName);
    }

    @Override
    public int sysComplainant(Long userId, String integralComplainant) {
        SysUser sysUser =  userMapper.selectUserById(userId);

        /**   传过来是 0 改为取消积分申诉人
         *    传过来是 1 改为 积分申诉人
         */
        int i = 0;
        if(integralComplainant.equals(IntegralConstants.COMPLAINANT_NO)){
            sysUser.setIntegralComplainant(IntegralConstants.COMPLAINANT_NO);
            i =  userMapper.updateUser(sysUser);
        }else  if(integralComplainant.equals(IntegralConstants.COMPLAINANT_YES)){
            sysUser.setIntegralComplainant(IntegralConstants.COMPLAINANT_YES);
           i = userMapper.updateUser(sysUser);
        }
         return i;
    }

    /**
     * 通过用户id 查询岗位主键
     * @param userId
     * @return
     */

    @Override
    public SysUserPost findSysUserPostByuserId(Long userId) {
        return sysUserPostMapper.selectUserById(userId);
    }

    /**
     * 批量保存或更新
     * @return
     */
    @Override
    public void updateUserBatch(List<SysUser> list) {
        this.userMapper.updateUserBatch(list);
    }

    /**
     *  统计所用用户
     */
    @Override
    public int selectCountUserNum() {
        return this.userMapper.selectCountUserNum();
    }

}
