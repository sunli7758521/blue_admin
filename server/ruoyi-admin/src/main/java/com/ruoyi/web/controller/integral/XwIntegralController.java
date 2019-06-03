package com.ruoyi.web.controller.integral;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.integral.domain.MenuDept;
import com.ruoyi.integral.domain.MenuDepts;
import com.ruoyi.integral.domain.XwIntegral;
import com.ruoyi.integral.service.IMenuDeptService;
import com.ruoyi.integral.service.IXwIntegralService;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 行为c积分管理 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
@Controller
@RequestMapping("/integral/xwIntegral")
public class XwIntegralController extends BaseController
{
    private String prefix = "integral/xwIntegral";
	
	@Autowired
	private IXwIntegralService xwIntegralService;

	@Autowired
	private ISysDeptService deptService;

	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private IMenuDeptService iMenuDeptService;

	@RequiresPermissions("integral:xwIntegral:view")
	@GetMapping()
	public String xwIntegral()
	{
	    return prefix + "/xwIntegral";
	}
	
	/**
	 * 查询积分项列表
	 */
	@RequiresPermissions("integral:xwIntegral:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(XwIntegral xwIntegral)
	{
		startPage();
        List<XwIntegral> list = xwIntegralService.selectXwIntegralList(xwIntegral);

		return getDataTable(list);
	}
	
	/**
	 * 新增积分项
	 */
	@GetMapping("/add/{parentId}")
	public String add(@PathVariable("parentId") String parentId, ModelMap mmap)
	{
		mmap.put("dept", deptService.selectDeptById(Long.parseLong(parentId)));
		return prefix + "/add";
	}
	
	/**
	 * 新增保存行为c积分管理
	 */
	@RequiresPermissions("integral:xwIntegral:add")
	@Log(title = "添加积分管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(XwIntegral xwIntegral)
	{
		return toAjax(xwIntegralService.insertXwIntegral(xwIntegral));
	}

	/**
	 * 修改积分项
	 */
	@GetMapping("/edit/{behaviorId}")
	public String edit(@PathVariable("behaviorId") Integer behaviorId, ModelMap mmap)
	{
		XwIntegral xwIntegral = xwIntegralService.selectXwIntegralById(behaviorId);
		mmap.put("xwIntegral", xwIntegral);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存积分项
	 */
	@RequiresPermissions("integral:xwIntegral:edit")
	@Log(title = "行为c积分管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(XwIntegral xwIntegral)
	{
		return toAjax(xwIntegralService.updateXwIntegral(xwIntegral));
	}
	
	/**
	 * 删除行为c积分管理
	 */
	@RequiresPermissions("integral:xwIntegral:remove")
	@Log(title = "行为c积分管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(xwIntegralService.deleteXwIntegralByIds(ids));
	}

    /**
     * 禁用行为c积分管理
     */
    @GetMapping("/integralTy/{behaviorId}/{status}")
	@ResponseBody
    public AjaxResult integralTyBehaviorId(@PathVariable("behaviorId") Integer behaviorId, @PathVariable("status") Integer status,ModelMap mmap)
    {
        return toAjax(xwIntegralService.integralTyBehaviorId(behaviorId,status));
    }
	/**
	 * 选择部门树
	 */
	@GetMapping("/selectIntegralMenuDeptTree/{deptId}")
	public String selectIntegralMenuDeptTree(@PathVariable("deptId") String deptId, ModelMap mmap)
	{

		if(StringUtils.isNotEmpty(deptId)){
			String[] deptIds =	deptId.split(",");
			for (String id : deptIds) {
				System.out.println(deptService.selectDeptById(Long.parseLong(id)));
				mmap.put("dept", deptService.selectDeptById(Long.parseLong(id)));
			}
		}
		return "system/dept" + "/tree";
	}

	/**
	 *  行为c 菜单设置审批人
	 */
	@GetMapping("/app/{behaviorId}")
	public String app(@PathVariable("behaviorId") Integer behaviorId, ModelMap mmap)
	{
		XwIntegral xwIntegral = xwIntegralService.selectXwIntegralById(behaviorId);
		mmap.put("xwIntegral", xwIntegral);
		return prefix + "/app";
	}

	/**
	 *  菜单设置审批人 查询所用本部门员工
	 */
	@GetMapping("/selectDeptUser/{deptId}")
	@Log(title = "查询所用本部门员工", businessType = BusinessType.OTHER)
	@ResponseBody
	public List<SysUser> selectDeptUser(@PathVariable("deptId") String deptId )
	{
		return sysUserService.selectDeptUser(deptId);
	}

	@PostMapping("/editAll")
	public String editAll(String ids, ModelMap mmap)
	{
		mmap.put("ids",ids);
		return  prefix  +  "/update";
	}

	/**
	 *  菜单设置审批人 查询所用本部门员工
	 */
	@GetMapping("/updateDept/{behaviorId}")
	public String  updateDept(@PathVariable("behaviorId") String behaviorId ,ModelMap mmap)
	{
		/** 通过积分项关联查询 部门 */
		Map<String,List<String>> map = new HashMap<>();
		List<String> list =	iMenuDeptService.selectMenuDeptByMenuId(behaviorId);
		XwIntegral menus = xwIntegralService.selectXwIntegralById(Integer.parseInt(behaviorId));
			map.put(menus.getBehaviorTitle(),list);
		mmap.put("behaviorId",behaviorId);
		mmap.put("map",map);
		return  prefix + "/updateDept";
	}


}
