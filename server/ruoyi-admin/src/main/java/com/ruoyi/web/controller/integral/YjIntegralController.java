package com.ruoyi.web.controller.integral;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.integral.domain.YjIntegral;
import com.ruoyi.integral.service.IYjIntegralService;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 业绩B积分管理 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
@Controller
@RequestMapping("/integral/yjIntegral")
public class YjIntegralController extends BaseController
{
    private String prefix = "integral/yjIntegral";
	
	@Autowired
	private IYjIntegralService yjIntegralService;

	@Autowired
	private ISysDeptService deptService;

	@RequiresPermissions("integral:yjIntegral:view")
	@GetMapping()
	public String yjIntegral()
	{
	    return prefix + "/yjIntegral";
	}
	
	/**
	 * 查询业绩B积分管理列表
	 */
	@RequiresPermissions("integral:yjIntegral:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(YjIntegral yjIntegral)
	{
		startPage();
        List<YjIntegral> list = yjIntegralService.selectYjIntegralList(yjIntegral);
		return getDataTable(list);
	}
	
	/**
	 * 新增业绩B积分管理
	 */
	@GetMapping("/add/{parentId}")
	public String add(@PathVariable("parentId") String parentId, ModelMap mmap)
	{
		mmap.put("dept", deptService.selectDeptById(Long.parseLong(parentId)));
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存业绩B积分管理
	 */
	@RequiresPermissions("integral:yjIntegral:add")
	@Log(title = "业绩B积分管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(YjIntegral yjIntegral)
	{
		yjIntegral.setTypeId(2);
		int i=0;
		String[] deptIds =	yjIntegral.getDeptIds().split(",");
		for (String deptId : deptIds) {
			SysDept dept = deptService.selectDeptById(Long.parseLong(deptId));
			yjIntegral.setDeptId(dept.getDeptId().intValue());
			yjIntegral.setDeptName(dept.getDeptName());
			i = yjIntegralService.insertYjIntegral(yjIntegral);
			if(i>0){
				System.out.println("成功");
			}else {
				System.out.println("失败");
			}
		}
		return toAjax(i);
	}

	/**
	 * 修改业绩B积分管理
	 */
	@GetMapping("/edit/{behaviorId}")
	public String edit(@PathVariable("behaviorId") Integer behaviorId, ModelMap mmap)
	{
		YjIntegral yjIntegral = yjIntegralService.selectYjIntegralById(behaviorId);
		mmap.put("yjIntegral", yjIntegral);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存业绩B积分管理
	 */
	@RequiresPermissions("integral:yjIntegral:edit")
	@Log(title = "业绩B积分管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(YjIntegral yjIntegral)
	{

		int b=0;
		YjIntegral yj = new YjIntegral();
		yj.setStatus(yjIntegral.getStatus());
		yj.setMenuType(yjIntegral.getMenuType());
		yj.setCreateTime(yjIntegral.getCreateTime());
		yj.setBehaviorCategory(yjIntegral.getBehaviorCategory());
		yj.setBehaviorContent(yjIntegral.getBehaviorContent());
		yj.setUpdateTime(DateUtils.getNowDate());
		yj.setBehaviorTitle(yjIntegral.getBehaviorTitle());
		yj.setIntegralFenJi(yjIntegral.getIntegralFenJi());
		yj.setMenuId(yjIntegral.getMenuId());
		yj.setShenQingFangShi(yjIntegral.getShenQingFangShi());
		yj.setZuiDuoIntegral(yjIntegral.getZuiDuoIntegral());
		yj.setZuiShaoIntegral(yjIntegral.getZuiShaoIntegral());
		yj.setPostId(yjIntegral.getPostId());
		yj.setPostName(yjIntegral.getPostName());
		yj.setRemark(yjIntegral.getRemark());
		yj.setDeptIds(yjIntegral.getDeptIds());
		yjIntegral.setMenuId(yjIntegral.getMenuId());

		int ii =	yjIntegralService.deleteYJIntegralById(yjIntegral.getBehaviorId());
		String[] deptIds =	yj.getDeptIds().split(",");
		for (String deptId : deptIds) {
			SysDept dept = deptService.selectDeptById(Long.parseLong(deptId));
			yj.setDeptId(dept.getDeptId().intValue());
			yj.setDeptName(dept.getDeptName());

			b =	yjIntegralService.insertYjIntegral(yj);
			if(b>0){
				System.out.println("成功");
			}else {
				System.out.println("失败");
			}
		}
		return toAjax(b);

	}
	
	/**
	 * 删除业绩B积分管理
	 */
	@RequiresPermissions("integral:yjIntegral:remove")
	@Log(title = "业绩B积分管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(yjIntegralService.deleteYjIntegralByIds(ids));
	}

	/**
	 * 禁用业绩B积分管理
	 */
	@GetMapping("/integralTy/{behaviorId}/{status}")
	@ResponseBody
	public AjaxResult integralTyBehaviorId(@PathVariable("behaviorId") Integer behaviorId,@PathVariable("status") Integer status , ModelMap mmap)
	{
		return toAjax(yjIntegralService.integralTyBehaviorId(behaviorId,status));
	}
	
}
