package com.ruoyi.integral.service;

import com.ruoyi.integral.domain.IntegralRecord;
import java.util.List;

/**
 * 商品兑换记录 服务层
 * 
 * @author sunli
 * @date 2018-10-30
 */
public interface IIntegralRecordService 
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
     * 删除商品兑换记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralRecordByIds(String ids);

	/**
	 * 修改审批状态 添加商品记录日志 以及修改商品所对应的积分
	 */
    int successStatus(int recordId, int status);
}
