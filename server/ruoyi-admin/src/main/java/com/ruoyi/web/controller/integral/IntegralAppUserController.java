package com.ruoyi.web.controller.integral;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.integral.domain.IntegralAppUser;
import com.ruoyi.integral.service.IIntegralAppUserService;
import com.ruoyi.web.core.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;

/**
 * 积分项申请方式 关联 用户 信息操作处理
 * 
 * @author sunli
 * @date 2019-05-29
 */
@Controller
@RequestMapping("/integral/integralAppUser")
public class IntegralAppUserController extends BaseController
{
    private String prefix = "integral/integralAppUser";
	
	@Autowired
	private IIntegralAppUserService integralAppUserService;
	
	@RequiresPermissions("integral:integralAppUser:view")
	@GetMapping()
	public String integralAppUser()
	{
	    return prefix + "/integralAppUser";
	}
	
	/**
	 * 查询积分项申请方式 关联 用户列表
	 */
	@RequiresPermissions("integral:integralAppUser:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(IntegralAppUser integralAppUser)
	{
		startPage();
        List<IntegralAppUser> list = integralAppUserService.selectIntegralAppUserList(integralAppUser);
		return getDataTable(list);
	}
	
	/**
	 * 新增积分项申请方式 关联 用户
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存积分项申请方式 关联 用户
	 */
	@RequiresPermissions("integral:integralAppUser:add")
	@Log(title = "积分项申请方式 关联 用户", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(IntegralAppUser integralAppUser)
	{		
		return toAjax(integralAppUserService.insertIntegralAppUser(integralAppUser));
	}

	/**
	 * 修改积分项申请方式 关联 用户
	 */
	@GetMapping("/edit/{userMenuId}")
	public String edit(@PathVariable("userMenuId") Long userMenuId, ModelMap mmap)
	{
		IntegralAppUser integralAppUser = integralAppUserService.selectIntegralAppUserById(userMenuId);
		mmap.put("integralAppUser", integralAppUser);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存积分项申请方式 关联 用户
	 */
	@RequiresPermissions("integral:integralAppUser:edit")
	@Log(title = "积分项申请方式 关联 用户", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(IntegralAppUser integralAppUser)
	{		
		return toAjax(integralAppUserService.updateIntegralAppUser(integralAppUser));
	}
	
	/**
	 * 删除积分项申请方式 关联 用户
	 */
	@RequiresPermissions("integral:integralAppUser:remove")
	@Log(title = "积分项申请方式 关联 用户", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(integralAppUserService.deleteIntegralAppUserByIds(ids));
	}
	
}
