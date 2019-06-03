package com.ruoyi.system.service;

import com.ruoyi.system.domain.UserLoginLog;
import java.util.List;

/**
 * 用户登录记录 服务层
 * 
 * @author sunli
 * @date 2019-05-21
 */
public interface IUserLoginLogService 
{
	/**
     * 查询用户登录记录信息
     * 
     * @param userLogId 用户登录记录ID
     * @return 用户登录记录信息
     */
	public UserLoginLog selectUserLoginLogById(Long userLogId);
	
	/**
     * 查询用户登录记录列表
     * 
     * @param userLoginLog 用户登录记录信息
     * @return 用户登录记录集合
     */
	public List<UserLoginLog> selectUserLoginLogList(UserLoginLog userLoginLog);
	
	/**
     * 新增用户登录记录
     * 
     * @param userLoginLog 用户登录记录信息
     * @return 结果
     */
	public int insertUserLoginLog(UserLoginLog userLoginLog);
	
	/**
     * 修改用户登录记录
     * 
     * @param userLoginLog 用户登录记录信息
     * @return 结果
     */
	public int updateUserLoginLog(UserLoginLog userLoginLog);
		
	/**
     * 删除用户登录记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteUserLoginLogByIds(String ids);
	/**  统计今日所用的访问量*/
	Long selectCountNum();
}
