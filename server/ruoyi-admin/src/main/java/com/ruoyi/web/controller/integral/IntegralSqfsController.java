package com.ruoyi.web.controller.integral;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.integral.domain.IntegralSqfs;
import com.ruoyi.integral.service.IIntegralSqfsService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 积分申请方式 信息操作处理
 * 
 * @author sunli
 * @date 2018-11-01
 */
@Controller
@RequestMapping("/integral/integralSqfs")
public class IntegralSqfsController extends BaseController
{
    private String prefix = "integral/integralSqfs";
	
	@Autowired
	private IIntegralSqfsService integralSqfsService;
	
	@RequiresPermissions("integral:integralSqfs:view")
	@GetMapping()
	public String integralSqfs()
	{
	    return prefix + "/integralSqfs";
	}
	
	/**
	 * 查询积分申请方式列表
	 */
	@RequiresPermissions("integral:integralSqfs:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(IntegralSqfs integralSqfs)
	{
		startPage();
        List<IntegralSqfs> list = integralSqfsService.selectIntegralSqfsList(integralSqfs);
		return getDataTable(list);
	}
	
	/**
	 * 新增积分申请方式
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存积分申请方式
	 */
	@RequiresPermissions("integral:integralSqfs:add")
	@Log(title = "积分申请方式", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(IntegralSqfs integralSqfs)
	{		
		return toAjax(integralSqfsService.insertIntegralSqfs(integralSqfs));
	}

	/**
	 * 修改积分申请方式
	 */
	@GetMapping("/edit/{sqfsId}")
	public String edit(@PathVariable("sqfsId") Integer sqfsId, ModelMap mmap)
	{
		IntegralSqfs integralSqfs = integralSqfsService.selectIntegralSqfsById(sqfsId);
		mmap.put("integralSqfs", integralSqfs);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存积分申请方式
	 */
	@RequiresPermissions("integral:integralSqfs:edit")
	@Log(title = "积分申请方式", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(IntegralSqfs integralSqfs)
	{		
		return toAjax(integralSqfsService.updateIntegralSqfs(integralSqfs));
	}
	
	/**
	 * 删除积分申请方式
	 */
	@RequiresPermissions("integral:integralSqfs:remove")
	@Log(title = "积分申请方式", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(integralSqfsService.deleteIntegralSqfsByIds(ids));
	}
	
}
