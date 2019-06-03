package com.ruoyi.integral.service;

import com.ruoyi.integral.domain.YjIntegral;
import java.util.List;

/**
 * 业绩B积分管理 服务层
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
public interface IYjIntegralService 
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
     * 删除业绩B积分管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteYjIntegralByIds(String ids);

	/**
	 * 禁用业绩B积分管理
	 */
    int integralTyBehaviorId(Integer behaviorId,Integer status);

    int deleteYJIntegralById(Integer behaviorId);
}
