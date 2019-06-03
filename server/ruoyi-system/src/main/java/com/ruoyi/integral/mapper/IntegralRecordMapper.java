package com.ruoyi.integral.mapper;

import com.ruoyi.integral.domain.IntegralRecord;
import java.util.List;	

/**
 * 商品兑换记录 数据层
 * 
 * @author sunli
 * @date 2018-10-30
 */
public interface IntegralRecordMapper 
{
	/**
     * 查询商品兑换记录信息
     * 
     * @param recordId 商品兑换记录ID
     * @return 商品兑换记录信息
     */
	public IntegralRecord selectIntegralRecordById(Integer recordId);
	
	/**
     * 查询商品兑换记录列表
     * 
     * @param integralRecord 商品兑换记录信息
     * @return 商品兑换记录集合
     */
	public List<IntegralRecord> selectIntegralRecordList(IntegralRecord integralRecord);
	
	/**
     * 新增商品兑换记录
     * 
     * @param integralRecord 商品兑换记录信息
     * @return 结果
     */
	public int insertIntegralRecord(IntegralRecord integralRecord);
	
	/**
     * 修改商品兑换记录
     * 
     * @param integralRecord 商品兑换记录信息
     * @return 结果
     */
	public int updateIntegralRecord(IntegralRecord integralRecord);
	
	/**
     * 删除商品兑换记录
     * 
     * @param recordId 商品兑换记录ID
     * @return 结果
     */
	public int deleteIntegralRecordById(Integer recordId);
	
	/**
     * 批量删除商品兑换记录
     * 
     * @param recordIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralRecordByIds(String[] recordIds);
	
}