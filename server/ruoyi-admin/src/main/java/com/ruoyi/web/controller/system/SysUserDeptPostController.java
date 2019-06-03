package com.ruoyi.web.controller.system;

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
import com.ruoyi.system.domain.SysUserDeptPost;
import com.ruoyi.system.service.ISysUserDeptPostService;
import com.ruoyi.web.core.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;

/**
 * 用户属于那个部门管理那个部门 信息操作处理
 * 
 * @author sunli
 * @date 2018-12-27
 */
@Controller
@RequestMapping("/system/sysUserDeptPost")
public class SysUserDeptPostController extends BaseController
{
    private String prefix = "system/sysUserDeptPost";
	
	@Autowired
	private ISysUserDeptPostService sysUserDeptPostService;
	
	@RequiresPermissions("system:sysUserDeptPost:view")
	@GetMapping()
	public String sysUserDeptPost()
	{
	    return prefix + "/sysUserDeptPost";
	}

	/** 跳转查看管理 部门 */
	@GetMapping("/selectDeptList/{userId}")
	public String  selectDeptList(@PathVariable("userId") Long userId,ModelMap modelMap)
	{
		modelMap.put("userId",userId);
		return prefix + "/sysUserDeptPost";
	}


//	/** 查看 所管理的部门 */
//	@GetMapping("/selectDeptList/{userId}")
//	public String  selectDeptList(@PathVariable("userId") Long userId,ModelMap modelMap)
//	{
//		StringBuffer sb = new StringBuffer();
//
//		List<SysUserDeptPost> list = sysUserDeptPostService.selectUserDepts(userId);
//		if(list.size()>0){
//			for (SysUserDeptPost userDeptPost : list) {
//				sb.append(userDeptPost.getDeptName()+",");
//			}
//		}
//		modelMap.put("userId",userId);
//		modelMap.put("sb",sb);
//		return prefix + "/editDepts";
//	}


	/**
	 * 查询用户属于那个部门管理那个部门列表
	 */
	@RequiresPermissions("system:sysUserDeptPost:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SysUserDeptPost sysUserDeptPost)
	{
		startPage();
        List<SysUserDeptPost> list = sysUserDeptPostService.selectSysUserDeptPostList(sysUserDeptPost);
		return getDataTable(list);
	}
	
	/**
	 * 新增用户属于那个部门管理那个部门
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户属于那个部门管理那个部门
	 */
	@RequiresPermissions("system:sysUserDeptPost:add")
	@Log(title = "用户属于那个部门管理那个部门", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SysUserDeptPost sysUserDeptPost)
	{		
		return toAjax(sysUserDeptPostService.insertSysUserDeptPost(sysUserDeptPost));
	}

	/**
	 * 修改用户属于那个部门管理那个部门
	 */
	@GetMapping("/edit/{udId}")
	public String edit(@PathVariable("udId") Integer udId, ModelMap mmap)
	{
		SysUserDeptPost sysUserDeptPost = sysUserDeptPostService.selectSysUserDeptPostById(udId);
		mmap.put("sysUserDeptPost", sysUserDeptPost);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户属于那个部门管理那个部门
	 */
	@RequiresPermissions("system:sysUserDeptPost:edit")
	@Log(title = "用户属于那个部门管理那个部门", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SysUserDeptPost sysUserDeptPost)
	{		
		return toAjax(sysUserDeptPostService.updateSysUserDeptPost(sysUserDeptPost));
	}
	
	/**
	 * 删除用户属于那个部门管理那个部门
	 */
	@RequiresPermissions("system:sysUserDeptPost:remove")
	@Log(title = "用户属于那个部门管理那个部门", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(sysUserDeptPostService.deleteSysUserDeptPostByIds(ids));
	}
	
}
