package com.ruoyi.integral.mapper;

import com.ruoyi.integral.domain.IntegralAppUser;
import java.util.List;	

/**
 * 积分项申请方式 关联 用户 数据层
 * 
 * @author sunli
 * @date 2019-05-29
 */
public interface IntegralAppUserMapper 
{
	/**
     * 查询积分项申请方式 关联 用户信息
     * 
     * @param userMenuId 积分项申请方式 关联 用户ID
     * @return 积分项申请方式 关联 用户信息
     */
	public IntegralAppUser selectIntegralAppUserById(Long userMenuId);
	
	/**
     * 查询积分项申请方式 关联 用户列表
     * 
     * @param integralAppUser 积分项申请方式 关联 用户信息
     * @return 积分项申请方式 关联 用户集合
     */
	public List<IntegralAppUser> selectIntegralAppUserList(IntegralAppUser integralAppUser);
	
	/**
     * 新增积分项申请方式 关联 用户
     * 
     * @param integralAppUser 积分项申请方式 关联 用户信息
     * @return 结果
     */
	public int insertIntegralAppUser(IntegralAppUser integralAppUser);
	
	/**
     * 修改积分项申请方式 关联 用户
     * 
     * @param integralAppUser 积分项申请方式 关联 用户信息
     * @return 结果
     */
	public int updateIntegralAppUser(IntegralAppUser integralAppUser);
	
	/**
     * 删除积分项申请方式 关联 用户
     * 
     * @param userMenuId 积分项申请方式 关联 用户ID
     * @return 结果
     */
	public int deleteIntegralAppUserById(Long userMenuId);
	
	/**
     * 批量删除积分项申请方式 关联 用户
     * 
     * @param userMenuIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralAppUserByIds(String[] userMenuIds);
	
}