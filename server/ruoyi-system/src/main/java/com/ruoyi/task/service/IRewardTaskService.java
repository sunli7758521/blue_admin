package com.ruoyi.task.service;

import com.ruoyi.task.domain.RewardTask;
import java.util.List;

/**
 * 悬赏任务 服务层
 * 
 * @author sunli
 * @date 2018-12-24
 */
public interface IRewardTaskService 
{
	/**
     * 查询悬赏任务信息
     * 
     * @param rtId 悬赏任务ID
     * @return 悬赏任务信息
     */
	public RewardTask selectRewardTaskById(Integer rtId);
	
	/**
     * 查询悬赏任务列表
     * 
     * @param rewardTask 悬赏任务信息
     * @return 悬赏任务集合
     */
	public List<RewardTask> selectRewardTaskList(RewardTask rewardTask);
	
	/**
     * 新增悬赏任务
     * 
     * @param rewardTask 悬赏任务信息
     * @return 结果
     */
	public int insertRewardTask(RewardTask rewardTask);
	
	/**
     * 修改悬赏任务
     * 
     * @param rewardTask 悬赏任务信息
     * @return 结果
     */
	public int updateRewardTask(RewardTask rewardTask);
		
	/**
     * 删除悬赏任务信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteRewardTaskByIds(String ids);

	/**
	 * 悬赏任务 更改信息状态，启用 ，停用
	 *
	 * @param status ，taskId
	 * @return 结果
	 */
    int undo(Integer taskId, Integer status);
}
