package com.ruoyi.web.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ruoyi.system.domain.UserLoginLog;
import com.ruoyi.system.service.IUserLoginLogService;
import com.ruoyi.web.core.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;

/**
 * 用户登录记录 信息操作处理
 * 
 * @author sunli
 * @date 2019-05-21
 */
@Controller
@RequestMapping("/system/userLoginLog")
public class UserLoginLogController extends BaseController
{
    private String prefix = "system/userLoginLog";
	
	@Autowired
	private IUserLoginLogService userLoginLogService;
	
	@RequiresPermissions("system:userLoginLog:view")
	@GetMapping()
	public String userLoginLog()
	{
	    return prefix + "/userLoginLog";
	}
	
	/**
	 * 查询用户登录记录列表
	 */
	@RequiresPermissions("system:userLoginLog:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(UserLoginLog userLoginLog)
	{
		startPage();
        List<UserLoginLog> list = userLoginLogService.selectUserLoginLogList(userLoginLog);
		return getDataTable(list);
	}
	
	/**
	 * 新增用户登录记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户登录记录
	 */
	@RequiresPermissions("system:userLoginLog:add")
	@Log(title = "用户登录记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(UserLoginLog userLoginLog)
	{		
		return toAjax(userLoginLogService.insertUserLoginLog(userLoginLog));
	}

	/**
	 * 修改用户登录记录
	 */
	@GetMapping("/edit/{userLogId}")
	public String edit(@PathVariable("userLogId") Long userLogId, ModelMap mmap)
	{
		UserLoginLog userLoginLog = userLoginLogService.selectUserLoginLogById(userLogId);
		mmap.put("userLoginLog", userLoginLog);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户登录记录
	 */
	@RequiresPermissions("system:userLoginLog:edit")
	@Log(title = "用户登录记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(UserLoginLog userLoginLog)
	{		
		return toAjax(userLoginLogService.updateUserLoginLog(userLoginLog));
	}
	
	/**
	 * 删除用户登录记录
	 */
	@RequiresPermissions("system:userLoginLog:remove")
	@Log(title = "用户登录记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(userLoginLogService.deleteUserLoginLogByIds(ids));
	}


	@PostMapping("/selectCountNum")
	@ResponseBody
	public Map<String,Long> selectCountNum()
	{
		Map<String,Long> map = new HashMap<>();
		Long num = userLoginLogService.selectCountNum();
		map.put("num",num);
		return map;
	}


}
