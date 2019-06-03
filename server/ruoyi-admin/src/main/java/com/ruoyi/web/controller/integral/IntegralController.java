package com.ruoyi.web.controller.integral;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.integral.domain.Integral;
import com.ruoyi.integral.service.IIntegralService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 积分 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
@Controller
@RequestMapping("/integral/integral")
public class IntegralController extends BaseController
{
    private String prefix = "integral/integral";
	
	@Autowired
	private IIntegralService integralService;
	
	@RequiresPermissions("integral:integral:view")
	@GetMapping()
	public String integral()
	{
	    return prefix + "/integral";
	}
	
	/**
	 * 查询积分列表
	 */
	@RequiresPermissions("integral:integral:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Integral integral)
	{
		startPage();
        List<Integral> list = integralService.selectIntegralList(integral);
		return getDataTable(list);
	}
	
	/**
	 * 新增积分
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存积分
	 */
	@RequiresPermissions("integral:integral:add")
	@Log(title = "积分", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Integral integral)
	{		
		return toAjax(integralService.insertIntegral(integral));
	}

	/**
	 * 修改积分
	 */
	@GetMapping("/edit/{integralId}")
	public String edit(@PathVariable("integralId") Integer integralId, ModelMap mmap)
	{
		Integral integral = integralService.selectIntegralById(integralId);
		mmap.put("integral", integral);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存积分
	 */
	@RequiresPermissions("integral:integral:edit")
	@Log(title = "积分", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Integral integral)
	{		
		return toAjax(integralService.updateIntegral(integral));
	}
	
	/**
	 * 删除积分
	 */
	@RequiresPermissions("integral:integral:remove")
	@Log(title = "积分", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(integralService.deleteIntegralByIds(ids));
	}
	
}
