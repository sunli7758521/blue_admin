package com.ruoyi.integral.mapper;

import com.ruoyi.integral.domain.MenuDept;
import com.ruoyi.integral.domain.MenuDepts;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 积分项关联部门 数据层
 * 
 * @author sunli
 * @date 2019-05-20
 */
public interface MenuDeptMapper 
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
     * 删除积分项关联部门
     * 
     * @param menuDeptId 积分项关联部门ID
     * @return 结果
     */
	public int deleteMenuDeptById(Long menuDeptId);
	
	/**
     * 批量删除积分项关联部门
     * 
     * @param menuDeptIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteMenuDeptByIds(String[] menuDeptIds);

	/** 通过积分项关联查询 部门 */
    List<String> selectMenuDeptByMenuId(@Param("behaviorId") String behaviorId);

	/**
	 * 通过积分项id 批量删除关联部门
	 *
	 * @param menuIds 需要删除的数据ID
	 * @return 结果
	 */
	Integer deleteMenuDeptByMenuIds(@Param("menuIds") Long menuIds);

	/**  删除关联部门*/
	int deleteByMenuIds(String[] menuIds);
}