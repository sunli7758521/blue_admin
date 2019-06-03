package com.ruoyi.web.controller.integral;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.integral.domain.IntegralRecord;
import com.ruoyi.integral.service.IIntegralRecordService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * 商品兑换记录 信息操作处理
 * 
 * @author sunli
 * @date 2018-10-30
 */
@Controller
@RequestMapping("/integral/integralRecord")
public class IntegralRecordController extends BaseController
{
    private String prefix = "integral/integralRecord";
	
	@Autowired
	private IIntegralRecordService integralRecordService;
	
	@RequiresPermissions("integral:integralRecord:view")
	@GetMapping()
	public String integralRecord()
	{
	    return prefix + "/integralRecord";
	}
	
	/**
	 * 查询商品兑换记录列表
	 */
	@RequiresPermissions("integral:integralRecord:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(IntegralRecord integralRecord)
	{
		startPage();
        List<IntegralRecord> list = integralRecordService.selectIntegralRecordList(integralRecord);
		Collections.reverse(list);
		return getDataTable(list);
	}
	
	/**
	 * 新增商品兑换记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商品兑换记录
	 */
	@RequiresPermissions("integral:integralRecord:add")
	@Log(title = "商品兑换记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(IntegralRecord integralRecord)
	{		
		return toAjax(integralRecordService.insertIntegralRecord(integralRecord));
	}

	/**
	 * 修改商品兑换记录
	 */
	@GetMapping("/edit/{recordId}")
	public String edit(@PathVariable("recordId") Integer recordId, ModelMap mmap)
	{
		IntegralRecord integralRecord = integralRecordService.selectIntegralRecordById(recordId);
		mmap.put("integralRecord", integralRecord);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品兑换记录
	 */
	@RequiresPermissions("integral:integralRecord:edit")
	@Log(title = "商品兑换记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(IntegralRecord integralRecord)
	{		
		return toAjax(integralRecordService.updateIntegralRecord(integralRecord));
	}
	
	/**
	 * 删除商品兑换记录
	 */
	@RequiresPermissions("integral:integralRecord:remove")
	@Log(title = "商品兑换记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(integralRecordService.deleteIntegralRecordByIds(ids));
	}

	/**
	 * 修改审批状态 添加商品记录日志 以及修改商品所对应的积分
	 */
	@RequiresPermissions("integral:integralRecord:success")
	@Log(title = "审批管理", businessType = BusinessType.OTHER)
	@GetMapping("/success/{approvalId}/{status}")
	@ResponseBody
	public AjaxResult successStatus(@PathVariable("approvalId") String recordId,@PathVariable("status") String status)
	{
		return toAjax(integralRecordService.successStatus( Integer.parseInt(recordId),Integer.parseInt(status)));
	}

}
