package com.ruoyi.integral.service.impl;

import java.util.List;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.integral.domain.MenuDepts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.integral.mapper.MenuDeptMapper;
import com.ruoyi.integral.domain.MenuDept;
import com.ruoyi.integral.service.IMenuDeptService;
import com.ruoyi.common.support.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 积分项关联部门 服务层实现
 * 
 * @author sunli
 * @date 2019-05-20
 */
@Service
@Transactional
public class MenuDeptServiceImpl implements IMenuDeptService
{
	@Autowired
	private MenuDeptMapper menuDeptMapper;

	/**
     * 查询积分项关联部门信息
     * 
     * @param menuDeptId 积分项关联部门ID
     * @return 积分项关联部门信息
     */
    @Override
	public MenuDept selectMenuDeptById(Long menuDeptId)
	{
	    return menuDeptMapper.selectMenuDeptById(menuDeptId);
	}
	
	/**
     * 查询积分项关联部门列表
     * 
     * @param menuDept 积分项关联部门信息
     * @return 积分项关联部门集合
     */
	@Override
	public List<MenuDept> selectMenuDeptList(MenuDept menuDept)
	{
	    return menuDeptMapper.selectMenuDeptList(menuDept);
	}
	
    /**
     * 新增积分项关联部门
     * 
     * @param menuDept 积分项关联部门信息
     * @return 结果
     */
	@Override
	public int insertMenuDept(MenuDept menuDept)
	{
		// 通过积分项id 删除部门
	   Integer row = 0;
		row =  menuDeptMapper.deleteMenuDeptByMenuIds(menuDept.getMenuId());
	   if(StringUtils.isNotEmpty(menuDept.getDeptIds())){
		String []  depts = menuDept.getDeptIds().split(",");
		   for (String deptId : depts) {
			   MenuDept menu = new MenuDept();
			   menu.setMenuId(menuDept.getMenuId());
			   menu.setDeptId(Long.parseLong(deptId));
			   row =   menuDeptMapper.insertMenuDept(menu);
		   }
	   }
	    return row ;
	}
	
	/**
     * 修改积分项关联部门
     * 
     * @param menuDept 积分项关联部门信息
     * @return 结果
     */
	@Override
	public int updateMenuDept(MenuDept menuDept)
	{
	    return menuDeptMapper.updateMenuDept(menuDept);
	}

	/**
     * 删除积分项关联部门对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMenuDeptByIds(String ids)
	{
		return menuDeptMapper.deleteMenuDeptByIds(Convert.toStrArray(ids));
	}

	/** 通过积分项关联查询 部门 */
	@Override
	public List<String> selectMenuDeptByMenuId(String behaviorId) {
		return menuDeptMapper.selectMenuDeptByMenuId(behaviorId);
	}

}
