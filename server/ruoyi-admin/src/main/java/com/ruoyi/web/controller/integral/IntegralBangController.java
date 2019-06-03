package com.ruoyi.web.controller.integral;

import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.integral.domain.Integral;
import com.ruoyi.integral.service.IIntegralService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 *  积分榜管理 信息操作处理
 *
 * @author sunli
 * @date 2018-10-24
 */
@Controller
@RequestMapping("/integral/integralBang")
public class IntegralBangController extends BaseController
{
    private String prefix = "integral/integralBang";

    @Autowired
    private ISysUserService userService;

    @Autowired
    private IIntegralService  integralService;

    @RequiresPermissions("integral:integralBang:view")
    @GetMapping()
    public String integralMenu()
    {
        return prefix + "/integralBang";
    }

    /**
     * 查询 积分榜管理列表
     */
    @RequiresPermissions("integral:integralBang:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Integral integral)
    {
        startPage();
        List<Integral> list = integralService.selectIntegralList(integral);
        return getDataTable(list);
    }



}
