package com.ruoyi.task.mapper;

import com.ruoyi.task.domain.TaskType;
import java.util.List;	

/**
 * 任务类型 数据层
 * 
 * @author sunli
 * @date 2018-12-24
 */
public interface TaskTypeMapper 
{
	/**
     * 查询任务类型信息
     * 
     * @param taskId 任务类型ID
     * @return 任务类型信息
     */
	public TaskType selectTaskTypeById(Integer taskId);
	
	/**
     * 查询任务类型列表
     * 
     * @param taskType 任务类型信息
     * @return 任务类型集合
     */
	public List<TaskType> selectTaskTypeList(TaskType taskType);
	
	/**
     * 新增任务类型
     * 
     * @param taskType 任务类型信息
     * @return 结果
     */
	public int insertTaskType(TaskType taskType);
	
	/**
     * 修改任务类型
     * 
     * @param taskType 任务类型信息
     * @return 结果
     */
	public int updateTaskType(TaskType taskType);
	
	/**
     * 删除任务类型
     * 
     * @param taskId 任务类型ID
     * @return 结果
     */
	public int deleteTaskTypeById(Integer taskId);
	
	/**
     * 批量删除任务类型
     * 
     * @param taskIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaskTypeByIds(String[] taskIds);
	
}