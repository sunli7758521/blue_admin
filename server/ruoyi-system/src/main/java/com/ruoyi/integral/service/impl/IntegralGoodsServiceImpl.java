package com.ruoyi.integral.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.integral.mapper.IntegralGoodsMapper;
import com.ruoyi.integral.domain.IntegralGoods;
import com.ruoyi.integral.service.IIntegralGoodsService;
import com.ruoyi.common.support.Convert;

/**
 * 商品管理 服务层实现
 * 
 * @author sunli
 * @date 2018-10-30
 */
@Service
public class IntegralGoodsServiceImpl implements IIntegralGoodsService 
{
	@Autowired
	private IntegralGoodsMapper integralGoodsMapper;

	/**
     * 查询商品管理信息
     * 
     * @param goodId 商品管理ID
     * @return 商品管理信息
     */
    @Override
	public IntegralGoods selectIntegralGoodsById(Integer goodId)
	{
	    return integralGoodsMapper.selectIntegralGoodsById(goodId);
	}
	
	/**
     * 查询商品管理列表
     * 
     * @param integralGoods 商品管理信息
     * @return 商品管理集合
     */
	@Override
	public List<IntegralGoods> selectIntegralGoodsList(IntegralGoods integralGoods)
	{
	    return integralGoodsMapper.selectIntegralGoodsList(integralGoods);
	}
	
    /**
     * 新增商品管理
     * 
     * @param integralGoods 商品管理信息
     * @return 结果
     */
	@Override
	public int insertIntegralGoods(IntegralGoods integralGoods)
	{
		integralGoods.setCreateTime(DateUtils.getNowDate());
	    return integralGoodsMapper.insertIntegralGoods(integralGoods);
	}
	
	/**
     * 修改商品管理
     * 
     * @param integralGoods 商品管理信息
     * @return 结果
     */
	@Override
	public int updateIntegralGoods(IntegralGoods integralGoods)
	{
		integralGoods.setUpdateTime(DateUtils.getNowDate());
	    return integralGoodsMapper.updateIntegralGoods(integralGoods);
	}

	/**
     * 删除商品管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteIntegralGoodsByIds(String ids)
	{
		return integralGoodsMapper.deleteIntegralGoodsByIds(Convert.toStrArray(ids));
	}
	
}
