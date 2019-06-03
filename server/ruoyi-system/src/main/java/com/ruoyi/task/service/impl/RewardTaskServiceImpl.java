package com.ruoyi.task.service.impl;

import com.ruoyi.common.support.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.task.domain.RewardTask;
import com.ruoyi.task.domain.RewardTaskDept;
import com.ruoyi.task.mapper.RewardTaskDeptMapper;
import com.ruoyi.task.mapper.RewardTaskMapper;
import com.ruoyi.task.service.IRewardTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 悬赏任务 服务层实现
 * 
 * @author sunli
 * @date 2018-12-24
 */
@Service
public class RewardTaskServiceImpl implements IRewardTaskService 
{
	@Autowired
	private RewardTaskMapper rewardTaskMapper;

	@Autowired
	private RewardTaskDeptMapper rewardTaskDeptMapper;
	/**
     * 查询悬赏任务信息
     * 
     * @param rtId 悬赏任务ID
     * @return 悬赏任务信息
     */
    @Override
	public RewardTask selectRewardTaskById(Integer rtId)
	{
	    return rewardTaskMapper.selectRewardTaskById(rtId);
	}
	
	/**
     * 查询悬赏任务列表
     * 
     * @param rewardTask 悬赏任务信息
     * @return 悬赏任务集合
     */
	@Override
	public List<RewardTask> selectRewardTaskList(RewardTask rewardTask)
	{
	    return rewardTaskMapper.selectRewardTaskList(rewardTask);
	}
	
    /**
     * 新增悬赏任务
     * 
     * @param rewardTask 悬赏任务信息
     * @return 结果
     */
	@Override
	public int insertRewardTask(RewardTask rewardTask)
	{

		if(rewardTask.getStartTime() !="" || rewardTask.getEndTime() !=""){
			rewardTask.setStartTime(rewardTask.getStartTime());
			rewardTask.setEndTime(rewardTask.getEndTime());
		}else {
			rewardTask.setStartTime(null);
			rewardTask.setEndTime(null);
		}

	    int i =	rewardTaskMapper.insertRewardTask(rewardTask);
		addRewardTaskDept(rewardTask);
	    return i;
	}
	/** 添加悬赏任务关联的部门id */
	private void addRewardTaskDept(RewardTask rewardTask) {
		RewardTaskDept  rtd = new RewardTaskDept();
		String[] deptIds =  rewardTask.getDeptId().split(",");
		for (String deptId : deptIds) {
			rtd.setDId(Integer.parseInt(deptId));
			rtd.setRtId(rewardTask.getRtId());
			rtd.setCreateDate(DateUtils.getNowDate());
			rewardTaskDeptMapper.insertRewardTaskDept(rtd);
		}

	}

	/**
     * 修改悬赏任务
     * 
     * @param rewardTask 悬赏任务信息
     * @return 结果
     */
	@Override
	public int updateRewardTask(RewardTask rewardTask)
	{
        if(rewardTask.getStartTime() !="" || rewardTask.getEndTime() !=""){
            rewardTask.setStartTime(rewardTask.getStartTime());
            rewardTask.setEndTime(rewardTask.getEndTime());
        }else {
            rewardTask.setStartTime(null);
            rewardTask.setEndTime(null);
        }
        // 修改悬赏任务和部门的关联表数据
		updateRewardTaskDept(rewardTask);
	    return rewardTaskMapper.updateRewardTask(rewardTask);
	}
	/** 修改悬赏任务所关联部门 */
	private void updateRewardTaskDept(RewardTask rewardTask) {
		if(!rewardTask.getDeptId().equals("")){
		List<RewardTaskDept> rtd =	rewardTaskDeptMapper.selectByRewardTaskId(rewardTask.getRtId());
			if(rtd.size() == 0){
				String[] deptIds =  rewardTask.getDeptId().split(",");
				for (String id : deptIds) {
					RewardTaskDept ups = new RewardTaskDept();
					ups.setRtId(rewardTask.getRtId());
					ups.setDId(Integer.parseInt(id));
					ups.setUpdateTime(DateUtils.getNowDate());
					rewardTaskDeptMapper.insertRewardTaskDept(ups);
				}
			}else {
				rewardTaskDeptMapper.delectByRewardTaskId(rewardTask.getRtId());
				String[] deptIds1 = rewardTask.getDeptId().split(",");
				for (String id : deptIds1) {
					RewardTaskDept ups1 = new RewardTaskDept();
					ups1.setRtId(rewardTask.getRtId());
					ups1.setDId(Integer.parseInt(id));
					ups1.setUpdateTime(DateUtils.getNowDate());
					rewardTaskDeptMapper.insertRewardTaskDept(ups1);
				}
			}
		}

	}

	/**
     * 删除悬赏任务对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteRewardTaskByIds(String ids)
	{
		return rewardTaskMapper.deleteRewardTaskByIds(Convert.toStrArray(ids));
	}

	/**
	 * 悬赏任务 更改信息状态，启用 ，停用
	 *
	 * @param status ，taskId
	 * @return 结果
	 */
	@Override
	public int undo(Integer taskId, Integer status) {
		RewardTask rt =	rewardTaskMapper.selectRewardTaskById(taskId);
		int i =0 ;
		if(status==0){
			rt.setStatus("1");
			i = rewardTaskMapper.updateRewardTask(rt);
		} else if(status==1){
			rt.setStatus("0");
			i = rewardTaskMapper.updateRewardTask(rt);
		}

		return i;
	}

}
