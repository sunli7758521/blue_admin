package com.ruoyi.integral.service.impl;

import java.util.List;

import com.ruoyi.system.domain.SysPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.integral.mapper.IntegralTypeMapper;
import com.ruoyi.integral.domain.IntegralType;
import com.ruoyi.integral.service.IIntegralTypeService;
import com.ruoyi.common.support.Convert;

/**
 * 积分类别 服务层实现
 * 
 * @author sunli
 * @date 2018-10-27
 */
@Service
public class IntegralTypeServiceImpl implements IIntegralTypeService 
{
	@Autowired
	private IntegralTypeMapper integralTypeMapper;

	/**
     * 查询积分类别信息
     * 
     * @param typeId 积分类别ID
     * @return 积分类别信息
     */
    @Override
	public IntegralType selectIntegralTypeById(Integer typeId)
	{
	    return integralTypeMapper.selectIntegralTypeById(typeId);
	}
	
	/**
     * 查询积分类别列表
     * 
     * @param integralType 积分类别信息
     * @return 积分类别集合
     */
	@Override
	public List<IntegralType> selectIntegralTypeList(IntegralType integralType)
	{
	    return integralTypeMapper.selectIntegralTypeList(integralType);
	}
	
    /**
     * 新增积分类别
     * 
     * @param integralType 积分类别信息
     * @return 结果
     */
	@Override
	public int insertIntegralType(IntegralType integralType)
	{
	    return integralTypeMapper.insertIntegralType(integralType);
	}
	
	/**
     * 修改积分类别
     * 
     * @param integralType 积分类别信息
     * @return 结果
     */
	@Override
	public int updateIntegralType(IntegralType integralType)
	{
	    return integralTypeMapper.updateIntegralType(integralType);
	}

	/**
     * 删除积分类别对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteIntegralTypeByIds(String ids)
	{
		return integralTypeMapper.deleteIntegralTypeByIds(Convert.toStrArray(ids));
	}

	/**
	 * 获取积分类型查询字典数据信息
	 *
	 * @return 参数键值
	 */
	@Override
	public List<IntegralType> integralType() {
		return integralTypeMapper.selectIntegralTypeList(new IntegralType());
	}

}
