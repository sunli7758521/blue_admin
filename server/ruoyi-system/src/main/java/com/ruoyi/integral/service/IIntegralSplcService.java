package com.ruoyi.integral.service;

import com.ruoyi.integral.domain.IntegralSplc;
import java.util.List;

/**
 * 审批流程人员设置 服务层
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
public interface IIntegralSplcService 
{
	/**
     * 查询审批流程人员设置信息
     * 
     * @param lcId 审批流程人员设置ID
     * @return 审批流程人员设置信息
     */
	public IntegralSplc selectIntegralSplcById(Integer lcId);
	
	/**
     * 查询审批流程人员设置列表
     * 
     * @param integralSplc 审批流程人员设置信息
     * @return 审批流程人员设置集合
     */
	public List<IntegralSplc> selectIntegralSplcList(IntegralSplc integralSplc);
	
	/**
     * 新增审批流程人员设置
     * 
     * @param integralSplc 审批流程人员设置信息
     * @return 结果
     */
	public int insertIntegralSplc(IntegralSplc integralSplc);
	
	/**
     * 修改审批流程人员设置
     * 
     * @param integralSplc 审批流程人员设置信息
     * @return 结果
     */
	public int updateIntegralSplc(IntegralSplc integralSplc);
		
	/**
     * 删除审批流程人员设置信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralSplcByIds(String ids);

}
