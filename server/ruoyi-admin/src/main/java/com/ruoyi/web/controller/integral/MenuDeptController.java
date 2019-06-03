package com.ruoyi.web.controller.integral;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.integral.domain.MenuDept;
import com.ruoyi.integral.service.IMenuDeptService;
import com.ruoyi.web.core.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;

/**
 * 积分项关联部门 信息操作处理
 * 
 * @author sunli
 * @date 2019-05-20
 */
@Controller
@RequestMapping("/integral/menuDept")
public class MenuDeptController extends BaseController
{
    private String prefix = "integral/menuDept";
	
	@Autowired
	private IMenuDeptService menuDeptService;
	
	@RequiresPermissions("integral:menuDept:view")
	@GetMapping()
	public String menuDept()
	{
	    return prefix + "/menuDept";
	}
	
	/**
	 * 查询积分项关联部门列表
	 */
	@RequiresPermissions("integral:menuDept:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MenuDept menuDept)
	{
		startPage();
        List<MenuDept> list = menuDeptService.selectMenuDeptList(menuDept);
		return getDataTable(list);
	}
	
	/**
	 * 新增积分项关联部门
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存积分项关联部门
	 */
	@RequiresPermissions("integral:menuDept:add")
	@Log(title = "积分项关联部门", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(MenuDept menuDept)
	{		
		return toAjax(menuDeptService.insertMenuDept(menuDept));
	}

	/**
	 * 修改积分项关联部门
	 */
	@GetMapping("/edit/{menuDeptId}")
	public String edit(@PathVariable("menuDeptId") Long menuDeptId, ModelMap mmap)
	{
		MenuDept menuDept = menuDeptService.selectMenuDeptById(menuDeptId);
		mmap.put("menuDept", menuDept);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存积分项关联部门
	 */
	@RequiresPermissions("integral:menuDept:edit")
	@Log(title = "积分项关联部门", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(MenuDept menuDept)
	{		
		return toAjax(menuDeptService.updateMenuDept(menuDept));
	}
	
	/**
	 * 删除积分项关联部门
	 */
	@RequiresPermissions("integral:menuDept:remove")
	@Log(title = "积分项关联部门", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(menuDeptService.deleteMenuDeptByIds(ids));
	}
	
}
