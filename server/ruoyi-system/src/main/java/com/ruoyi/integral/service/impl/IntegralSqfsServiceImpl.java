package com.ruoyi.integral.service.impl;

import java.util.List;

import com.ruoyi.integral.domain.IntegralSplc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.integral.mapper.IntegralSqfsMapper;
import com.ruoyi.integral.domain.IntegralSqfs;
import com.ruoyi.integral.service.IIntegralSqfsService;
import com.ruoyi.common.support.Convert;

/**
 * 积分申请方式 服务层实现
 * 
 * @author sunli
 * @date 2018-11-01
 */
@Service
public class IntegralSqfsServiceImpl implements IIntegralSqfsService 
{
	@Autowired
	private IntegralSqfsMapper integralSqfsMapper;

	/**
     * 查询积分申请方式信息
     * 
     * @param sqfsId 积分申请方式ID
     * @return 积分申请方式信息
     */
    @Override
	public IntegralSqfs selectIntegralSqfsById(Integer sqfsId)
	{
	    return integralSqfsMapper.selectIntegralSqfsById(sqfsId);
	}
	
	/**
     * 查询积分申请方式列表
     * 
     * @param integralSqfs 积分申请方式信息
     * @return 积分申请方式集合
     */
	@Override
	public List<IntegralSqfs> selectIntegralSqfsList(IntegralSqfs integralSqfs)
	{
	    return integralSqfsMapper.selectIntegralSqfsList(integralSqfs);
	}
	
    /**
     * 新增积分申请方式
     * 
     * @param integralSqfs 积分申请方式信息
     * @return 结果
     */
	@Override
	public int insertIntegralSqfs(IntegralSqfs integralSqfs)
	{
	    return integralSqfsMapper.insertIntegralSqfs(integralSqfs);
	}
	
	/**
     * 修改积分申请方式
     * 
     * @param integralSqfs 积分申请方式信息
     * @return 结果
     */
	@Override
	public int updateIntegralSqfs(IntegralSqfs integralSqfs)
	{
	    return integralSqfsMapper.updateIntegralSqfs(integralSqfs);
	}

	/**
     * 删除积分申请方式对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteIntegralSqfsByIds(String ids)
	{
		return integralSqfsMapper.deleteIntegralSqfsByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<IntegralSqfs> getSqfs() {
		return integralSqfsMapper.selectIntegralSqfsList(new IntegralSqfs());
	}

}
