package com.ruoyi.web.controller.integral;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.integral.domain.IntegralMenu;
import com.ruoyi.integral.domain.IntegralType;
import com.ruoyi.integral.service.IIntegralMenuService;
import com.ruoyi.integral.service.IIntegralTypeService;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 *  积分菜单管理 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
@Controller
@RequestMapping("/integral/integralMenu")
public class IntegralMenuController extends BaseController
{
    private String prefix = "integral/integralMenu";

	@Autowired
	private ISysDeptService deptService;

	@Autowired
	private IIntegralMenuService integralMenuService;

	@Autowired
	private IIntegralTypeService integralTypeService;

	@RequiresPermissions("integral:integralMenu:view")
	@GetMapping()
	public String integralMenu()
	{
	    return prefix + "/integralMenu";
	}
	
	/**
	 * 查询 积分菜单管理列表
	 */
	@RequiresPermissions("integral:integralMenu:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(IntegralMenu integralMenu)
	{
		startPage();
        List<IntegralMenu> list = integralMenuService.selectIntegralMenuList(integralMenu);
		return getDataTable(list);
	}
	
	/**
	 * 新增 积分菜单管理
	 */
	@GetMapping("/add/{parentId}")
	public String add(@PathVariable("parentId") String parentId, ModelMap mmap)
	{
	Long parentIds = 100L;
	SysDept sysDept = deptService.selectDeptById(parentIds);
	IntegralMenu integralMenu = integralMenuService.selectintegralMenuById(Integer.parseInt(parentId));
		integralMenu.setDeptName(sysDept.getDeptName());
	    mmap.put("integralMenu",integralMenu );
		return prefix + "/add";
	}
	
	/**
	 * 新增保存 积分菜单管理
	 */
	@RequiresPermissions("integral:integralMenu:add")
	@Log(title = " 积分菜单管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(IntegralMenu integralMenu)
	{

		int i=0;
		String[] deptIds = integralMenu.getDeptIds().split(",");
		for (String deptId : deptIds) {
			if(!deptId.equals("100")){
				SysDept dept = deptService.selectDeptById(Long.parseLong(deptId));
				integralMenu.setDeptId(dept.getDeptId().intValue());
				integralMenu.setDeptName(dept.getDeptName());
				i= integralMenuService.insertIntegralMenu(integralMenu);
				IntegralType type = new IntegralType();
				type.setTypeName(integralMenu.getTypeName());
				integralTypeService.insertIntegralType(type);
			}
			if(deptId.equals("100")){
				integralMenu.setDeptId(null);
				i= integralMenuService.insertIntegralMenu(integralMenu);
				IntegralType type = new IntegralType();
				type.setTypeName(integralMenu.getTypeName());
				integralTypeService.insertIntegralType(type);
			}


		}

		return toAjax(i);
	}

	/**
	 * 修改 积分菜单管理
	 */
	@GetMapping("/edit/{menuId}")
	public String edit(@PathVariable("menuId") Integer menuId, ModelMap mmap)
	{
		IntegralMenu integralMenu = integralMenuService.selectIntegralMenuById(menuId);
	    String parentName =	integralMenuService.selectIntegralMenuParentName(integralMenu.getParentId());
		 SysDept dept = deptService.selectDeptById(integralMenu.getDeptId().longValue());
		integralMenu.setDeptName(dept.getDeptName());
		integralMenu.setParentName(parentName);
		mmap.put("integralMenu", integralMenu);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存 积分菜单管理
	 */
	@RequiresPermissions("integral:integralMenu:edit")
	@Log(title = " 积分菜单管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(IntegralMenu integralMenu)
	{		
		return toAjax(integralMenuService.updateIntegralMenu(integralMenu));
	}
	
	/**
	 * 删除 积分菜单管理
	 */
	@RequiresPermissions("integral:integralMenu:remove")
	@Log(title = " 积分菜单管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(integralMenuService.deleteIntegralMenuByIds(ids));
	}

    /**
     * 加载积分餐单列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Map<String, Object>> treeData()
    {
       return integralMenuService.selectIntegralMenuTree();
    }
	/**
	 * 选择菜单树
	 */
	@GetMapping("/selectIntegralMenuTree/{menuId}")
	public String selectIntegralMenuTree(@PathVariable("menuId") String menuId, ModelMap mmap)
	{
		mmap.put("dept", integralMenuService.selectIntegralMenuById(Integer.parseInt(menuId)));
		return prefix + "/tree";
	}

	/**
	 * 校验菜单名称
	 */
	@PostMapping("/checkIntegralMenuNameUnique")
	@ResponseBody
	public String checkDeptNameUnique( IntegralMenu integralMenu)
	{
		return integralMenuService.checkIntegralMenuUnique(integralMenu);
	}

	/**
	 * 选择部门树
	 */
	@GetMapping("/selectIntegralMenuDeptTree/{deptId}")
	public String selectIntegralMenuDeptTree(@PathVariable("deptId") String deptId, ModelMap mmap)
	{
		System.out.println(deptService.selectDeptById(Long.parseLong(deptId)));
		mmap.put("dept", deptService.selectDeptById(Long.parseLong(deptId)));
		return "system/dept" + "/tree";
	}
}

