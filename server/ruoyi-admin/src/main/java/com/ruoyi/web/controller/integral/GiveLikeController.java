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
import com.ruoyi.integral.domain.GiveLike;
import com.ruoyi.integral.service.IGiveLikeService;
import com.ruoyi.web.core.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;

/**
 * 员工爱心点赞 信息操作处理
 * 
 * @author zhaoyan
 * @date 2018-12-20
 */
@Controller
@RequestMapping("/integral/giveLike")
public class GiveLikeController extends BaseController
{
    private String prefix = "integral/giveLike";
	
	@Autowired
	private IGiveLikeService giveLikeService;
	
	@RequiresPermissions("integral:giveLike:view")
	@GetMapping()
	public String giveLike()
	{
	    return prefix + "/giveLike";
	}
	
	/**
	 * 查询员工爱心点赞列表
	 */
	@RequiresPermissions("integral:giveLike:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(GiveLike giveLike)
	{
		startPage();
        List<GiveLike> list = giveLikeService.findGiveLikeByUserId(giveLike);
		return getDataTable(list);
	}
	
	/**
	 * 新增员工爱心点赞
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存员工爱心点赞
	 */
	@RequiresPermissions("integral:giveLike:add")
	@Log(title = "员工爱心点赞", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(GiveLike giveLike)
	{		
		return toAjax(giveLikeService.insertGiveLike(giveLike));
	}

	/**
	 * 修改员工爱心点赞
	 */
	@GetMapping("/edit/{dId}")
	public String edit(@PathVariable("dId") Integer dId, ModelMap mmap)
	{
		GiveLike giveLike = giveLikeService.selectGiveLikeById(dId);
		mmap.put("giveLike", giveLike);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存员工爱心点赞
	 */
	@RequiresPermissions("integral:giveLike:edit")
	@Log(title = "员工爱心点赞", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(GiveLike giveLike)
	{		
		return toAjax(giveLikeService.updateGiveLike(giveLike));
	}
	
	/**
	 * 删除员工爱心点赞
	 */
	@RequiresPermissions("integral:giveLike:remove")
	@Log(title = "员工爱心点赞", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(giveLikeService.deleteGiveLikeByIds(ids));
	}
	
}
