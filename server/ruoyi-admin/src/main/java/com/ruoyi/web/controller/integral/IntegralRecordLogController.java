package com.ruoyi.web.controller.integral;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.integral.domain.IntegralRecordLog;
import com.ruoyi.integral.service.IIntegralRecordLogService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * 商品兑换记录日志 信息操作处理
 * 
 * @author sunli
 * @date 2018-11-03
 */
@Controller
@RequestMapping("/integral/integralRecordLog")
public class IntegralRecordLogController extends BaseController
{
    private String prefix = "integral/integralRecordLog";
	
	@Autowired
	private IIntegralRecordLogService integralRecordLogService;
	
	@RequiresPermissions("integral:integralRecordLog:view")
	@GetMapping()
	public String integralRecordLog()
	{
	    return prefix + "/integralRecordLog";
	}
	
	/**
	 * 查询商品兑换记录日志列表
	 */
	@RequiresPermissions("integral:integralRecordLog:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(IntegralRecordLog integralRecordLog)
	{
		startPage();
        List<IntegralRecordLog> list = integralRecordLogService.selectIntegralRecordLogList(integralRecordLog);
		Collections.reverse(list);
        return getDataTable(list);
	}
	
	/**
	 * 新增商品兑换记录日志
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商品兑换记录日志
	 */
	@RequiresPermissions("integral:integralRecordLog:add")
	@Log(title = "商品兑换记录日志", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(IntegralRecordLog integralRecordLog)
	{		
		return toAjax(integralRecordLogService.insertIntegralRecordLog(integralRecordLog));
	}

	/**
	 * 修改商品兑换记录日志
	 */
	@GetMapping("/edit/{recordLogId}")
	public String edit(@PathVariable("recordLogId") Integer recordLogId, ModelMap mmap)
	{
		IntegralRecordLog integralRecordLog = integralRecordLogService.selectIntegralRecordLogById(recordLogId);
		mmap.put("integralRecordLog", integralRecordLog);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品兑换记录日志
	 */
	@RequiresPermissions("integral:integralRecordLog:edit")
	@Log(title = "商品兑换记录日志", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(IntegralRecordLog integralRecordLog)
	{		
		return toAjax(integralRecordLogService.updateIntegralRecordLog(integralRecordLog));
	}
	
	/**
	 * 删除商品兑换记录日志
	 */
	@RequiresPermissions("integral:integralRecordLog:remove")
	@Log(title = "商品兑换记录日志", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(integralRecordLogService.deleteIntegralRecordLogByIds(ids));
	}
	
}
