package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.constant.PicUrlConstants;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.shiro.service.PasswordService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.integral.service.IIntegralService;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.*;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 用户信息
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/user")
public class SysUserController extends BaseController
{
    private String prefix = "system/user";

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysPostService postService;

    @Autowired
    private ISysUserDeptPostService sysUserDeptPostService;

    @Autowired
    private PasswordService passwordService;
    @Autowired
    private ISysDeptService iSysDeptService;
   @Autowired
   private ISysUserRoleService iSysUserRoleService;
    @Autowired
    private ISysUserPostService iSysUserPostService;
    @Autowired
    private IIntegralService integralService;
    @RequiresPermissions("system:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    @RequiresPermissions("system:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysUser user)
    {
        startPage();
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:user:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysUser user)
    {
        List<SysUser> list = userService.selectUserList(user);
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 新增用户
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("roles", roleService.selectRoleAll());
        mmap.put("posts", postService.selectPostAll());
        return prefix + "/add";
    }

    /**
     * 新增保存用户
     */
    @RequiresPermissions("system:user:add")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addSave(SysUser user,String managementIds)
    {
        if (StringUtils.isNotNull(user.getUserId()) && SysUser.isAdmin(user.getUserId()))
        {
            return error("不允许修改超级管理员用户");
        }
        user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
        user.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(userService.insertUser(user,managementIds));
    }

    /**
     * 修改用户
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        SysUser user = userService.selectUserById(userId);
        if(user.getRoles().isEmpty()){
            user.setRoles(null);
        }
        mmap.put("user", user);
        mmap.put("roles", roleService.selectRolesByUserId(userId));
        List<SysPost>  posts = postService.selectPostsByUserId(userId);
        mmap.put("posts",posts);

       List<SysUserPost>   userPost = userService.selectPostId(userId);
        if(userPost != null){
         for (SysUserPost post : userPost) {
            mmap.put("postId",post.getPostId());
            }
        }
        return prefix + "/edit";
    }

    /**
     * 修改保存用户
     */
    @RequiresPermissions("system:user:edit")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult editSave(SysUser user,String managementIds,String role)
    {
        if (StringUtils.isNotNull(user.getUserId()) && SysUser.isAdmin(user.getUserId()))
        {
            return error("不允许修改超级管理员用户");
        }
        user.setUpdateBy(ShiroUtils.getLoginName());

        return toAjax(userService.updateUser(user,managementIds));
    }
    /** 查看 所管理的部门 */
    @GetMapping("/selectUserDepts/{userId}")
    public String  selectUserDepts(@PathVariable("userId") Long userId,ModelMap modelMap)
    {
        StringBuffer sb = new StringBuffer();

        List<SysUserDeptPost> list = sysUserDeptPostService.selectUserDepts(userId);
        if(list.size()>0){
            for (SysUserDeptPost userDeptPost : list) {
                sb.append(userDeptPost.getDeptName()+",");
            }
        }
        modelMap.put("userId",userId);
        modelMap.put("sb",sb);
        return prefix + "/editDepts";
    }

    /** 修改 所管理部门 */
    @RequiresPermissions("system:user:edit")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/updateDepts")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult updateDepts(String deptIds,Long userId)
    {
        return toAjax(sysUserDeptPostService.updateDepts(deptIds,userId));
    }


    /**
     * 离职员工
     */
    @RequiresPermissions("system:user:departure")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @GetMapping("/departure/{userId}/{status}")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult  departureUser(@PathVariable("userId") Long userId,@PathVariable("status") String status)
    {
        return toAjax(userService.departureUser(userId,status));
    }

    /**
     * 员工不参与积分
     */
    @RequiresPermissions("system:user:integral")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @GetMapping("/integral/{userId}/{integralStatus}")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult  integralUser(@PathVariable("userId") Long userId,@PathVariable("integralStatus") String integralStatus)
    {
        return toAjax(userService.integralUser(userId,integralStatus));
    }

    @RequiresPermissions("system:user:resetPwd")
    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @GetMapping("/resetPwd/{userId}")
    public String resetPwd(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        mmap.put("user", userService.selectUserById(userId));
        return prefix + "/resetPwd";
    }

    @RequiresPermissions("system:user:resetPwd")
    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @PostMapping("/resetPwd")
    @ResponseBody
    public AjaxResult resetPwdSave(SysUser user)
    {
        user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
        return toAjax(userService.resetUserPwd(user));
    }

    @RequiresPermissions("system:user:remove")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(userService.deleteUserByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 校验用户名
     */
    @PostMapping("/checkLoginNameUnique")
    @ResponseBody
    public String checkLoginNameUnique(SysUser user)
    {
        return userService.checkLoginNameUnique(user.getLoginName());
    }

    /**
     * 校验手机号码
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public String checkPhoneUnique(SysUser user)
    {
        return userService.checkPhoneUnique(user);
    }

    /**
     * 校验email邮箱
     */
    @PostMapping("/checkEmailUnique")
    @ResponseBody
    public String checkEmailUnique(SysUser user)
    {
        return userService.checkEmailUnique(user);
    }

    /**
     *  设置 普通审批人和高级审批人
     */
    @RequiresPermissions("system:user:resetPwd")
    @Log(title = "设置 普通审批人和高级审批人", businessType = BusinessType.OTHER)
    @GetMapping("/sysApp/{userId}/{isApprover}")
    @ResponseBody
    public AjaxResult sysApp(@PathVariable("userId") Long userId,@PathVariable("isApprover") String isApprover )
    {
        return toAjax(userService.sysAppPel(userId,isApprover));
    }
    /**
     *  设置 积分申诉人
     */
    @RequiresPermissions("system:user:resetPwd")
    @Log(title = "设置 积分申诉人", businessType = BusinessType.OTHER)
    @GetMapping("/sysComplainant/{userId}/{integralComplainant}")
    @ResponseBody
    public AjaxResult sysComplainant(@PathVariable("userId") Long userId,@PathVariable("integralComplainant") String integralComplainant )
    {
        return toAjax(userService.sysComplainant(userId,integralComplainant));
    }



    /**
     * 导入
     * importExcel
     */
    @GetMapping("/impExcelPage")
    public String impExcelPage()
    {
        return prefix + "/importExcel";
    }



    @PostMapping("/importExcel")
    @ResponseBody
    @RequiresPermissions("system:user:importExcel")
    @Transactional(rollbackFor=Exception.class)
    public AjaxResult importExcel(@RequestParam("file") MultipartFile file){
        ExcelUtil<SysUserExcel> util = new ExcelUtil<SysUserExcel>(SysUserExcel.class);
        String message = "上传失败";
        boolean falg = false;
        int row = 1;
   /*     List<Integral> iList = new ArrayList<Integral>();
        List<IntegralApproval> listias = new ArrayList<IntegralApproval>();
        List<SysUser> users = new ArrayList<SysUser>();*/
        try {
            File fileExcel = new File(PicUrlConstants.URL +file.getOriginalFilename());
            file.transferTo(fileExcel);
            InputStream is = new FileInputStream(fileExcel.getPath());
            List<SysUserExcel> list = util.importExcel(is);
            for(SysUserExcel ie : list){
                SysUser sysUser1=new SysUser();
                SysRole role1 =new SysRole();
                SysPost post1=new SysPost();
                /** 登录用户名*/
                   String userName2=ie.getUserName2();
                String  userName0 =userName2.trim();
                   sysUser1.setLoginName(userName0);
                /** 用户名称*/
                String username = ie.getUserName();
                String  username1 =username.trim();
                sysUser1.setUserName(username1);
                /**  部门名称*/
                String depname = ie.getDepName();
                String  depname1=depname.trim();
                SysDept sysDept = iSysDeptService.selectDeptById2(depname1);
                if (sysDept.getDeptName().equals(depname)&& !sysDept.getDeptName().equals("蓝鸟")){
                    Long deptId=sysDept.getDeptId();
                    sysUser1.setDeptId(deptId);
                }else {
                    message = "第"+row+"行"+depname+"部门不存在";
                    falg = true;
                    break;
                }
                /** 角色名称*/
                String roleName =ie.getRoleName();
                SysRole sysRole   = roleService.selectRoleById2(roleName);
                if (sysRole.getRoleName().equals(roleName.trim())){
                    Long roleId  =sysRole.getRoleId();
                    role1.setRoleId(roleId);
                }else{
                    message = "第"+row+"行"+roleName+"角色不存在";
                    falg = true;
                    break;
                }

                /**职位名称*/
                String postName = ie.getPostName();
                String postName1 =postName.trim();
                System.out.println(postName1);
                SysPost sysPost  =postService.selectPostById2(postName1);
                System.out.println(sysPost.getPostName());
                if (sysPost.getPostName().equals(postName1)){

                    Long  postId=sysPost.getPostId();

                    System.out.println(postId);

                    post1.setPostId(postId);
                }else{

                    message = "第"+row+"行"+postName+"职位不存在";
                    falg = true;
                    break;
                }
                /**手机号*/
                String phone=ie.getPhone();
                SysUser uu1   = userService.selectUserByPhoneNumber(phone);
                System.out.println(uu1+"看我的值啊啊啊啊啊啊啊");
                System.out.println(uu1+"看我的值啊啊啊啊啊啊啊");
                if (uu1!=null){
                    message = "第"+row+"行"+phone+"手机号已存在";
                    falg = true;
                    break;
                }else{
                    sysUser1.setPhonenumber(phone);
                }

                /**基础积分  basInte*/
                String basInte=ie.getBasInte();
                Integer it =Integer.valueOf(basInte);
                sysUser1.setJiChuIntegral(it);
                /** 积分支票*/
                 String basInte1=ie.getBasInte1();
                Integer biao  =Integer.valueOf(basInte1);
                sysUser1.setBiaoIntegral(biao);
                /** 爱心点赞*/
                String lovePoints=ie.getLovePoints();
                Integer love  =Integer.valueOf(lovePoints);
                sysUser1.setLoveIntegral(love);

                /** 是否参与排名 delflag*/
                  String delflag=ie.getDelflag();
                if (delflag.equals("是")){
                    String can="0";
                    sysUser1.setDelFlag(can);
                    String kk="1";
                    sysUser1.setIntegralStatus(Integer.parseInt(kk));
                }else{
                    String can="2";
                    sysUser1.setDelFlag(can);
                    sysUser1.setIntegralStatus(Integer.parseInt(can));
                }

                /** 是否是审批人*/
              /*  String Approver=ie.getApprover();
                if (Approver.equals("是")){
                    int Approver1=7;
                    sysUser1.setIsApprover(Approver1);
                }else{*/
                    int Approver1=3;
                    sysUser1.setIsApprover(Approver1);
              /*  }*/


                /**最高申诉人*/
             /*   String integralComplainant=ie.getIntegralComplainant();
                if (integralComplainant.equals("是")){
                    String shen="1";
                    sysUser1.setIntegralComplainant(shen);
                }else{*/
                    String shen="0";
                    sysUser1.setIntegralComplainant(shen);
              /*  }*/

                /**状态*/
             /*   String status=ie.getStatus();
                if (status.equals("在职")){*/
                    String zai="0";
                    sysUser1.setStatus(zai);
               /* }else{
                    String zai="1";
                    sysUser1.setStatus(zai);
                }*/
                  /**时间*/
                Date aa = DateUtils.getNowDate();
                sysUser1.setCreateTime(aa);
                   int fanhui=userService.insertUser2(sysUser1);
                System.out.println(fanhui+"我的返回值 有没有啊啊啊啊");
                SysUser SYS=userService.selectUserByPhoneNumber(phone);
                /** 获取到 我添加的 信息的用户id*/
                Long userId  =SYS.getUserId();
                System.out.println(userId+"用户id看到为 多少啊啊啊啊");
                /** 关联 职位 与用户id*/
                iSysUserPostService.insertSysUserPost(userId,post1);
                /** 关联 角色与用户id*/
                iSysUserRoleService.insertSysUserRole(userId,role1);
                /** 关联 用户的 积分表 数据*/
                integralService.insertIntegral2(sysUser1,post1,userId);
                row++;
            }
            if(falg){
                return AjaxResult.error(message);
            }
           /* integralApprovalService.insertBathch(listias,iList,users);*/
            message = "上传成功";
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//回滚
            e.printStackTrace();
        }
        return AjaxResult.success(message);
    }


}