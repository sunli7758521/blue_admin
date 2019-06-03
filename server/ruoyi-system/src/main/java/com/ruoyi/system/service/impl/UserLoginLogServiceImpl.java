package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UserLoginLogMapper;
import com.ruoyi.system.domain.UserLoginLog;
import com.ruoyi.system.service.IUserLoginLogService;
import com.ruoyi.common.support.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户登录记录 服务层实现
 * 
 * @author sunli
 * @date 2019-05-21
 */
@Service
@Transactional
public class UserLoginLogServiceImpl implements IUserLoginLogService 
{
	@Autowired
	private UserLoginLogMapper userLoginLogMapper;

	/**
     * 查询用户登录记录信息
     * 
     * @param userLogId 用户登录记录ID
     * @return 用户登录记录信息
     */
    @Override
	public UserLoginLog selectUserLoginLogById(Long userLogId)
	{
	    return userLoginLogMapper.selectUserLoginLogById(userLogId);
	}
	
	/**
     * 查询用户登录记录列表
     * 
     * @param userLoginLog 用户登录记录信息
     * @return 用户登录记录集合
     */
	@Override
	public List<UserLoginLog> selectUserLoginLogList(UserLoginLog userLoginLog)
	{
	    return userLoginLogMapper.selectUserLoginLogList(userLoginLog);
	}
	
    /**
     * 新增用户登录记录
     * 
     * @param userLoginLog 用户登录记录信息
     * @return 结果
     */
	@Override
	public int insertUserLoginLog(UserLoginLog userLoginLog)
	{
	    return userLoginLogMapper.insertUserLoginLog(userLoginLog);
	}
	
	/**
     * 修改用户登录记录
     * 
     * @param userLoginLog 用户登录记录信息
     * @return 结果
     */
	@Override
	public int updateUserLoginLog(UserLoginLog userLoginLog)
	{
	    return userLoginLogMapper.updateUserLoginLog(userLoginLog);
	}

	/**
     * 删除用户登录记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteUserLoginLogByIds(String ids)
	{
		return userLoginLogMapper.deleteUserLoginLogByIds(Convert.toStrArray(ids));
	}
	/**  统计今日所用的访问量*/
	@Override
	public Long selectCountNum() {
		return userLoginLogMapper.selectCountNum();
	}

}
