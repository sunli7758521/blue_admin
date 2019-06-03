package com.ruoyi.integral.service.impl;

import com.ruoyi.common.constant.IntegralConstants;
import com.ruoyi.common.support.Convert;
import com.ruoyi.integral.domain.Integral;
import com.ruoyi.integral.domain.IntegralLog;
import com.ruoyi.integral.domain.IntegralLogExport;
import com.ruoyi.integral.mapper.IntegralLogMapper;
import com.ruoyi.integral.mapper.IntegralMapper;
import com.ruoyi.integral.service.IIntegralLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 积分日志 服务层实现
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
@Service
public class IntegralLogServiceImpl implements IIntegralLogService 
{
	@Autowired
	private IntegralLogMapper integralLogMapper;

	@Autowired
	private IntegralMapper integralMapper;

	/**
     * 查询积分日志信息
     * 
     * @param logId 积分日志ID
     * @return 积分日志信息
     */
    @Override
	public IntegralLog selectIntegralLogById(Integer logId)
	{
	    return integralLogMapper.selectIntegralLogById(logId);
	}
	
	/**
     * 查询积分日志列表
     * 
     * @param integralLog 积分日志信息
     * @return 积分日志集合
     */
	@Override
	public List<IntegralLog> selectIntegralLogList(IntegralLog integralLog)
	{
	    return integralLogMapper.selectIntegralLogList(integralLog);
	}
	
    /**
     * 新增积分日志
     * 
     * @param integralLog 积分日志信息
     * @return 结果
     */
	@Override
	public int insertIntegralLog(IntegralLog integralLog)
	{
	    return integralLogMapper.insertIntegralLog(integralLog);
	}
	
	/**
     * 修改积分日志
     * 
     * @param integralLog 积分日志信息
     * @return 结果
     */
	@Override
	public int updateIntegralLog(IntegralLog integralLog)
	{
	    return integralLogMapper.updateIntegralLog(integralLog);
	}

	/**
     * 删除积分日志对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteIntegralLogByIds(String ids)
	{
		return integralLogMapper.deleteIntegralLogByIds(Convert.toStrArray(ids));
	}

	/**
	 * 撤销积分日志审批信息
	 *
	 * @param approvalId 撤销积分日志审批 approvalId
	 * @return 结果
	 */
	@Override
	public int undo(Integer approvalId ,Integer status) {
		IntegralLog log = integralLogMapper.selectIntegralLogById(approvalId);
		Integral integral = null;

			if (status.equals(IntegralConstants.INTEGRALLOG_CHE_XIAO) ){
				log.setStatus(IntegralConstants.INTEGRALLOG_HUI_CHE);
				if(log.getUserPhone() == null ){
					integral = integralMapper.selectUserName(log.getUserName());
				}else{
					integral =	integralMapper.selectUsernameAndPhone(log.getUserName(),log.getUserPhone().toString());
				}
				integral.setCountIntegral(integral.getCountIntegral() - log.getBianIntegral());
			int  i = integralLogMapper.updateIntegralLog(log);

				if (integral.getAddIntegral()==null){
					integral.setAddIntegral(0 + log.getBianIntegral());
				}else{
					integral.setAddIntegral(integral.getAddIntegral() - log.getBianIntegral());
				}
			} else if (status.equals(IntegralConstants.INTEGRALLOG_HUI_CHE)){
				log.setStatus(IntegralConstants.INTEGRALLOG_CHE_XIAO);
				if(log.getUserPhone() == null ){
					integral = integralMapper.selectUserName(log.getUserName());
				}else{
					integral =	integralMapper.selectUsernameAndPhone(log.getUserName(),log.getUserPhone().toString());
				}
				integral.setCountIntegral(integral.getCountIntegral() + log.getBianIntegral());

				int  bb = integralLogMapper.updateIntegralLog(log);

				if (integral.getDelIntegral()==null){
					integral.setAddIntegral(0 + log.getBianIntegral());
				}else{
					integral.setAddIntegral(integral.getAddIntegral() + log.getBianIntegral());
				}
			}
		return integralMapper.updateIntegral(integral);
	}


//	/**
//	 * 审批日志 导出
//	 * importExcel
//	 */
//	@Override
//	public List<IntegralLogExport> selectIntegralLogExportList(IntegralLog integralLog) {
//		return integralLogMapper.selectIntegralLogExportList(integralLog);
//	}

}
