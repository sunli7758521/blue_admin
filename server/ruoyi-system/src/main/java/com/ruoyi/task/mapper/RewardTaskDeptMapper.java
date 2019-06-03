package com.ruoyi.task.mapper;

import com.ruoyi.task.domain.RewardTaskDept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 任务标题部门 数据层
 * 
 * @author sunli
 * @date 2018-12-31
 */
public interface RewardTaskDeptMapper 
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
     * 删除任务标题部门
     * 
     * @param rtdId 任务标题部门ID
     * @return 结果
     */
	public int deleteRewardTaskDeptById(Integer rtdId);
	
	/**
     * 批量删除任务标题部门
     * 
     * @param rtdIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteRewardTaskDeptByIds(String[] rtdIds);

	/** 通过悬赏任务的id 查询所关联的部门id*/
	List<RewardTaskDept> selectByRewardTaskId(@Param("rtId") Integer rtId);

	/** 通过悬赏任务的id 删除所关联的部门ids*/
	void delectByRewardTaskId(@Param("rtId") Integer rtId);
}