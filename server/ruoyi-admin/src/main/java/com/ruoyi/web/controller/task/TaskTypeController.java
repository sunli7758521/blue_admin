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
import com.ruoyi.task.domain.TaskType;
import com.ruoyi.task.service.ITaskTypeService;
import com.ruoyi.web.core.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;

/**
 * 任务类型 信息操作处理
 * 
 * @author sunli
 * @date 2018-12-24
 */
@Controller
@RequestMapping("/task/taskType")
public class TaskTypeController extends BaseController
{
    private String prefix = "task/taskType";
	
	@Autowired
	private ITaskTypeService taskTypeService;
	
	@RequiresPermissions("task:taskType:view")
	@GetMapping()
	public String taskType()
	{
	    return prefix + "/taskType";
	}
	
	/**
	 * 查询任务类型列表
	 */
	@RequiresPermissions("task:taskType:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TaskType taskType)
	{
		startPage();
        List<TaskType> list = taskTypeService.selectTaskTypeList(taskType);
		return getDataTable(list);
	}
	
	/**
	 * 新增任务类型
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存任务类型
	 */
	@RequiresPermissions("task:taskType:add")
	@Log(title = "任务类型", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TaskType taskType)
	{		
		return toAjax(taskTypeService.insertTaskType(taskType));
	}

	/**
	 * 修改任务类型
	 */
	@GetMapping("/edit/{taskId}")
	public String edit(@PathVariable("taskId") Integer taskId, ModelMap mmap)
	{
		TaskType taskType = taskTypeService.selectTaskTypeById(taskId);
		mmap.put("taskType", taskType);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存任务类型
	 */
	@RequiresPermissions("task:taskType:edit")
	@Log(title = "任务类型", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TaskType taskType)
	{		
		return toAjax(taskTypeService.updateTaskType(taskType));
	}
	
	/**
	 * 删除任务类型
	 */
	@RequiresPermissions("task:taskType:remove")
	@Log(title = "任务类型", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(taskTypeService.deleteTaskTypeByIds(ids));
	}
	
}
