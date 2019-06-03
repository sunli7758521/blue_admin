package com.ruoyi.integral.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.integral.mapper.IntegralSplcMapper;
import com.ruoyi.integral.domain.IntegralSplc;
import com.ruoyi.integral.service.IIntegralSplcService;
import com.ruoyi.common.support.Convert;

/**
 * 审批流程人员设置 服务层实现
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
@Service
public class IntegralSplcServiceImpl implements IIntegralSplcService 
{
	@Autowired
	private IntegralSplcMapper integralSplcMapper;

	@Autowired
	private SysDeptMapper sysDeptMapper;
	/**
     * 查询审批流程人员设置信息
     * 
     * @param lcId 审批流程人员设置ID
     * @return 审批流程人员设置信息
     */
    @Override
	public IntegralSplc selectIntegralSplcById(Integer lcId)
	{
	    return integralSplcMapper.selectIntegralSplcById(lcId);
	}
	
	/**
     * 查询审批流程人员设置列表
     * 
     * @param integralSplc 审批流程人员设置信息
     * @return 审批流程人员设置集合
     */
	@Override
	public List<IntegralSplc> selectIntegralSplcList(IntegralSplc integralSplc)
	{
	    return integralSplcMapper.selectIntegralSplcList(integralSplc);
	}
	
    /**
     * 新增审批流程人员设置
     * 
     * @param integralSplc 审批流程人员设置信息
     * @return 结果
     */
	@Override
	public int insertIntegralSplc(IntegralSplc integralSplc)
	{
	   SysDept sysDept =  sysDeptMapper.selectDeptByName(integralSplc.getDeptId());
		integralSplc.setSpName(sysDept.getDeptName()+"审批流程");
		integralSplc.setCreatTime(DateUtils.getNowDate());
	    return integralSplcMapper.insertIntegralSplc(integralSplc);
	}
	
	/**
     * 修改审批流程人员设置
     * 
     * @param integralSplc 审批流程人员设置信息
     * @return 结果
     */
	@Override
	public int updateIntegralSplc(IntegralSplc integralSplc)
	{
	    return integralSplcMapper.updateIntegralSplc(integralSplc);
	}

	/**
     * 删除审批流程人员设置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteIntegralSplcByIds(String ids)
	{
		return integralSplcMapper.deleteIntegralSplcByIds(Convert.toStrArray(ids));
	}

}
