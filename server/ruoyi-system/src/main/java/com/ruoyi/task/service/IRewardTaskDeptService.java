package com.ruoyi.task.service;

import com.ruoyi.task.domain.RewardTaskDept;
import java.util.List;

/**
 * 任务标题部门 服务层
 * 
 * @author sunli
 * @date 2018-12-31
 */
public interface IRewardTaskDeptService 
{
	/**
     * 查询任务标题部门信息
     * 
     * @param rtdId 任务标题部门ID
     * @return 任务标题部门信息
     */
	public RewardTaskDept selectRewardTaskDeptById(Integer rtdId);
	
	/**
     * 查询任务标题部门列表
     * 
     * @param rewardTaskDept 任务标题部门信息
     * @return 任务标题部门集合
     */
	public List<RewardTaskDept> selectRewardTaskDeptList(RewardTaskDept rewardTaskDept);
	
	/**
     * 新增任务标题部门
     * 
     * @param rewardTaskDept 任务标题部门信息
     * @return 结果
     */
	public int insertRewardTaskDept(RewardTaskDept rewardTaskDept);
	
	/**
     * 修改任务标题部门
     * 
     * @param rewardTaskDept 任务标题部门信息
     * @return 结果
     */
	public int updateRewardTaskDept(RewardTaskDept rewardTaskDept);
		
	/**
     * 删除任务标题部门信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteRewardTaskDeptByIds(String ids);
	
}
