package com.ruoyi.integral.service;

import com.ruoyi.integral.domain.IntegralType;

import java.util.List;

/**
 * 积分类别 服务层
 * 
 * @author sunli
 * @date 2018-10-27
 */
public interface IIntegralTypeService 
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
     * 删除积分类别信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralTypeByIds(String ids);

	/**
	 * 获取积分类型查询字典数据信息
	 *
	 * @return 参数键值
	 */
	List<IntegralType> integralType();
}
