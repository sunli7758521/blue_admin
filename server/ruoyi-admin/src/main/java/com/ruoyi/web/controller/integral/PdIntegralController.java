package com.ruoyi.web.controller.integral;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.integral.domain.PdIntegral;
import com.ruoyi.integral.service.IPdIntegralService;
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
 * 品德A积分管理 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
@Controller
@RequestMapping("/integral/pdIntegral")
public class PdIntegralController extends BaseController
{
    private String prefix = "integral/pdIntegral";
	
	@Autowired
	private IPdIntegralService pdIntegralService;

	@Autowired
	private ISysDeptService deptService;

	@RequiresPermissions("integral:pdIntegral:view")
	@GetMapping()
	public String pdIntegral()
	{
	    return prefix + "/pdIntegral";
	}
	
	/**
	 * 查询品德A积分管理列表
	 */
	@RequiresPermissions("integral:pdIntegral:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(PdIntegral pdIntegral)
	{
		startPage();
        List<PdIntegral> list = pdIntegralService.selectPdIntegralList(pdIntegral);
		return getDataTable(list);
	}
	
	/**
	 * 新增品德A积分管理
	 */
	@GetMapping("/add/{parentId}")
	public String add(@PathVariable("parentId") String parentId, ModelMap mmap)
	{
		mmap.put("dept", deptService.selectDeptById(Long.parseLong(parentId)));
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存品德A积分管理
	 */
	@RequiresPermissions("integral:pdIntegral:add")
	@Log(title = "品德A积分管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(PdIntegral pdIntegral)
	{
		pdIntegral.setTypeId(1);
		int i=0;
		String[] deptIds =	pdIntegral.getDeptIds().split(",");
		for (String deptId : deptIds) {
			SysDept dept = deptService.selectDeptById(Long.parseLong(deptId));
			pdIntegral.setDeptId(dept.getDeptId().intValue());
			pdIntegral.setDeptName(dept.getDeptName());
			i = pdIntegralService.insertPdIntegral(pdIntegral);
			if(i>0){
				System.out.println("成功");
			}else {
				System.out.println("失败");
			}
		}
		return toAjax(i);
	}

	/**
	 * 修改品德A积分管理
	 */
	@GetMapping("/edit/{behaviorId}")
	public String edit(@PathVariable("behaviorId") Integer behaviorId, ModelMap mmap)
	{
		PdIntegral pdIntegral = pdIntegralService.selectPdIntegralById(behaviorId);
		mmap.put("pdIntegral", pdIntegral);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存品德A积分管理
	 */
	@RequiresPermissions("integral:pdIntegral:edit")
	@Log(title = "品德A积分管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(PdIntegral pdIntegral)
	{
		int b=0;
		PdIntegral pd = new PdIntegral();
		pd.setStatus(pdIntegral.getStatus());
		pd.setMenuType(pdIntegral.getMenuType());
		pd.setCreateTime(pdIntegral.getCreateTime());
		pd.setBehaviorCategory(pdIntegral.getBehaviorCategory());
		pd.setBehaviorContent(pdIntegral.getBehaviorContent());
		pd.setUpdateTime(DateUtils.getNowDate());
		pd.setBehaviorTitle(pdIntegral.getBehaviorTitle());
		pd.setIntegralFenJi(pdIntegral.getIntegralFenJi());
		pd.setMenuId(pdIntegral.getMenuId());
		pd.setShenQingFangShi(pdIntegral.getShenQingFangShi());
		pd.setZuiDuoIntegral(pdIntegral.getZuiDuoIntegral());
		pd.setZuiShaoIntegral(pdIntegral.getZuiShaoIntegral());
		pd.setPostId(pdIntegral.getPostId());
		pd.setPostName(pdIntegral.getPostName());
		pd.setRemark(pdIntegral.getRemark());
		pd.setDeptIds(pdIntegral.getDeptIds());

		int ii =	pdIntegralService.deletePdIntegralById(pdIntegral.getBehaviorId());
		String[] deptIds =	pd.getDeptIds().split(",");
		for (String deptId : deptIds) {
			SysDept dept = deptService.selectDeptById(Long.parseLong(deptId));
			pd.setDeptId(dept.getDeptId().intValue());
			pd.setDeptName(dept.getDeptName());

			b =	pdIntegralService.insertPdIntegral(pd);
			if(b>0){
				System.out.println("成功");
			}else {
				System.out.println("失败");
			}
		}
		return toAjax(b);

		//return toAjax(pdIntegralService.updatePdIntegral(pdIntegral));
	}
	
	/**
	 * 删除品德A积分管理
	 */
	@RequiresPermissions("integral:pdIntegral:remove")
	@Log(title = "品德A积分管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(pdIntegralService.deletePdIntegralByIds(ids));
	}

	/**
	 * 禁用品德A积分管理
	 */
	@GetMapping("/integralTy/{behaviorId}/{status}")
	@ResponseBody
	public AjaxResult integralTyBehaviorId(@PathVariable("behaviorId") Integer behaviorId, @PathVariable("status") Integer status, ModelMap mmap)
	{
		return toAjax(pdIntegralService.integralTyBehaviorId(behaviorId,status));
	}
}
