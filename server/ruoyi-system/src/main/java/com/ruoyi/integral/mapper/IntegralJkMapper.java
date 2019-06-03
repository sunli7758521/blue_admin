package com.ruoyi.integral.mapper;

import com.ruoyi.integral.domain.IntegralJk;
import java.util.List;
import java.util.Map;

/**
 * 积分奖扣 数据层
 * 
 * @author sunli
 * @date 2018-10-25
 */
public interface IntegralJkMapper 
{
	/**
     * 查询积分奖扣信息
     * 
     * @param jkId 积分奖扣ID
     * @return 积分奖扣信息
     */
	public IntegralJk selectIntegralJkById(Integer jkId);
	
	/**
     * 查询积分奖扣列表
     * 
     * @param integralJk 积分奖扣信息
     * @return 积分奖扣集合
     */
	public List<IntegralJk> selectIntegralJkList(IntegralJk integralJk);
	
	/**
     * 新增积分奖扣
     * 
     * @param integralJk 积分奖扣信息
     * @return 结果
     */
	public int insertIntegralJk(IntegralJk integralJk);
	
	/**
     * 修改积分奖扣
     * 
     * @param integralJk 积分奖扣信息
     * @return 结果
     */
	public int updateIntegralJk(IntegralJk integralJk);
	
	/**
     * 删除积分奖扣
     * 
     * @param jkId 积分奖扣ID
     * @return 结果
     */
	public int deleteIntegralJkById(Integer jkId);
	
	/**
     * 批量删除积分奖扣
     * 
     * @param jkIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralJkByIds(String[] jkIds);

	/**
	 * 查询部门分组人名
	 *
	 * @return 结果
	 */
	List<Map<String,String>> selectDeptAndUserName();
}