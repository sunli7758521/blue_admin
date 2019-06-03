package com.ruoyi.web.controller.task;

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
import com.ruoyi.task.domain.RewardTaskDept;
import com.ruoyi.task.service.IRewardTaskDeptService;
import com.ruoyi.web.core.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;

/**
 * 任务标题部门 信息操作处理
 * 
 * @author sunli
 * @date 2018-12-31
 */
@Controller
@RequestMapping("/task/rewardTaskDept")
public class RewardTaskDeptController extends BaseController
{
    private String prefix = "task/rewardTaskDept";
	
	@Autowired
	private IRewardTaskDeptService rewardTaskDeptService;
	
	@RequiresPermissions("task:rewardTaskDept:view")
	@GetMapping()
	public String rewardTaskDept()
	{
	    return prefix + "/rewardTaskDept";
	}
	
	/**
	 * 查询任务标题部门列表
	 */
	@RequiresPermissions("task:rewardTaskDept:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(RewardTaskDept rewardTaskDept)
	{
		startPage();
        List<RewardTaskDept> list = rewardTaskDeptService.selectRewardTaskDeptList(rewardTaskDept);
		return getDataTable(list);
	}
	
	/**
	 * 新增任务标题部门
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存任务标题部门
	 */
	@RequiresPermissions("task:rewardTaskDept:add")
	@Log(title = "任务标题部门", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(RewardTaskDept rewardTaskDept)
	{		
		return toAjax(rewardTaskDeptService.insertRewardTaskDept(rewardTaskDept));
	}

	/**
	 * 修改任务标题部门
	 */
	@GetMapping("/edit/{rtdId}")
	public String edit(@PathVariable("rtdId") Integer rtdId, ModelMap mmap)
	{
		RewardTaskDept rewardTaskDept = rewardTaskDeptService.selectRewardTaskDeptById(rtdId);
		mmap.put("rewardTaskDept", rewardTaskDept);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存任务标题部门
	 */
	@RequiresPermissions("task:rewardTaskDept:edit")
	@Log(title = "任务标题部门", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(RewardTaskDept rewardTaskDept)
	{		
		return toAjax(rewardTaskDeptService.updateRewardTaskDept(rewardTaskDept));
	}
	
	/**
	 * 删除任务标题部门
	 */
	@RequiresPermissions("task:rewardTaskDept:remove")
	@Log(title = "任务标题部门", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(rewardTaskDeptService.deleteRewardTaskDeptByIds(ids));
	}
	
}
