package com.ruoyi.task.service.impl;

import com.ruoyi.common.support.Convert;
import com.ruoyi.task.domain.TaskType;
import com.ruoyi.task.mapper.TaskTypeMapper;
import com.ruoyi.task.service.ITaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 任务类型 服务层实现
 * 
 * @author sunli
 * @date 2018-12-24
 */
@Service
public class TaskTypeServiceImpl implements ITaskTypeService 
{
	@Autowired
	private TaskTypeMapper taskTypeMapper;

	/**
     * 查询任务类型信息
     * 
     * @param taskId 任务类型ID
     * @return 任务类型信息
     */
    @Override
	public TaskType selectTaskTypeById(Integer taskId)
	{
	    return taskTypeMapper.selectTaskTypeById(taskId);
	}
	
	/**
     * 查询任务类型列表
     * 
     * @param taskType 任务类型信息
     * @return 任务类型集合
     */
	@Override
	public List<TaskType> selectTaskTypeList(TaskType taskType)
	{
	    return taskTypeMapper.selectTaskTypeList(taskType);
	}
	
    /**
     * 新增任务类型
     * 
     * @param taskType 任务类型信息
     * @return 结果
     */
	@Override
	public int insertTaskType(TaskType taskType)
	{
	    return taskTypeMapper.insertTaskType(taskType);
	}
	
	/**
     * 修改任务类型
     * 
     * @param taskType 任务类型信息
     * @return 结果
     */
	@Override
	public int updateTaskType(TaskType taskType)
	{
	    return taskTypeMapper.updateTaskType(taskType);
	}

	/**
     * 删除任务类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTaskTypeByIds(String ids)
	{
		return taskTypeMapper.deleteTaskTypeByIds(Convert.toStrArray(ids));
	}
	
}
