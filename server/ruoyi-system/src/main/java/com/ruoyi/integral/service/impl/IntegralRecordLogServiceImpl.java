package com.ruoyi.integral.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.integral.mapper.IntegralRecordLogMapper;
import com.ruoyi.integral.domain.IntegralRecordLog;
import com.ruoyi.integral.service.IIntegralRecordLogService;
import com.ruoyi.common.support.Convert;

/**
 * 商品兑换记录日志 服务层实现
 * 
 * @author sunli
 * @date 2018-11-03
 */
@Service
public class IntegralRecordLogServiceImpl implements IIntegralRecordLogService 
{
	@Autowired
	private IntegralRecordLogMapper integralRecordLogMapper;

	/**
     * 查询商品兑换记录日志信息
     * 
     * @param recordLogId 商品兑换记录日志ID
     * @return 商品兑换记录日志信息
     */
    @Override
	public IntegralRecordLog selectIntegralRecordLogById(Integer recordLogId)
	{
	    return integralRecordLogMapper.selectIntegralRecordLogById(recordLogId);
	}
	
	/**
     * 查询商品兑换记录日志列表
     * 
     * @param integralRecordLog 商品兑换记录日志信息
     * @return 商品兑换记录日志集合
     */
	@Override
	public List<IntegralRecordLog> selectIntegralRecordLogList(IntegralRecordLog integralRecordLog)
	{
	    return integralRecordLogMapper.selectIntegralRecordLogList(integralRecordLog);
	}
	
    /**
     * 新增商品兑换记录日志
     * 
     * @param integralRecordLog 商品兑换记录日志信息
     * @return 结果
     */
	@Override
	public int insertIntegralRecordLog(IntegralRecordLog integralRecordLog)
	{
	    return integralRecordLogMapper.insertIntegralRecordLog(integralRecordLog);
	}
	
	/**
     * 修改商品兑换记录日志
     * 
     * @param integralRecordLog 商品兑换记录日志信息
     * @return 结果
     */
	@Override
	public int updateIntegralRecordLog(IntegralRecordLog integralRecordLog)
	{
	    return integralRecordLogMapper.updateIntegralRecordLog(integralRecordLog);
	}

	/**
     * 删除商品兑换记录日志对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteIntegralRecordLogByIds(String ids)
	{
		return integralRecordLogMapper.deleteIntegralRecordLogByIds(Convert.toStrArray(ids));
	}
	
}
