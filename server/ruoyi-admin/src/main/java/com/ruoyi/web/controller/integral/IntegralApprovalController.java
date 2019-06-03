package com.ruoyi.web.controller.integral;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.integral.domain.IntegralApproval;
import com.ruoyi.integral.domain.IntegralType;
import com.ruoyi.integral.service.IIntegralApprovalService;
import com.ruoyi.integral.service.IIntegralTypeService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 审批管理 信息操作处理
 * 
 * @author sunli
 * @date 2018-10-24
 */
@Controller
@RequestMapping("/integral/integralApproval")
public class IntegralApprovalController extends BaseController
{
    private String prefix = "integral/integralApproval";
	
	@Autowired
	private IIntegralApprovalService integralApprovalService;
	@Autowired
	private IIntegralTypeService iIntegralTypeService;
	
	@RequiresPermissions("integral:integralApproval:view")
	@GetMapping()
	public String integralApproval()
	{
	    return prefix + "/integralApproval";
	}
	
	/**
	 * 查询审批管理列表
	 */
	@RequiresPermissions("integral:integralApproval:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(IntegralApproval integralApproval)
	{
		startPage();
        List<IntegralApproval> list = integralApprovalService.selectIntegralApprovalList(integralApproval);
        return getDataTable(list);
	}
	
	/**
	 * 新增审批管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存审批管理
	 */
	@RequiresPermissions("integral:integralApproval:add")
	@Log(title = "审批管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(IntegralApproval integralApproval)
	{		
		return toAjax(integralApprovalService.insertIntegralApproval(integralApproval));
	}

	/**
	 * 修改审批管理
	 */
	@GetMapping("/edit/{approvalId}")
	public String edit(@PathVariable("approvalId") Integer approvalId, ModelMap mmap)
	{
		IntegralApproval integralApproval = integralApprovalService.selectIntegralApprovalById(approvalId);
				List<String> list = new ArrayList<>();
	          String[] img = integralApproval.getApprovalImg1().split(",");
				for (String s : img) {
					list.add(s);
				}
		mmap.put("integralApproval", integralApproval);
		mmap.put("list", list);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存审批管理
	 */
	@RequiresPermissions("integral:integralApproval:edit")
	@Log(title = "审批管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(IntegralApproval integralApproval)
	{		
		return toAjax(integralApprovalService.updateIntegralApproval(integralApproval));
	}
	
	/**
	 * 删除审批管理
	 */
	@RequiresPermissions("integral:integralApproval:remove")
	@Log(title = "审批管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(integralApprovalService.deleteIntegralApprovalByIds(ids));
	}

	/**
	 *  审批通过   修改审批状态 添加用户积分
	 */
	@RequiresPermissions("integral:integralApproval:success")
	@Log(title = "审批管理", businessType = BusinessType.OTHER)
	@GetMapping("/success/{approvalId}/{status}")
	@ResponseBody
	public AjaxResult successStatus(@PathVariable("approvalId") String approvalId,@PathVariable("status") String status)
	{
		return toAjax(integralApprovalService.successStatus( Integer.parseInt(approvalId),Integer.parseInt(status)));
	}

	/**
	 * 积分审批导出
	 */
	@Log(title = "积分审批", businessType = BusinessType.EXPORT)
	@RequiresPermissions("integral:integralApproval:export")
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(IntegralApproval integralApproval){
		List<IntegralApproval> list = integralApprovalService.selectIntegralApprovalList(integralApproval);
		List<IntegralApproval> listia = new ArrayList<IntegralApproval>();
		for(IntegralApproval ia : list){
			Date sqtime = ia.getSqTime();
			Date spTime = ia.getSpTime();
			Integer typeid = ia.getTypeId();
			Integer status = ia.getStatus();
			String sqdate = null;
			String spdate = null;
			String spzt = null;
			if(sqtime!=null)
				sqdate = DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss",sqtime);
			if(spTime!=null)
				spdate = DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss",spTime);
			if(status==0){
				spzt = "审批中";
			}else if(status==1){
				spzt = "已通过";
			}else if(status==2){
				spzt = "拒绝";
			}else if(status==3){
				spzt = "撤销";
			}
			IntegralType it = iIntegralTypeService.selectIntegralTypeById(typeid);
			if(it!=null)
				ia.setJilx(it.getTypeName());
			ia.setSpDate(spdate);
			ia.setSqDate(sqdate);
			ia.setSpzt(spzt);
			listia.add(ia);
		}
		ExcelUtil<IntegralApproval> util = new ExcelUtil<IntegralApproval>(IntegralApproval.class);
		return util.exportExcel(listia, "积分审批");
	}
}
