package com.ruoyi.integral.mapper;

import com.ruoyi.integral.domain.YjIntegral;
import java.util.List;	

/**
 * 业绩B积分管理 数据层
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
public interface YjIntegralMapper 
{
	/**
     * 查询业绩B积分管理信息
     * 
     * @param behaviorId 业绩B积分管理ID
     * @return 业绩B积分管理信息
     */
	public YjIntegral selectYjIntegralById(Integer behaviorId);
	
	/**
     * 查询业绩B积分管理列表
     * 
     * @param yjIntegral 业绩B积分管理信息
     * @return 业绩B积分管理集合
     */
	public List<YjIntegral> selectYjIntegralList(YjIntegral yjIntegral);
	
	/**
     * 新增业绩B积分管理
     * 
     * @param yjIntegral 业绩B积分管理信息
     * @return 结果
     */
	public int insertYjIntegral(YjIntegral yjIntegral);
	
	/**
     * 修改业绩B积分管理
     * 
     * @param yjIntegral 业绩B积分管理信息
     * @return 结果
     */
	public int updateYjIntegral(YjIntegral yjIntegral);
	
	/**
     * 删除业绩B积分管理
     * 
     * @param behaviorId 业绩B积分管理ID
     * @return 结果
     */
	public int deleteYjIntegralById(Integer behaviorId);
	
	/**
     * 批量删除业绩B积分管理
     * 
     * @param behaviorIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteYjIntegralByIds(String[] behaviorIds);

	/**
	 * 积分菜单管理
	 *
	 * @param typeId,
	 * @return 查询类型的结果数量
	 */
	Integer selectCountNum(Integer typeId);

	/**
	 * 修改保存业绩B积分管理
	 *//*
    int deleteYJIntegralById(Integer behaviorId);*/
}