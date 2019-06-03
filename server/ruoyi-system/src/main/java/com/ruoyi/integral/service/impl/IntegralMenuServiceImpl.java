package com.ruoyi.integral.service.impl;

import com.ruoyi.common.constant.IntegralConstants;
import com.ruoyi.common.support.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.integral.domain.IntegralMenu;
import com.ruoyi.integral.mapper.IntegralMenuMapper;
import com.ruoyi.integral.mapper.PdIntegralMapper;
import com.ruoyi.integral.mapper.XwIntegralMapper;
import com.ruoyi.integral.mapper.YjIntegralMapper;
import com.ruoyi.integral.service.IIntegralMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  积分菜单管理 服务层实现
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
@Service
public class IntegralMenuServiceImpl implements IIntegralMenuService 
{
	@Autowired
	private IntegralMenuMapper integralMenuMapper;

	@Autowired
	private XwIntegralMapper xwIntegralMapper;

	@Autowired
	private PdIntegralMapper pdIntegralMapper;

	@Autowired
	private YjIntegralMapper yjIntegralMapper;


	/**
	 *
     * 查询 积分菜单管理信息
     * 
     * @param menuId  积分菜单管理ID
     * @return  积分菜单管理信息
     */
    @Override
	public IntegralMenu selectIntegralMenuById(Integer menuId)
	{
	    return integralMenuMapper.selectIntegralMenuById(menuId);
	}
	
	/**
     * 查询 积分菜单管理列表
     * 
     * @param integralMenu  积分菜单管理信息
     * @return  积分菜单管理集合
     */
	@Override
	public List<IntegralMenu> selectIntegralMenuList(IntegralMenu integralMenu)
	{
		List<IntegralMenu> integralMenus =  integralMenuMapper.selectIntegralMenuList(integralMenu);
		//查询所对应的数量
		for (IntegralMenu menu : integralMenus) {
			if(menu.getTypeId() != null){
				if(menu.getTypeId()==3){
					Integer num = xwIntegralMapper.selectCountNum(menu.getTypeId());
					menu.setCountC(num);
				}
				if(menu.getTypeId()==2){
					Integer num = yjIntegralMapper.selectCountNum(menu.getTypeId());
					menu.setCountB(num);
				}
				if(menu.getTypeId()==1){
					Integer num = pdIntegralMapper.selectCountNum(menu.getTypeId());
					menu.setCountB(num);
				}
			/*if(menu.getTypeId()==0){
				menu.setCount(menu.getCountA()+menu.getCountB()+menu.getCountC());
			}*/
			}

		}
	    return integralMenus;
	}

    /**
     * 新增 积分菜单管理
     * 
     * @param integralMenu  积分菜单管理信息
     * @return 结果
     */
	@Override
	public int insertIntegralMenu(IntegralMenu integralMenu)
	{
		IntegralMenu info = integralMenuMapper.selectMenuById(integralMenu.getParentId());
		integralMenu.setAncestors(info.getAncestors() + "," + integralMenu.getParentId());
		integralMenu.setTypeId(info.getTypeId());
		integralMenu.setCreateTime(DateUtils.getNowDate());
	    return integralMenuMapper.insertIntegralMenu(integralMenu);
	}
	
	/**
     * 修改 积分菜单管理
     * 
     * @param integralMenu  积分菜单管理信息
     * @return 结果
     */
	@Override
	public int updateIntegralMenu(IntegralMenu integralMenu)
	{
		// 判断deptIds 是否为空
		if(integralMenu.getDeptIds()!=null && integralMenu.getDeptIds() !="" ){
			integralMenu.setDeptIds(integralMenu.getDeptIds());
		}else{
			integralMenu.setDeptIds(integralMenu.getDeptIds());
		}
		return integralMenuMapper.updateIntegralMenu(integralMenu);
	}

	/**
     * 删除 积分菜单管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteIntegralMenuByIds(String ids)
	{
		return integralMenuMapper.deleteIntegralMenuByIds(Convert.toStrArray(ids));
	}

	/**
	 * 加载积分餐单列表树
	 *
	 *  @return 结果
	 */
	@Override
	public List<Map<String, Object>> selectIntegralMenuTree() {

		List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
		List<IntegralMenu> integralList = selectIntegralMenuList(new IntegralMenu());
		trees = getTrees(integralList, false, null);
		return trees;
	}

	/**
	 * 加载积分餐单列表树
	 *	@param parentId 需要删除的数据ID
	 *  @return 结果
	 */
	@Override
	public IntegralMenu selectintegralMenuById(Integer parentId) {
		return integralMenuMapper.selectintegralMenuById(parentId);
	}

	/**
	 * 校验菜单名称
	 */
	@Override
	public String checkIntegralMenuUnique(IntegralMenu integralMenu) {
		Long menuId = StringUtils.isNull(integralMenu.getMenuId()) ? -1L : integralMenu.getMenuId();
		IntegralMenu info = integralMenuMapper.checkDeptNameUnique(integralMenu.getTypeName(), integralMenu.getParentId());
		if (StringUtils.isNotNull(info) && info.getMenuId() != menuId.longValue())
		{
			return IntegralConstants.INTEGRAL_MENU_UNIQUE;
		}
		return IntegralConstants.INTEGRAL_MENU_NOT_UNIQUE;
	}

	/**
	 * 查询 parentName
	 */
	@Override
	public String selectIntegralMenuParentName(Long parentId) {

		return integralMenuMapper.selectIntegralMenuParentName(parentId);
	}

	/**
	 * 获取积分类型
	 *
	 * @return 参数键值
	 */
	@Override
	public List<IntegralMenu> getTypeName(String typeId) {
		return integralMenuMapper.getTypeName(typeId);
	}

	/**
	 * 对象转部门树
	 *
	 * @param menuList 部门列表
	 * @param isCheck 是否需要选中
	 * @param roleDeptList 角色已存在菜单列表
	 * @return
	 */
	public List<Map<String, Object>> getTrees(List<IntegralMenu> integralList, boolean isCheck, List<String> roleDeptList)
	{

		List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
		for (IntegralMenu integral : integralList)
		{
			if (IntegralConstants.INTEGRAL_MENU.equals(integral.getStatus()))
			{
				Map<String, Object> deptMap = new HashMap<String, Object>();
				deptMap.put("id", integral.getMenuId());
				deptMap.put("pId", integral.getParentId());
				deptMap.put("name", integral.getTypeName());
				deptMap.put("title", integral.getTypeName());
				deptMap.put("orderNum", integral.getOrderNum());
				deptMap.put("createTime", integral.getCreateTime());
				deptMap.put("updateTime", integral.getUpdateTime());
				deptMap.put("remark", integral.getRemark());
				deptMap.put("status", integral.getStatus());
				deptMap.put("ancestors",integral.getAncestors());
				deptMap.put("typeId",integral.getTypeId());
				deptMap.put("deptId", integral.getDeptId());
				deptMap.put("postId",integral.getPostId());

				if (isCheck)
				{
					deptMap.put("checked", roleDeptList.contains(integral.getMenuId() + integral.getTypeName()));
				}
				else
				{
					deptMap.put("checked", false);
				}
				trees.add(deptMap);
			}
		}
		return trees;
	}

}
