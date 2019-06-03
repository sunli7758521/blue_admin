package com.ruoyi.integral.mapper;

import com.ruoyi.integral.domain.IntegralType;
import java.util.List;	

/**
 * 积分类别 数据层
 * 
 * @author sunli
 * @date 2018-10-27
 */
public interface IntegralTypeMapper 
{
	/**
     * 查询积分类别信息
     * 
     * @param typeId 积分类别ID
     * @return 积分类别信息
     */
	public IntegralType selectIntegralTypeById(Integer typeId);
	
	/**
     * 查询积分类别列表
     * 
     * @param integralType 积分类别信息
     * @return 积分类别集合
     */
	public List<IntegralType> selectIntegralTypeList(IntegralType integralType);
	
	/**
     * 新增积分类别
     * 
     * @param integralType 积分类别信息
     * @return 结果
     */
	public int insertIntegralType(IntegralType integralType);
	
	/**
     * 修改积分类别
     * 
     * @param integralType 积分类别信息
     * @return 结果
     */
	public int updateIntegralType(IntegralType integralType);
	
	/**
     * 删除积分类别
     * 
     * @param typeId 积分类别ID
     * @return 结果
     */
	public int deleteIntegralTypeById(Integer typeId);
	
	/**
     * 批量删除积分类别
     * 
     * @param typeIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralTypeByIds(String[] typeIds);
	
}