package com.ruoyi.integral.service;

import com.ruoyi.integral.domain.IntegralRecordLog;
import java.util.List;

/**
 * 商品兑换记录日志 服务层
 * 
 * @author sunli
 * @date 2018-11-03
 */
public interface IIntegralRecordLogService 
{
	/**
     * 查询商品兑换记录日志信息
     * 
     * @param recordLogId 商品兑换记录日志ID
     * @return 商品兑换记录日志信息
     */
	public IntegralRecordLog selectIntegralRecordLogById(Integer recordLogId);
	
	/**
     * 查询商品兑换记录日志列表
     * 
     * @param integralRecordLog 商品兑换记录日志信息
     * @return 商品兑换记录日志集合
     */
	public List<IntegralRecordLog> selectIntegralRecordLogList(IntegralRecordLog integralRecordLog);
	
	/**
     * 新增商品兑换记录日志
     * 
     * @param integralRecordLog 商品兑换记录日志信息
     * @return 结果
     */
	public int insertIntegralRecordLog(IntegralRecordLog integralRecordLog);
	
	/**
     * 修改商品兑换记录日志
     * 
     * @param integralRecordLog 商品兑换记录日志信息
     * @return 结果
     */
	public int updateIntegralRecordLog(IntegralRecordLog integralRecordLog);
		
	/**
     * 删除商品兑换记录日志信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralRecordLogByIds(String ids);
	
}
