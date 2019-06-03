package com.ruoyi.integral.service;

import com.ruoyi.integral.domain.XwIntegral;

import java.util.List;

/**
 * 行为c积分管理 服务层
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
public interface IXwIntegralService 
{
	/**
     * 查询行为c积分管理信息
     * 
     * @param behaviorId 行为c积分管理ID
     * @return 行为c积分管理信息
     */
	public XwIntegral selectXwIntegralById(Integer behaviorId);
	
	/**
     * 查询行为c积分管理列表
     * 
     * @param xwIntegral 行为c积分管理信息
     * @return 行为c积分管理集合
     */
	public List<XwIntegral> selectXwIntegralList(XwIntegral xwIntegral);
	
	/**
     * 新增行为c积分管理
     * 
     * @param xwIntegral 行为c积分管理信息
     * @return 结果
     */
	public int insertXwIntegral(XwIntegral xwIntegral);
	
	/**
     * 修改行为c积分管理
     * 
     * @param xwIntegral 行为c积分管理信息
     * @return 结果
     */
	public int updateXwIntegral(XwIntegral xwIntegral);
		
	/**
     * 删除行为c积分管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteXwIntegralByIds(String ids);

	/**
	 * 禁用行为c积分管理
	 */
    int integralTyBehaviorId(Integer behaviorId,Integer status);

    /**
	 * 	 通过id删除
	 * */
	int deleteXwIntegralById(Integer behaviorId);
}
