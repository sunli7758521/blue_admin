package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysUserDeptPost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户属于那个部门管理那个部门 数据层
 * 
 * @author sunli
 * @date 2018-12-27
 */
public interface SysUserDeptPostMapper 
{
	/**
     * 查询用户属于那个部门管理那个部门信息
     * 
     * @param udId 用户属于那个部门管理那个部门ID
     * @return 用户属于那个部门管理那个部门信息
     */
	public SysUserDeptPost selectSysUserDeptPostById(Integer udId);
	
	/**
     * 查询用户属于那个部门管理那个部门列表
     * 
     * @param sysUserDeptPost 用户属于那个部门管理那个部门信息
     * @return 用户属于那个部门管理那个部门集合
     */
	public List<SysUserDeptPost> selectSysUserDeptPostList(SysUserDeptPost sysUserDeptPost);
	
	/**
     * 新增用户属于那个部门管理那个部门
     * 
     * @param sysUserDeptPost 用户属于那个部门管理那个部门信息
     * @return 结果
     */
	public int insertSysUserDeptPost(SysUserDeptPost sysUserDeptPost);
	
	/**
     * 修改用户属于那个部门管理那个部门
     * 
     * @param sysUserDeptPost 用户属于那个部门管理那个部门信息
     * @return 结果
     */
	public int updateSysUserDeptPost(SysUserDeptPost sysUserDeptPost);
	
	/**
     * 删除用户属于那个部门管理那个部门
     * 
     * @param udId 用户属于那个部门管理那个部门ID
     * @return 结果
     */
	public int deleteSysUserDeptPostById(Integer udId);
	
	/**
     * 批量删除用户属于那个部门管理那个部门
     * 
     * @param udIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteSysUserDeptPostByIds(String[] udIds);

	/**
	 *  通过用户id 删处他所管的 部门id
	 * @param userId 需要删除的数据ID
	 * @return 结果
	 */
	int delectByUserId(@Param("userId") Long userId);

	/**
	 *  通过用户id 查询所有本人所管理的部门
	 * @param userId 需要删除的数据ID
	 * @return 结果
	 */
	List<SysUserDeptPost> selectByUserId(@Param("userId") Long userId);

	/** 查看 所管理的部门 */
    List<SysUserDeptPost> selectUserDepts(@Param("userId") Long userId);
}