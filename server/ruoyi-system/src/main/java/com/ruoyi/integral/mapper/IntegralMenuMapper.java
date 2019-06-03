package com.ruoyi.integral.mapper;

import com.ruoyi.integral.domain.IntegralMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  积分菜单管理 数据层
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
public interface IntegralMenuMapper 
{
	/**
     * 查询 积分菜单管理信息
     * 
     * @param menuId  积分菜单管理ID
     * @return  积分菜单管理信息
     */
	public IntegralMenu selectIntegralMenuById(Integer menuId);
	
	/**
     * 查询 积分菜单管理列表
     * 
     * @param integralMenu  积分菜单管理信息
     * @return  积分菜单管理集合
     */
	public List<IntegralMenu> selectIntegralMenuList(IntegralMenu integralMenu);
	
	/**
     * 新增 积分菜单管理
     * 
     * @param integralMenu  积分菜单管理信息
     * @return 结果
     */
	public int insertIntegralMenu(IntegralMenu integralMenu);
	
	/**
     * 修改 积分菜单管理
     * 
     * @param integralMenu  积分菜单管理信息
     * @return 结果
     */
	public int updateIntegralMenu(IntegralMenu integralMenu);
	
	/**
     * 删除 积分菜单管理
     * 
     * @param menuId  积分菜单管理ID
     * @return 结果
     */
	public int deleteIntegralMenuById(Integer menuId);
	
	/**
     * 批量删除 积分菜单管理
     * 
     * @param menuIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralMenuByIds(String[] menuIds);

	/**
	 * 加载积分餐单列表树
	 *	@param parentId 需要删除的数据ID
	 *  @return 结果
	 */
	IntegralMenu selectintegralMenuById(@Param("parentId") Integer parentId);

	/**
	 * 校验菜单名称
	 */
    IntegralMenu checkDeptNameUnique(@Param("typeName") String typeName, @Param("parentId") Long parentId);

	/**
	 * 查询 parentName
	 */
	String selectIntegralMenuParentName(@Param("parentId") Long parentId);


	/**
	 * 查询 parentName
	 */
	IntegralMenu selectMenuById(@Param("parentId") Long parentId);

	/**
	 * 获取积分类型
	 *
	 * @return 参数键值
	 */
    List<IntegralMenu> getTypeName(@Param("typeId")String typeId);
}