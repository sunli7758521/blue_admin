package com.ruoyi.web.controller.integral;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.integral.domain.IntegralJk;
import com.ruoyi.integral.service.IIntegralJkService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户信息
 * 
 * @author ruoyi
 */

@Controller
@RequestMapping("/integral/integralJkUser")
public class IntegralJkUserController extends BaseController {
    private String prefix = "integral/integralJk";

    @Autowired
    private ISysUserService userService;

    @Autowired
    private IIntegralJkService integralJkService;


    @RequiresPermissions("integral:integralJkUser:view")
    @GetMapping()
    public String user() {
        return prefix + "/userList";
    }

    @RequiresPermissions("integral:integralJkUser:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysUser user) {
        startPage();
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    /**
     * 修改积分奖扣
     */
    @GetMapping("/add")
    @RequiresPermissions("integral:integralJkUser:add")
    public String edit( String ids, ModelMap mmap)
    {
        mmap.put("ids", ids);
        return prefix + "/add";
    }


    /**
     * 新增保存批量奖扣员工
     */

    @RequiresPermissions("integral:integralJkUser:add")
    @Log(title = "批量奖扣员工管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addSave(IntegralJk integralJk)
    {
        return toAjax(integralJkService.insertIntegralUserList(integralJk));
    }

}
