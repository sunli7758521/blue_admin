package com.ruoyi.task.service;

import com.ruoyi.task.domain.RewardTaskUser;
import java.util.List;

/**
 * 任务标题员工 服务层
 * 
 * @author sunli
 * @date 2018-12-31
 */
public interface IRewardTaskUserService 
{
	/**
     * 查询任务标题员工信息
     * 
     * @param rtuId 任务标题员工ID
     * @return 任务标题员工信息
     */
	public RewardTaskUser selectRewardTaskUserById(Integer rtuId);
	
	/**
     * 查询任务标题员工列表
     * 
     * @param rewardTaskUser 任务标题员工信息
     * @return 任务标题员工集合
     */
	public List<RewardTaskUser> selectRewardTaskUserList(RewardTaskUser rewardTaskUser);
	
	/**
     * 新增任务标题员工
     * 
     * @param rewardTaskUser 任务标题员工信息
     * @return 结果
     */
	public int insertRewardTaskUser(RewardTaskUser rewardTaskUser);
	
	/**
     * 修改任务标题员工
     * 
     * @param rewardTaskUser 任务标题员工信息
     * @return 结果
     */
	public int updateRewardTaskUser(RewardTaskUser rewardTaskUser);
		
	/**
     * 删除任务标题员工信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteRewardTaskUserByIds(String ids);
	
}
