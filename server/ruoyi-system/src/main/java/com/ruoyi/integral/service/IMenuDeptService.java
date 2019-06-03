package com.ruoyi.integral.service;

import com.ruoyi.integral.domain.MenuDept;
import com.ruoyi.integral.domain.MenuDepts;

import java.util.List;

/**
 * 积分项关联部门 服务层
 * 
 * @author sunli
 * @date 2019-05-20
 */
public interface IMenuDeptService 
{
	/**
     * 查询积分项关联部门信息
     * 
     * @param menuDeptId 积分项关联部门ID
     * @return 积分项关联部门信息
     */
	public MenuDept selectMenuDeptById(Long menuDeptId);
	
	/**
     * 查询积分项关联部门列表
     * 
     * @param menuDept 积分项关联部门信息
     * @return 积分项关联部门集合
     */
	public List<MenuDept> selectMenuDeptList(MenuDept menuDept);
	
	/**
     * 新增积分项关联部门
     * 
     * @param menuDept 积分项关联部门信息
     * @return 结果
     */
	public int insertMenuDept(MenuDept menuDept);
	
	/**
     * 修改积分项关联部门
     * 
     * @param menuDept 积分项关联部门信息
     * @return 结果
     */
	public int updateMenuDept(MenuDept menuDept);
		
	/**
     * 删除积分项关联部门信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMenuDeptByIds(String ids);

	/** 通过积分项关联查询 部门 */
    List<String> selectMenuDeptByMenuId(String behaviorId);
}
