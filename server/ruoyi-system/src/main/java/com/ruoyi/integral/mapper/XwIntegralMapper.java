package com.ruoyi.integral.mapper;

import com.ruoyi.integral.domain.XwIntegral;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 行为c积分管理 数据层
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
public interface XwIntegralMapper 
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
     * 删除行为c积分管理
     * 
     * @param behaviorId 行为c积分管理ID
     * @return 结果
     */
	public int deleteXwIntegralById(Integer behaviorId);
	
	/**
     * 批量删除行为c积分管理
     * 
     * @param behaviorIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteXwIntegralByIds(String[] behaviorIds);

	/**
	 * 积分菜单管理
	 *
	 * @param typeId,
	 * @return 查询类型的结果数量
	 */
	Integer selectCountNum(@Param("typeId") Integer typeId);

}