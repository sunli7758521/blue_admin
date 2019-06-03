package com.ruoyi.task.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.task.mapper.RewardTaskUserMapper;
import com.ruoyi.task.domain.RewardTaskUser;
import com.ruoyi.task.service.IRewardTaskUserService;
import com.ruoyi.common.support.Convert;

/**
 * 任务标题员工 服务层实现
 * 
 * @author sunli
 * @date 2018-12-31
 */
@Service
public class RewardTaskUserServiceImpl implements IRewardTaskUserService 
{
	@Autowired
	private RewardTaskUserMapper rewardTaskUserMapper;

	/**
     * 查询任务标题员工信息
     * 
     * @param rtuId 任务标题员工ID
     * @return 任务标题员工信息
     */
    @Override
	public RewardTaskUser selectRewardTaskUserById(Integer rtuId)
	{
	    return rewardTaskUserMapper.selectRewardTaskUserById(rtuId);
	}
	
	/**
     * 查询任务标题员工列表
     * 
     * @param rewardTaskUser 任务标题员工信息
     * @return 任务标题员工集合
     */
	@Override
	public List<RewardTaskUser> selectRewardTaskUserList(RewardTaskUser rewardTaskUser)
	{
	    return rewardTaskUserMapper.selectRewardTaskUserList(rewardTaskUser);
	}
	
    /**
     * 新增任务标题员工
     * 
     * @param rewardTaskUser 任务标题员工信息
     * @return 结果
     */
	@Override
	public int insertRewardTaskUser(RewardTaskUser rewardTaskUser)
	{
	    return rewardTaskUserMapper.insertRewardTaskUser(rewardTaskUser);
	}
	
	/**
     * 修改任务标题员工
     * 
     * @param rewardTaskUser 任务标题员工信息
     * @return 结果
     */
	@Override
	public int updateRewardTaskUser(RewardTaskUser rewardTaskUser)
	{
	    return rewardTaskUserMapper.updateRewardTaskUser(rewardTaskUser);
	}

	/**
     * 删除任务标题员工对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteRewardTaskUserByIds(String ids)
	{
		return rewardTaskUserMapper.deleteRewardTaskUserByIds(Convert.toStrArray(ids));
	}
	
}
