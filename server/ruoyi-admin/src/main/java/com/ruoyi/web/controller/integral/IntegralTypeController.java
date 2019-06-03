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
import com.ruoyi.integral.domain.IntegralType;
import com.ruoyi.integral.service.IIntegralTypeService;
import com.ruoyi.web.core.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;

/**
 * 积分类别 信息操作处理
 * 
 * @author sunli
 * @date 2018-10-27
 */
@Controller
@RequestMapping("/integral/integralType")
public class IntegralTypeController extends BaseController
{
    private String prefix = "integral/integralType";
	
	@Autowired
	private IIntegralTypeService integralTypeService;
	
	@RequiresPermissions("integral:integralType:view")
	@GetMapping()
	public String integralType()
	{
	    return prefix + "/integralType";
	}
	
	/**
	 * 查询积分类别列表
	 */
	@RequiresPermissions("integral:integralType:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(IntegralType integralType)
	{
		startPage();
        List<IntegralType> list = integralTypeService.selectIntegralTypeList(integralType);
		return getDataTable(list);
	}
	
	/**
	 * 新增积分类别
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存积分类别
	 */
	@RequiresPermissions("integral:integralType:add")
	@Log(title = "积分类别", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(IntegralType integralType)
	{		
		return toAjax(integralTypeService.insertIntegralType(integralType));
	}

	/**
	 * 修改积分类别
	 */
	@GetMapping("/edit/{typeId}")
	public String edit(@PathVariable("typeId") Integer typeId, ModelMap mmap)
	{
		IntegralType integralType = integralTypeService.selectIntegralTypeById(typeId);
		mmap.put("integralType", integralType);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存积分类别
	 */
	@RequiresPermissions("integral:integralType:edit")
	@Log(title = "积分类别", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(IntegralType integralType)
	{		
		return toAjax(integralTypeService.updateIntegralType(integralType));
	}
	
	/**
	 * 删除积分类别
	 */
	@RequiresPermissions("integral:integralType:remove")
	@Log(title = "积分类别", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(integralTypeService.deleteIntegralTypeByIds(ids));
	}
	
}
