package com.ruoyi.integral.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.integral.mapper.IntegralAppUserMapper;
import com.ruoyi.integral.domain.IntegralAppUser;
import com.ruoyi.integral.service.IIntegralAppUserService;
import com.ruoyi.common.support.Convert;

/**
 * 积分项申请方式 关联 用户 服务层实现
 * 
 * @author sunli
 * @date 2019-05-29
 */
@Service
public class IntegralAppUserServiceImpl implements IIntegralAppUserService 
{
	@Autowired
	private IntegralAppUserMapper integralAppUserMapper;

	/**
     * 查询积分项申请方式 关联 用户信息
     * 
     * @param userMenuId 积分项申请方式 关联 用户ID
     * @return 积分项申请方式 关联 用户信息
     */
    @Override
	public IntegralAppUser selectIntegralAppUserById(Long userMenuId)
	{
	    return integralAppUserMapper.selectIntegralAppUserById(userMenuId);
	}
	
	/**
     * 查询积分项申请方式 关联 用户列表
     * 
     * @param integralAppUser 积分项申请方式 关联 用户信息
     * @return 积分项申请方式 关联 用户集合
     */
	@Override
	public List<IntegralAppUser> selectIntegralAppUserList(IntegralAppUser integralAppUser)
	{
	    return integralAppUserMapper.selectIntegralAppUserList(integralAppUser);
	}
	
    /**
     * 新增积分项申请方式 关联 用户
     * 
     * @param integralAppUser 积分项申请方式 关联 用户信息
     * @return 结果
     */
	@Override
	public int insertIntegralAppUser(IntegralAppUser integralAppUser)
	{
	    return integralAppUserMapper.insertIntegralAppUser(integralAppUser);
	}
	
	/**
     * 修改积分项申请方式 关联 用户
     * 
     * @param integralAppUser 积分项申请方式 关联 用户信息
     * @return 结果
     */
	@Override
	public int updateIntegralAppUser(IntegralAppUser integralAppUser)
	{
	    return integralAppUserMapper.updateIntegralAppUser(integralAppUser);
	}

	/**
     * 删除积分项申请方式 关联 用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteIntegralAppUserByIds(String ids)
	{
		return integralAppUserMapper.deleteIntegralAppUserByIds(Convert.toStrArray(ids));
	}
	
}
