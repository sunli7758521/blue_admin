package com.ruoyi.task.service.impl;

import com.ruoyi.common.support.Convert;
import com.ruoyi.task.domain.RewardTaskDept;
import com.ruoyi.task.mapper.RewardTaskDeptMapper;
import com.ruoyi.task.service.IRewardTaskDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 任务标题部门 服务层实现
 * 
 * @author sunli
 * @date 2018-12-31
 */
@Service
public class RewardTaskDeptServiceImpl implements IRewardTaskDeptService 
{
	@Autowired
	private RewardTaskDeptMapper rewardTaskDeptMapper;

	/**
     * 查询任务标题部门信息
     * 
     * @param rtdId 任务标题部门ID
     * @return 任务标题部门信息
     */
    @Override
	public RewardTaskDept selectRewardTaskDeptById(Integer rtdId)
	{
	    return rewardTaskDeptMapper.selectRewardTaskDeptById(rtdId);
	}
	
	/**
     * 查询任务标题部门列表
     * 
     * @param rewardTaskDept 任务标题部门信息
     * @return 任务标题部门集合
     */
	@Override
	public List<RewardTaskDept> selectRewardTaskDeptList(RewardTaskDept rewardTaskDept)
	{
	    return rewardTaskDeptMapper.selectRewardTaskDeptList(rewardTaskDept);
	}
	
    /**
     * 新增任务标题部门
     * 
     * @param rewardTaskDept 任务标题部门信息
     * @return 结果
     */
	@Override
	public int insertRewardTaskDept(RewardTaskDept rewardTaskDept)
	{
	    return rewardTaskDeptMapper.insertRewardTaskDept(rewardTaskDept);
	}
	
	/**
     * 修改任务标题部门
     * 
     * @param rewardTaskDept 任务标题部门信息
     * @return 结果
     */
	@Override
	public int updateRewardTaskDept(RewardTaskDept rewardTaskDept)
	{
	    return rewardTaskDeptMapper.updateRewardTaskDept(rewardTaskDept);
	}

	/**
     * 删除任务标题部门对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteRewardTaskDeptByIds(String ids)
	{
		return rewardTaskDeptMapper.deleteRewardTaskDeptByIds(Convert.toStrArray(ids));
	}
	
}
