package com.ruoyi.integral.service;

import com.ruoyi.integral.domain.IntegralJk;

import java.util.List;

/**
 * 积分奖扣 服务层
 * 
 * @author sunli
 * @date 2018-10-25
 */
public interface IIntegralJkService 
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
     *//*
	public int insertIntegralJk(IntegralJk integralJk,String[] jkNames);*/
	
	/**
     * 修改积分奖扣
     * 
     * @param integralJk 积分奖扣信息
     * @return 结果
     */
	public int updateIntegralJk(IntegralJk integralJk);
		
	/**
     * 删除积分奖扣信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralJkByIds(String ids);

	/**
	 * 	批量添加员工奖扣
	 */
    int insertIntegralUserList(IntegralJk integralJk);

    /**
	 * 根据 部门名称 对员工进行分组
	 *
	 * @return 参数键值
	 */
//	List<Map<String,String>> jkNameGroup();

    /**
	 * 批量增加员工积分奖扣
	 *
	 *  @param integralJk 积分奖扣信息
	 *  @param jkNames
	 *  @return 结果
	 */
	/*int insertAllIntegralJk(IntegralJk integralJk, String[] jkNames);*/
}
