package com.ruoyi.integral.service.impl;

import java.util.List;

import com.ruoyi.integral.domain.IntegralDraw;
import com.ruoyi.integral.mapper.IntegralDrawMapper;
import com.ruoyi.integral.service.IIntegralDrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.support.Convert;

/**
 * 抽奖实现 服务层实现
 * 
 * @author sunli
 * @date 2019-02-21
 */
@Service
public class IntegralDrawServiceImpl implements IIntegralDrawService
{
	@Autowired
	private IntegralDrawMapper integralDrawMapper;

	/**
     * 查询抽奖实现信息
     * 
     * @param id 抽奖实现ID
     * @return 抽奖实现信息
     */
    @Override
	public IntegralDraw selectIntegralDrawById(Integer id)
	{
	    return integralDrawMapper.selectIntegralDrawById(id);
	}
	
	/**
     * 查询抽奖实现列表
     * 
     * @param integralDraw 抽奖实现信息
     * @return 抽奖实现集合
     */
	@Override
	public List<IntegralDraw> selectIntegralDrawList(IntegralDraw integralDraw)
	{
	    return integralDrawMapper.selectIntegralDrawList(integralDraw);
	}
	
    /**
     * 新增抽奖实现
     * 
     * @param integralDraw 抽奖实现信息
     * @return 结果
     */
	@Override
	public int insertIntegralDraw(IntegralDraw integralDraw)
	{
	    return integralDrawMapper.insertIntegralDraw(integralDraw);
	}
	
	/**
     * 修改抽奖实现
     * 
     * @param integralDraw 抽奖实现信息
     * @return 结果
     */
	@Override
	public int updateIntegralDraw(IntegralDraw integralDraw)
	{
	    return integralDrawMapper.updateIntegralDraw(integralDraw);
	}

	/**
     * 删除抽奖实现对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteIntegralDrawByIds(String ids)
	{
		return integralDrawMapper.deleteIntegralDrawByIds(Convert.toStrArray(ids));
	}
	
}
