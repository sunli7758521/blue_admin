package com.ruoyi.web.controller.integral;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.integral.domain.IntegralJk;
import com.ruoyi.integral.service.IIntegralJkService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 积分奖扣 信息操作处理
 * 
 * @author sunli
 * @date 2018-10-25
 */
@Controller
@RequestMapping("/integral/integralJk")
public class IntegralJkController extends BaseController
{
    private String prefix = "integral/integralJk";
	
	@Autowired
	private IIntegralJkService integralJkService;
	
	@RequiresPermissions("integral:integralJk:view")
	@GetMapping()
	public String integralJk()
	{
	    return prefix + "/integralJk";
	}
	
	/**
	 * 查询积分奖扣列表
	 */
	@RequiresPermissions("integral:integralJk:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(IntegralJk integralJk)
	{
		startPage();
        List<IntegralJk> list = integralJkService.selectIntegralJkList(integralJk);
		return getDataTable(list);
	}
	
	/**
	 * 新增积分奖扣
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
	    return prefix + "/add";
	}
	

	/**
	 * 修改积分奖扣
	 */
	@GetMapping("/edit/{jkId}")
	public String edit(@PathVariable("jkId") String jkId, ModelMap mmap)
	{
		IntegralJk integralJk = integralJkService.selectIntegralJkById(Integer.parseInt(jkId));
		mmap.put("integralJk", integralJk);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存积分奖扣
	 */
	@RequiresPermissions("integral:integralJk:edit")
	@Log(title = "积分奖扣", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(IntegralJk integralJk)
	{		
		return toAjax(integralJkService.updateIntegralJk(integralJk));
	}
	
	/**
	 * 删除积分奖扣
	 */
	@RequiresPermissions("integral:integralJk:remove")
	@Log(title = "积分奖扣", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(integralJkService.deleteIntegralJkByIds(ids));
	}
	/**
	 * 批量添加用户积分奖扣
	 */
	@GetMapping("/addAll")
	public String addAll()
	{
		return prefix + "/addAll";
	}


}
