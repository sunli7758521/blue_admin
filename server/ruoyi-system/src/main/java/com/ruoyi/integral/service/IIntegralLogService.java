package com.ruoyi.integral.service;

import com.ruoyi.integral.domain.IntegralLog;
import com.ruoyi.integral.domain.IntegralLogExport;

import java.util.List;

/**
 * 积分日志 服务层
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
public interface IIntegralLogService 
{
	/**
     * 查询积分日志信息
     * 
     * @param logId 积分日志ID
     * @return 积分日志信息
     */
	public IntegralLog selectIntegralLogById(Integer logId);
	
	/**
     * 查询积分日志列表
     * 
     * @param integralLog 积分日志信息
     * @return 积分日志集合
     */
	public List<IntegralLog> selectIntegralLogList(IntegralLog integralLog);
	
	/**
     * 新增积分日志
     * 
     * @param integralLog 积分日志信息
     * @return 结果
     */
	public int insertIntegralLog(IntegralLog integralLog);
	
	/**
     * 修改积分日志
     * 
     * @param integralLog 积分日志信息
     * @return 结果
     */
	public int updateIntegralLog(IntegralLog integralLog);
		
	/**
     * 删除积分日志信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralLogByIds(String ids);

	/**
	 * 撤销积分日志审批信息
	 *
	 * @param approvalId 撤销积分日志审批 approvalId
	 * @return 结果
	 */
	int undo(Integer approvalId,Integer status);

	/**
	 * 审批日志 导出
	 * importExcel
	 */

    //List<IntegralLogExport> selectIntegralLogExportList(IntegralLog integralLog);
}
