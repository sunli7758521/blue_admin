package com.ruoyi.integral.mapper;

import com.ruoyi.integral.domain.PdIntegral;
import java.util.List;	

/**
 * 品德A积分管理 数据层
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
public interface PdIntegralMapper 
{
	/**
     * 查询品德A积分管理信息
     * 
     * @param behaviorId 品德A积分管理ID
     * @return 品德A积分管理信息
     */
	public PdIntegral selectPdIntegralById(Integer behaviorId);
	
	/**
     * 查询品德A积分管理列表
     * 
     * @param pdIntegral 品德A积分管理信息
     * @return 品德A积分管理集合
     */
	public List<PdIntegral> selectPdIntegralList(PdIntegral pdIntegral);
	
	/**
     * 新增品德A积分管理
     * 
     * @param pdIntegral 品德A积分管理信息
     * @return 结果
     */
	public int insertPdIntegral(PdIntegral pdIntegral);
	
	/**
     * 修改品德A积分管理
     * 
     * @param pdIntegral 品德A积分管理信息
     * @return 结果
     */
	public int updatePdIntegral(PdIntegral pdIntegral);
	
	/**
     * 删除品德A积分管理
     * 
     * @param behaviorId 品德A积分管理ID
     * @return 结果
     */
	public int deletePdIntegralById(Integer behaviorId);
	
	/**
     * 批量删除品德A积分管理
     * 
     * @param behaviorIds 需要删除的数据ID
     * @return 结果
     */
	public int deletePdIntegralByIds(String[] behaviorIds);

	/**
	 * 积分菜单管理
	 *
	 * @param typeId,
	 * @return 查询类型的结果数量
	 */
    Integer selectCountNum(Integer typeId);
}