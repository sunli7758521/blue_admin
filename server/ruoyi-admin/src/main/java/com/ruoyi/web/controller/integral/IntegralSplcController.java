package com.ruoyi.web.controller.integral;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.integral.domain.IntegralSplc;
import com.ruoyi.integral.service.IIntegralSplcService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 审批流程人员设置 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
@Controller
@RequestMapping("/integral/integralSplc")
public class IntegralSplcController extends BaseController
{
    private String prefix = "integral/integralSplc";
	
	@Autowired
	private IIntegralSplcService integralSplcService;
	
	@RequiresPermissions("integral:integralSplc:view")
	@GetMapping()
	public String integralSplc()
	{
	    return prefix + "/integralSplc";
	}
	
	/**
	 * 查询审批流程人员设置列表
	 */
	@RequiresPermissions("integral:integralSplc:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(IntegralSplc integralSplc)
	{
		startPage();
        List<IntegralSplc> list = integralSplcService.selectIntegralSplcList(integralSplc);
		return getDataTable(list);
	}
	
	/**
	 * 新增审批流程人员设置
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存审批流程人员设置
	 */
	@RequiresPermissions("integral:integralSplc:add")
	@Log(title = "审批流程人员设置", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(IntegralSplc integralSplc)
	{
		return toAjax(integralSplcService.insertIntegralSplc(integralSplc));
	}

	/**
	 * 修改审批流程人员设置
	 */
	@GetMapping("/edit/{lcId}")
	public String edit(@PathVariable("lcId") Integer lcId, ModelMap mmap)
	{
		IntegralSplc integralSplc = integralSplcService.selectIntegralSplcById(lcId);
		mmap.put("integralSplc", integralSplc);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存审批流程人员设置
	 */
	@RequiresPermissions("integral:integralSplc:edit")
	@Log(title = "审批流程人员设置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(IntegralSplc integralSplc)
	{		
		return toAjax(integralSplcService.updateIntegralSplc(integralSplc));
	}
	
	/**
	 * 删除审批流程人员设置
	 */
	@RequiresPermissions("integral:integralSplc:remove")
	@Log(title = "审批流程人员设置", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(integralSplcService.deleteIntegralSplcByIds(ids));
	}
	
}
