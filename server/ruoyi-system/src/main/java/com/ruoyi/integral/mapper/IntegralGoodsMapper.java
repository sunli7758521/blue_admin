package com.ruoyi.integral.mapper;

import com.ruoyi.integral.domain.IntegralGoods;
import java.util.List;	

/**
 * 商品管理 数据层
 * 
 * @author sunli
 * @date 2018-10-30
 */
public interface IntegralGoodsMapper 
{
	/**
     * 查询商品管理信息
     * 
     * @param goodId 商品管理ID
     * @return 商品管理信息
     */
	public IntegralGoods selectIntegralGoodsById(Integer goodId);
	
	/**
     * 查询商品管理列表
     * 
     * @param integralGoods 商品管理信息
     * @return 商品管理集合
     */
	public List<IntegralGoods> selectIntegralGoodsList(IntegralGoods integralGoods);
	
	/**
     * 新增商品管理
     * 
     * @param integralGoods 商品管理信息
     * @return 结果
     */
	public int insertIntegralGoods(IntegralGoods integralGoods);
	
	/**
     * 修改商品管理
     * 
     * @param integralGoods 商品管理信息
     * @return 结果
     */
	public int updateIntegralGoods(IntegralGoods integralGoods);
	
	/**
     * 删除商品管理
     * 
     * @param goodId 商品管理ID
     * @return 结果
     */
	public int deleteIntegralGoodsById(Integer goodId);
	
	/**
     * 批量删除商品管理
     * 
     * @param goodIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralGoodsByIds(String[] goodIds);
	
}