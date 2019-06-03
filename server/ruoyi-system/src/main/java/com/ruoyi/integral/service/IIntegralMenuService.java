package com.ruoyi.integral.service;

import com.ruoyi.integral.domain.IntegralMenu;

import java.util.List;
import java.util.Map;

/**
 *  积分菜单管理 服务层
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
public interface IIntegralMenuService 
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
     * 删除 积分菜单管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralMenuByIds(String ids);

	/**
	 * 加载积分餐单列表树
	 *
	 *  @return 结果
	 */
    List<Map<String, Object>> selectIntegralMenuTree();

	/**
	 * 加载积分餐单列表树
	 *	@param parentId 需要删除的数据ID
	 *  @return 结果
	 */
	IntegralMenu selectintegralMenuById(Integer parentId);

	/**
	 * 校验菜单名称
	 */
    String checkIntegralMenuUnique(IntegralMenu integralMenu);

	/**
	 * 查询 parentName
	 */
	String selectIntegralMenuParentName(Long parentId);

	/**
	 * 获取积分类型
	 *
	 * @return 参数键值
	 */
    List<IntegralMenu> getTypeName(String typeId);
}
