package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysUserDeptPostMapper;
import com.ruoyi.system.domain.SysUserDeptPost;
import com.ruoyi.system.service.ISysUserDeptPostService;
import com.ruoyi.common.support.Convert;

/**
 * 用户属于那个部门管理那个部门 服务层实现
 * 
 * @author sunli
 * @date 2018-12-27
 */
@Service
public class SysUserDeptPostServiceImpl implements ISysUserDeptPostService 
{
	@Autowired
	private SysUserDeptPostMapper sysUserDeptPostMapper;

	/**
     * 查询用户属于那个部门管理那个部门信息
     * 
     * @param udId 用户属于那个部门管理那个部门ID
     * @return 用户属于那个部门管理那个部门信息
     */
    @Override
	public SysUserDeptPost selectSysUserDeptPostById(Integer udId)
	{
	    return sysUserDeptPostMapper.selectSysUserDeptPostById(udId);
	}
	
	/**
     * 查询用户属于那个部门管理那个部门列表
     * 
     * @param sysUserDeptPost 用户属于那个部门管理那个部门信息
     * @return 用户属于那个部门管理那个部门集合
     */
	@Override
	public List<SysUserDeptPost> selectSysUserDeptPostList(SysUserDeptPost sysUserDeptPost)
	{
	    return sysUserDeptPostMapper.selectSysUserDeptPostList(sysUserDeptPost);
	}
	
    /**
     * 新增用户属于那个部门管理那个部门
     * 
     * @param sysUserDeptPost 用户属于那个部门管理那个部门信息
     * @return 结果
     */
	@Override
	public int insertSysUserDeptPost(SysUserDeptPost sysUserDeptPost)
	{
	    return sysUserDeptPostMapper.insertSysUserDeptPost(sysUserDeptPost);
	}
	
	/**
     * 修改用户属于那个部门管理那个部门
     * 
     * @param sysUserDeptPost 用户属于那个部门管理那个部门信息
     * @return 结果
     */
	@Override
	public int updateSysUserDeptPost(SysUserDeptPost sysUserDeptPost)
	{
	    return sysUserDeptPostMapper.updateSysUserDeptPost(sysUserDeptPost);
	}

	/**
     * 删除用户属于那个部门管理那个部门对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSysUserDeptPostByIds(String ids)
	{
		return sysUserDeptPostMapper.deleteSysUserDeptPostByIds(Convert.toStrArray(ids));
	}

	/**
	 *  通过用户id 删处他所管的 部门id】
	 * @param userId 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int delectByUserId(Long userId) {
		return sysUserDeptPostMapper.delectByUserId(userId);
	}

	/**
	 *  通过用户id 查询所有本人所管理的部门
	 * @param userId 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public List<SysUserDeptPost> selectByUserId(Long userId) {
		return sysUserDeptPostMapper.selectByUserId(userId);
	}

	/** 查看 所管理的部门 */
	@Override
	public List<SysUserDeptPost> selectUserDepts(Long userId) {
		return sysUserDeptPostMapper.selectUserDepts(userId);
	}

	/** 修改 所管理部门*/
	@Override
	public Integer updateDepts(String deptIds, Long userId) {
		Integer row = 0;
		row = sysUserDeptPostMapper.delectByUserId(userId);
		if(deptIds !=null && deptIds !=""){
			String [] deptId =	deptIds.split(",");
            for (String id : deptId) {
                SysUserDeptPost userDeptPost = new SysUserDeptPost();
                userDeptPost.setDeptId(Integer.parseInt(id));
                userDeptPost.setUserId(userId.intValue());
                userDeptPost.setCreateTime(DateUtils.getNowDate());
                userDeptPost.setUpdateTime(DateUtils.getNowDate());
                row =    sysUserDeptPostMapper.insertSysUserDeptPost(userDeptPost);
            }
		}
		return row;
	}

}
