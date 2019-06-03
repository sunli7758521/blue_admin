package com.ruoyi.integral.service;

import com.ruoyi.integral.domain.IntegralSqfs;

import java.util.List;

/**
 * 积分申请方式 服务层
 * 
 * @author sunli
 * @date 2018-11-01
 */
public interface IIntegralSqfsService 
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
     * 删除积分申请方式信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralSqfsByIds(String ids);

	/**
	 * 查询申请方式
	 *
	 * @return 可申请方式
	 */
	List<IntegralSqfs> getSqfs();
}
