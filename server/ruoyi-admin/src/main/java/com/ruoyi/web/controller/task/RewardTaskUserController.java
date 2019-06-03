package com.ruoyi.web.controller.task;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.task.domain.RewardTaskUser;
import com.ruoyi.task.service.IRewardTaskUserService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 任务标题员工 信息操作处理
 * 
 * @author sunli
 * @date 2018-12-31
 */
@Controller
@RequestMapping("/task/rewardTaskUser")
public class RewardTaskUserController extends BaseController
{
    private String prefix = "task/rewardTaskUser";
	
	@Autowired
	private IRewardTaskUserService rewardTaskUserService;
	
	@RequiresPermissions("task:rewardTaskUser:view")
	@GetMapping()
	public String rewardTaskUser()
	{
	    return prefix + "/rewardTaskUser";
	}
	
	/**
	 * 查询任务标题员工列表
	 */
	@RequiresPermissions("task:rewardTaskUser:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(RewardTaskUser rewardTaskUser)
	{
		startPage();
        List<RewardTaskUser> list = rewardTaskUserService.selectRewardTaskUserList(rewardTaskUser);
		return getDataTable(list);
	}
	
	/**
	 * 新增任务标题员工
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存任务标题员工
	 */
	@RequiresPermissions("task:rewardTaskUser:add")
	@Log(title = "任务标题员工", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(RewardTaskUser rewardTaskUser)
	{		
		return toAjax(rewardTaskUserService.insertRewardTaskUser(rewardTaskUser));
	}

	/**
	 * 修改任务标题员工
	 */
	@GetMapping("/edit/{rtuId}")
	public String edit(@PathVariable("rtuId") Integer rtuId, ModelMap mmap)
	{
		RewardTaskUser rewardTaskUser = rewardTaskUserService.selectRewardTaskUserById(rtuId);
		mmap.put("rewardTaskUser", rewardTaskUser);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存任务标题员工
	 */
	@RequiresPermissions("task:rewardTaskUser:edit")
	@Log(title = "任务标题员工", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(RewardTaskUser rewardTaskUser)
	{		
		return toAjax(rewardTaskUserService.updateRewardTaskUser(rewardTaskUser));
	}
	
	/**
	 * 删除任务标题员工
	 */
	@RequiresPermissions("task:rewardTaskUser:remove")
	@Log(title = "任务标题员工", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(rewardTaskUserService.deleteRewardTaskUserByIds(ids));
	}
	
}
