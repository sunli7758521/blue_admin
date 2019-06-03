package com.ruoyi.task.mapper;

import com.ruoyi.task.domain.RewardTaskUser;
import java.util.List;	

/**
 * 任务标题员工 数据层
 * 
 * @author sunli
 * @date 2018-12-31
 */
public interface RewardTaskUserMapper 
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
     * 删除任务标题员工
     * 
     * @param rtuId 任务标题员工ID
     * @return 结果
     */
	public int deleteRewardTaskUserById(Integer rtuId);
	
	/**
     * 批量删除任务标题员工
     * 
     * @param rtuIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteRewardTaskUserByIds(String[] rtuIds);
	
}