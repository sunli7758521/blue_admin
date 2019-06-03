package com.ruoyi.integral.mapper;

import com.ruoyi.integral.domain.IntegralSqfs;
import java.util.List;	

/**
 * 积分申请方式 数据层
 * 
 * @author sunli
 * @date 2018-11-01
 */
public interface IntegralSqfsMapper 
{
	/**
     * 查询积分申请方式信息
     * 
     * @param sqfsId 积分申请方式ID
     * @return 积分申请方式信息
     */
	public IntegralSqfs selectIntegralSqfsById(Integer sqfsId);
	
	/**
     * 查询积分申请方式列表
     * 
     * @param integralSqfs 积分申请方式信息
     * @return 积分申请方式集合
     */
	public List<IntegralSqfs> selectIntegralSqfsList(IntegralSqfs integralSqfs);
	
	/**
     * 新增积分申请方式
     * 
     * @param integralSqfs 积分申请方式信息
     * @return 结果
     */
	public int insertIntegralSqfs(IntegralSqfs integralSqfs);
	
	/**
     * 修改积分申请方式
     * 
     * @param integralSqfs 积分申请方式信息
     * @return 结果
     */
	public int updateIntegralSqfs(IntegralSqfs integralSqfs);
	
	/**
     * 删除积分申请方式
     * 
     * @param sqfsId 积分申请方式ID
     * @return 结果
     */
	public int deleteIntegralSqfsById(Integer sqfsId);
	
	/**
     * 批量删除积分申请方式
     * 
     * @param sqfsIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralSqfsByIds(String[] sqfsIds);
	
}