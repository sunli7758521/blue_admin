package com.ruoyi.web.controller.task;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.task.domain.RewardTask;
import com.ruoyi.task.service.IRewardTaskService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 悬赏任务 信息操作处理
 * 
 * @author sunli
 * @date 2018-12-24
 */
@Controller
@RequestMapping("/task/rewardTask")
public class RewardTaskController extends BaseController
{
    private String prefix = "task/rewardTask";
	
	@Autowired
	private IRewardTaskService rewardTaskService;
	
	@RequiresPermissions("task:rewardTask:view")
	@GetMapping()
	public String rewardTask()
	{
	    return prefix + "/rewardTask";
	}
	
	/**
	 * 查询悬赏任务列表
	 */
	@RequiresPermissions("task:rewardTask:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(RewardTask rewardTask)
	{
		startPage();
        List<RewardTask> list = rewardTaskService.selectRewardTaskList(rewardTask);
		return getDataTable(list);
	}
	
	/**
	 * 新增悬赏任务
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存悬赏任务
	 */
	@RequiresPermissions("task:rewardTask:add")
	@Log(title = "悬赏任务", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(RewardTask rewardTask)
	{
		rewardTask.setReleaseUserId(ShiroUtils.getUserId().intValue());
		rewardTask.setCreateTime(DateUtils.getNowDate());
		if(rewardTask.getTaskTypeId()== 1){
			rewardTask.setAppWay("1");
		}
		if(rewardTask.getTaskTypeId()== 2){
			rewardTask.setAppWay("2");
		}
		if(rewardTask.getTaskTypeId()== 3){
			rewardTask.setAppWay("3");
		}

		return toAjax(rewardTaskService.insertRewardTask(rewardTask));
	}

	/**
	 * 修改悬赏任务
	 */
	@GetMapping("/edit/{rtId}")
	public String edit(@PathVariable("rtId") Integer rtId, ModelMap mmap)
	{
		RewardTask rewardTask = rewardTaskService.selectRewardTaskById(rtId);
		mmap.put("rewardTask", rewardTask);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存悬赏任务
	 */
	@RequiresPermissions("task:rewardTask:edit")
	@Log(title = "悬赏任务", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(RewardTask rewardTask)
	{
		rewardTask.setReleaseUserId(ShiroUtils.getUserId().intValue());
		rewardTask.setUpdateTime(DateUtils.getNowDate());
		return toAjax(rewardTaskService.updateRewardTask(rewardTask));
	}
	
	/**
	 * 删除悬赏任务
	 */
	@RequiresPermissions("task:rewardTask:remove")
	@Log(title = "悬赏任务", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(rewardTaskService.deleteRewardTaskByIds(ids));
	}
	/**
	 * 悬赏任务 启用。停用
	 */
	@RequiresPermissions("task:rewardTask::undo")
	@Log(title = "悬赏任务 启用。停用", businessType = BusinessType.UPDATE)
	@GetMapping("/undo/{taskId}/{status}")
	@ResponseBody
	public AjaxResult undo(@PathVariable("taskId") String taskId ,@PathVariable("status") String status)
	{
		return toAjax(rewardTaskService.undo(Integer.parseInt(taskId),Integer.parseInt(status)));
	}
}
