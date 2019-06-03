package com.ruoyi.integral.mapper;

import com.ruoyi.integral.domain.IntegralDraw;

import java.util.List;

/**
 * 抽奖实现 数据层
 * 
 * @author sunli
 * @date 2019-02-21
 */
public interface IntegralDrawMapper 
{
	/**
     * 查询抽奖实现信息
     * 
     * @param id 抽奖实现ID
     * @return 抽奖实现信息
     */
	public IntegralDraw selectIntegralDrawById(Integer id);
	
	/**
     * 查询抽奖实现列表
     * 
     * @param integralDraw 抽奖实现信息
     * @return 抽奖实现集合
     */
	public List<IntegralDraw> selectIntegralDrawList(IntegralDraw integralDraw);
	
	/**
     * 新增抽奖实现
     * 
     * @param integralDraw 抽奖实现信息
     * @return 结果
     */
	public int insertIntegralDraw(IntegralDraw integralDraw);
	
	/**
     * 修改抽奖实现
     * 
     * @param integralDraw 抽奖实现信息
     * @return 结果
     */
	public int updateIntegralDraw(IntegralDraw integralDraw);
	
	/**
     * 删除抽奖实现
     * 
     * @param id 抽奖实现ID
     * @return 结果
     */
	public int deleteIntegralDrawById(Integer id);
	
	/**
     * 批量删除抽奖实现
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralDrawByIds(String[] ids);
	
}